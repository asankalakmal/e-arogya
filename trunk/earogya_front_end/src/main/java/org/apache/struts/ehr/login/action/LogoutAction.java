package org.apache.struts.ehr.login.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends ActionSupport{

	public String execute() throws Exception{
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.remove("logged_in");
		session.remove("name");
		session.remove("group");
		session.remove("facility");
		return SUCCESS;
	}
}
