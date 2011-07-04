package org.apache.struts.ehr.patient_details.action;

import java.util.ArrayList;

import org.apache.struts.ehr.patient_details.model.Search;
import org.apache.struts.ehr.patient_details.model.SearchResults;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{

	private Search search;
	private SearchResults results;

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
	
	public SearchResults getResults(){
		return results;
	}

	public String execute() throws Exception {
		results=new SearchResults(search.getSearchCategory(), search.getSearchValue());
		results.processResults();
		return SUCCESS;
	}
}
