package org.apache.struts.ehr.patient_details.model;

public class SearchResults {

	private String searchCategory;
	private String searchValue;
	private String searchResults;
	private Boolean isResults=false;
	
	public Boolean getIsResults() {
		return isResults;
	}
	
	public String getSearchResults() {
		return searchResults;
	}
	public SearchResults(String searchCategory, String searchValue){
		this.searchCategory=searchCategory;
		this.searchValue=searchValue;
	}
	
	public void processResults(){
		searchResults="results for "+searchCategory+" "+searchValue;
		isResults=true;
	}
}
