package earogya.logic.medical_records;

import java.util.Calendar;

import org.apache.struts.ehr.medical_records.model.AdmitPatient;
import org.apache.struts.ehr.medical_records.model.Guardian;
import org.apache.struts.ehr.medical_records.model.Address;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v251.datatype.ST;
import ca.uhn.hl7v2.model.v251.message.ADT_A01;

public class CreateADT01 {

	private ADT_A01 adt;
	private AdmitPatient admit;
	
	public CreateADT01(AdmitPatient admit){
		this.adt=new ADT_A01();
		this.admit=admit;
	}
	
	public String createMessage(String sendingFacility) throws HL7Exception{
		this.addMessageHeader(sendingFacility);
		this.addAdmissionInformation();
		this.addDiagnosisAndObservation();
		this.addGuardianInformation();
		return adt.getMessage().encode();
	}
	
	private void addMessageHeader(String sendingFacility) throws DataTypeException{
		adt.getMSH().getFieldSeparator().setValue("|");
		adt.getMSH().getEncodingCharacters().setValue("^~\\&");
		adt.getMSH().getDateTimeOfMessage().getTime().setValue(Calendar.getInstance().getTime());
		adt.getMSH().getMessageType().getMsg1_MessageCode().setValue("ADT");
		adt.getMSH().getMessageType().getTriggerEvent().setValue("A01");
		adt.getMSH().getSendingApplication().getUniversalID().setValue("EAFE");
		adt.getMSH().getSendingFacility().getUniversalID().setValue(sendingFacility);
		adt.getMSH().getReceivingApplication().getUniversalID().setValue("PVS");
		adt.getMSH().getReceivingFacility().getUniversalID().setValue(sendingFacility);
	}
	
	private void addAdmissionInformation() throws DataTypeException{
		adt.getPID().getPatientID().getIDNumber().setValue(admit.getPatient_id());
		adt.getPV1().getAdmittingDoctor(0).getIDNumber().setValue(admit.getAdmiting_officer());
		adt.getPV1().getAdmitDateTime().getTime().setValue(admit.getAdmission_date());
		adt.getPV1().getAssignedPatientLocation().getBed().setValue(admit.getBed());
		adt.getPV1().getAssignedPatientLocation().getRoom().setValue(admit.getWard());
		adt.getPV1().getConsultingDoctor(0).getIDNumber().setValue(admit.getConsultant_id());
		adt.getPV2().getAdmitReason().getText().setValue(admit.getAdmit_reason());
	}
	
	private void addDiagnosisAndObservation() throws DataTypeException{
		adt.getDG1().getDiagnosisDateTime().getTime().setValue(admit.getAdmission_date());
		adt.getDG1().getDiagnosisDescription().setValue(admit.getDiagnosis());
		adt.getDG1().getDiagnosingClinician(0).getIDNumber().setValue(admit.getConsultant_id());
		
		adt.getOBX().getValueType().setValue("ST");
		ST st=new ST(adt);
		st.setValue(admit.getObservation());
		adt.getOBX().getObservationValue(0).setData(st);
		adt.getOBX().getResponsibleObserver(0).getIDNumber().setValue(admit.getAdmiting_officer());
		adt.getOBX().getDateTimeOfTheObservation().getTime().setValue(admit.getAdmission_date());
	}

	
	private void addGuardianInformation() throws DataTypeException{
		Guardian guardian=admit.getGuardian();
		adt.getNK1().getNK1Name(0).getPrefixEgDR().setValue(guardian.getPrefix());
		adt.getNK1().getNK1Name(0).getGivenName().setValue(guardian.getGiven_name());
		adt.getNK1().getNK1Name(0).getFamilyName().getSurname().setValue(guardian.getSurname());
		adt.getNK1().getNK1Name(0).getSecondAndFurtherGivenNamesOrInitialsThereof().setValue(guardian.getFurthur_names());
		adt.getNK1().getContactPersonSocialSecurityNumber().setValue(guardian.getNic_no());
		adt.getNK1().getPhoneNumber(0).getEmailAddress().setValue(guardian.getEmail());
		adt.getNK1().getPhoneNumber(0).getTelephoneNumber().setValue(guardian.getTelephoneNumbers());
		
		Address address=guardian.getAddresses();
		adt.getNK1().getAddress(0).getStreetAddress().getDwellingNumber().setValue(address.getHouse_number());
		adt.getNK1().getAddress(0).getStreetAddress().getStreetName().setValue(address.getStreet());
		adt.getNK1().getAddress(0).getOtherDesignation().setValue(address.getCity_1());
		adt.getNK1().getAddress(0).getCity().setValue(address.getCity_2());
		adt.getNK1().getAddress(0).getCountry().setValue(address.getCountry());
	}

}
