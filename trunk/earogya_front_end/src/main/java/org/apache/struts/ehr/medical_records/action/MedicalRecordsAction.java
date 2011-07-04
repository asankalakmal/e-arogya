package org.apache.struts.ehr.medical_records.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts.ehr.medical_records.model.HL7Message;
import org.apache.struts.ehr.medical_records.model.MedicalRecords;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import earogya.logic.medical_records.CreateADT01;
import earogya.logic.medical_records.CreateADTA08;

public class MedicalRecordsAction extends ActionSupport{

	private MedicalRecords medicalRecords;
	private HL7Message message;
	
	public HL7Message getMessage() {
		return message;
	}

	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public String execute() throws Exception {
		Map<String, Object> session=ActionContext.getContext().getSession();
		CreateADTA08 createMessage=new CreateADTA08(medicalRecords);
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
		if(medicalRecords.getPatientId().length()==0){
			addFieldError("medicalRecords.patientId", "This field is required");
		}else if(!this.isInteger(medicalRecords.getPatientId())){
			addFieldError("medicalRecords.patientId", "Incorrect ID format");
		}
		if(medicalRecords.getObservation().length()==0 && medicalRecords.getDiagosis().length()==0){
			addFieldError("medicalRecords.observation", "Either diagosis or observation or both is reuqired");
			addFieldError("medicalRecords.diagosis", "Either diagosis or observation or both is reuqired");
		}
		if(medicalRecords.getObservation().length()>0){
			if(medicalRecords.getObserverId().length()==0){
				addFieldError("medicalRecords.observerId", "This field is required");
			}else if(!this.isInteger(medicalRecords.getObserverId())){
				addFieldError("medicalRecords.observerId", "Incorrect ID format");
			}
			if(medicalRecords.getObservationdate()==null){
				addFieldError("medicalRecords.observationdate", "This field is required");
			}
		}
		if(medicalRecords.getDiagosis().length()>0){
			if(medicalRecords.getDiagnosingClinicianId().length()==0){
				addFieldError("medicalRecords.diagnosingClinicianId", "This field is required");
			}else if(!this.isInteger(medicalRecords.getDiagnosingClinicianId())){
				addFieldError("medicalRecords.diagnosingClinicianId", "Incorrect ID format");
			}
			if(medicalRecords.getDiagnosingDate()==null){
				addFieldError("medicalRecords.diagnosingDate", "This field is required");
			}
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
}
