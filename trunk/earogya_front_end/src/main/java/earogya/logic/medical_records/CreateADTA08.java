package earogya.logic.medical_records;

import java.util.Calendar;

import org.apache.struts.ehr.medical_records.model.MedicalRecords;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v251.datatype.ST;
import ca.uhn.hl7v2.model.v251.message.ADT_A01;

public class CreateADTA08 {

	private ADT_A01 adt;
	private MedicalRecords records;
	
	public CreateADTA08(MedicalRecords records){
		this.adt=new ADT_A01();
		this.records=records;
	}
	
	public String createMessage(String sendingFacility) throws HL7Exception{
		this.addMessageHeader(sendingFacility);
		this.addPatientDetails();
		this.addObservationDetails();
		this.addDiagnosisDetails();
		return adt.getMessage().encode();
	}
	
	private void addMessageHeader(String sendingFacility) throws DataTypeException{
		adt.getMSH().getFieldSeparator().setValue("|");
		adt.getMSH().getEncodingCharacters().setValue("^~\\&");
		adt.getMSH().getDateTimeOfMessage().getTime().setValue(Calendar.getInstance().getTime());
		adt.getMSH().getMessageType().getMsg1_MessageCode().setValue("ADT");
		adt.getMSH().getMessageType().getTriggerEvent().setValue("A08");
		adt.getMSH().getSendingApplication().getUniversalID().setValue("EAFE");
		adt.getMSH().getSendingFacility().getUniversalID().setValue(sendingFacility);
		adt.getMSH().getReceivingApplication().getUniversalID().setValue("PVS");
		adt.getMSH().getReceivingFacility().getUniversalID().setValue(sendingFacility);
	}
	
	private void addPatientDetails() throws DataTypeException{
		adt.getPID().getPatientID().getIDNumber().setValue(records.getPatientId());
	}
	
	private void addObservationDetails() throws DataTypeException{
		adt.getOBX().getValueType().setValue("ST");
		ST st=new ST(adt);
		st.setValue(records.getObservation());
		adt.getOBX().getObservationValue(0).setData(st);
		adt.getOBX().getResponsibleObserver(0).getIDNumber().setValue(records.getObserverId());
		adt.getOBX().getDateTimeOfTheObservation().getTime().setValue(records.getObservationdate());
	}
	
	private void addDiagnosisDetails() throws DataTypeException{
		adt.getDG1().getDiagnosisDescription().setValue(records.getDiagosis());
		adt.getDG1().getDiagnosingClinician(0).getIDNumber().setValue(records.getDiagnosingClinicianId());
		adt.getDG1().getDiagnosisDateTime().getTime().setValue(records.getDiagnosingDate());
	}
}
