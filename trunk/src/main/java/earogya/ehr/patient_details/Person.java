package main.java.earogya.ehr.patient_details;

import java.util.Date;

public class Person {
	private int personID;
	private String firstName=null;
	private String middleName=null;
	private String surname=null;
	private String fullName=null;
	private String nameWithInitials=null;
	private String gender=null;
	private Date birthTime=null;
	private String maritialState=null;
	private String educationalLevel=null;
	private String livingArrangement=null;
	private String religiousAffliation=null;
	private String race=null;
	private String ethnicGroup=null;
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNameWithInitials() {
		return nameWithInitials;
	}
	public void setNameWithInitials(String nameWithInitials) {
		this.nameWithInitials = nameWithInitials;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthTime() {
		return birthTime;
	}
	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}
	public String getMaritialState() {
		return maritialState;
	}
	public void setMaritialState(String maritialState) {
		this.maritialState = maritialState;
	}
	public String getEducationalLevel() {
		return educationalLevel;
	}
	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}
	public String getLivingArrangement() {
		return livingArrangement;
	}
	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}
	public String getReligiousAffliation() {
		return religiousAffliation;
	}
	public void setReligiousAffliation(String religiousAffliation) {
		this.religiousAffliation = religiousAffliation;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEthnicGroup() {
		return ethnicGroup;
	}
	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

}
