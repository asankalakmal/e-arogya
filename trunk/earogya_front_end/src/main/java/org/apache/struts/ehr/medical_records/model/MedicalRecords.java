package org.apache.struts.ehr.medical_records.model;

import java.util.Date;

public class MedicalRecords {

	private String patientId;
	private String observation;
	private String observerId;
	private Date observationdate;
	private String diagosis;
	private String diagnosingClinicianId;
	private String diagnosingDate;
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getObserverId() {
		return observerId;
	}
	public void setObserverId(String observerId) {
		this.observerId = observerId;
	}
	public String getDiagosis() {
		return diagosis;
	}
	public void setDiagosis(String diagosis) {
		this.diagosis = diagosis;
	}
	public String getDiagnosingClinicianId() {
		return diagnosingClinicianId;
	}
	public void setDiagnosingClinicianId(String diagnosingClinicianId) {
		this.diagnosingClinicianId = diagnosingClinicianId;
	}
	public String getDiagnosingDate() {
		return diagnosingDate;
	}
	public void setDiagnosingDate(String diagnosingDate) {
		this.diagnosingDate = diagnosingDate;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Date getObservationdate() {
		return observationdate;
	}
	public void setObservationdate(Date observationdate) {
		this.observationdate = observationdate;
	}
	
	
}
