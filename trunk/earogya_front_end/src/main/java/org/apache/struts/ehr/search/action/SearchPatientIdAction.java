package org.apache.struts.ehr.search.action;

import java.util.ArrayList;

import org.apache.struts.ehr.search.model.SearchPatientId;
import org.apache.struts.ehr.search.model.SearchPatientIdResults;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPatientIdAction extends ActionSupport{

	private SearchPatientId search;
	private SearchPatientIdResults results;

	public SearchPatientId getSearch() {
		return search;
	}

	public void setSearch(SearchPatientId search) {
		this.search = search;
	}
	
	public SearchPatientIdResults getResults(){
		return results;
	}

	public String execute() throws Exception {
		results=new SearchPatientIdResults(search.getSearchCategory(), search.getSearchValue());
		results.processResults();
		return SUCCESS;
	}
}
