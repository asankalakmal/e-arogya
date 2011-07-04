package org.apache.struts.ehr.medical_records.model;

import java.util.Calendar;
import java.util.Date;

public class AdmitPatient {

	private String patient_id;
	private String admiting_officer;
	private Date admission_date;
	private String bed;
	private String ward;
	private String admit_reason;
	private String consultant_id;
	private String diagnosis;
	private String observation;
	private Guardian guardian;

	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patientId) {
		patient_id = patientId;
	}
	public String getAdmiting_officer() {
		return admiting_officer;
	}
	public void setAdmiting_officer(String admitingOfficer) {
		admiting_officer = admitingOfficer;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getAdmit_reason() {
		return admit_reason;
	}
	public void setAdmit_reason(String admitReason) {
		admit_reason = admitReason;
	}
	public String getConsultant_id() {
		return consultant_id;
	}
	public void setConsultant_id(String consultantId) {
		consultant_id = consultantId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Guardian getGuardian() {
		return guardian;
	}
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	public Date getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(Date admissionDate) {
		admission_date = admissionDate;
	}
	
}
