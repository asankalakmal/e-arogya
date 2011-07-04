package org.apache.struts.ehr.medical_records.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts.ehr.medical_records.model.AdmitPatient;
import org.apache.struts.ehr.medical_records.model.HL7Message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import earogya.logic.medical_records.CreateADT01;

public class AdmitPatientAction extends ActionSupport{

	private AdmitPatient admit;
	private HL7Message message;
	private Date date;

	public HL7Message getMessage() {
		return message;
	}

	public AdmitPatient getAdmit() {
		return admit;
	}

	public void setAdmit(AdmitPatient admit) {
		this.admit = admit;
	}

	public String execute() throws Exception {
		Map<String, Object> session=ActionContext.getContext().getSession();
		CreateADT01 createMessage=new CreateADT01(admit);
		String msg=createMessage.createMessage((String)session.get("facility"));
		message=new HL7Message();
		if(!msg.equals(null)){
			message.setMessage(msg);
		}
		else{
			message.setMessage("empty");
		}
		return SUCCESS;
	}
	
	public void validate(){
		if(admit.getPatient_id().length()==0){
			addFieldError( "admit.patient_id", "Patient ID required" );
		}
		else if(!this.isInteger(admit.getPatient_id())){
			addFieldError( "admit.patient_id", "Incorrect patient ID format." );
		}
		if(admit.getAdmiting_officer().length()==0){
			addFieldError("admit.admiting_officer", "Admiting Officer ID required");
		}
		else if(!this.isInteger(admit.getAdmiting_officer())){
			addFieldError("admit.admiting_officer", "Incorrect admiting officer ID format");
		}
		if(!this.isInteger(admit.getBed()) && admit.getBed().length()>0){
			addFieldError("admit.bed", "Incorrect bed");
		}
		if(admit.getWard().length()==0){
			addFieldError("admit.ward", "Ward required");
		}
		else if(!this.isInteger(admit.getWard())){
			addFieldError("admit.ward", "Incorrect ward");
		}
		if(admit.getAdmit_reason().length()==0){
			addFieldError("admit.admit_reason", "Admit reasion required");
		}
		if(admit.getConsultant_id().length()==0){
			addFieldError("admit.consultant_id", "Consulatant ID required");
		}
		else if(!this.isInteger(admit.getConsultant_id())){
			addFieldError("admit.consultant_id", "Incorrect Consultant ID format");
		}
		if(admit.getAdmission_date()==null){
			addFieldError("admit.admission_date", "Admission date cannot be empty");
		}
		if(admit.getObservation().length()==0){
			addFieldError("admit.observation", "Observations cannot be empty");
		}
		if(admit.getGuardian().getPrefix().length()==0){
			addFieldError("admit.guardian.prefix", "Please select a prefix");
		}
		if(admit.getGuardian().getGiven_name().length()==0){
			addFieldError("admit.guardian.given_name", "Please enter a name");
		}
		if(!this.isCorrectNICNo(admit.getGuardian().getNic_no())){
			addFieldError("admit.guardian.nic_no", "Incorrect NIC number");
		}
		if(admit.getGuardian().getAddresses().getHouse_number().length()==0){
			addFieldError("admit.guardian.addresses.house_number", "House number cannot be empty");
		}
		if(admit.getGuardian().getAddresses().getCity_1().length()==0){
			addFieldError("admit.guardian.addresses.city_1", "This field cannot be empty");
		}
		if(!this.isCorrectTelephoneNumber(admit.getGuardian().getTelephoneNumbers()) && admit.getGuardian().getTelephoneNumbers().length()>0){
			addFieldError("admit.guardian.telephoneNumbers", "Incorrect number");
		}
		if(!this.isCorrectEmailAddress(admit.getGuardian().getEmail()) && admit.getGuardian().getEmail().length()>0){
			addFieldError("admit.guardian.email", "Incorrect email");
		}
	}
	
	private Boolean isInteger(String value){
		Boolean isInteger=false;
		try{
			int intValue=Integer.parseInt(value);
			isInteger=true;
		}catch(NumberFormatException e){
			isInteger=false;
		}
		return isInteger;
	}
	
	private Boolean isCorrectNICNo(String nic){
		Boolean isCorrectNicNo=false;
		int length=nic.length();
		if(length==10 && (nic.charAt(9)=='v' || nic.charAt(9)=='V')){
			isCorrectNicNo=true;
		}
		return isCorrectNicNo;
	}
	
	private Boolean isCorrectTelephoneNumber(String number){
		Boolean isCorrectNumber=false;
		String[] numbers=number.split(",");
		for(int i=0; i<numbers.length; i++){
			String num=numbers[i].trim();
			if(num.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
				isCorrectNumber=true;
			}else if(num.matches("[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
				isCorrectNumber=true;
			}
		}
		return isCorrectNumber;
	}
	
	private Boolean isCorrectEmailAddress(String email){
		Boolean isCorrectEmail=false;
		if(email.matches("[0-9a-z]+@[a-z]+.[a-z]+")){
			isCorrectEmail=true;
		}
		return isCorrectEmail;
	}
}
