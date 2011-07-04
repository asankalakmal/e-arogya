package org.apache.struts.ehr.login.action;

import java.util.Map;

import org.apache.struts.ehr.login.model.Login;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private Login login;
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String execute() throws Exception {
		if((login.getUsername()).equals("chamendri") && (login.getPassword()).equals("chami")){
			String name="Chamendri Silva";
			String group="Administrator";
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("logged_in", "true");
			session.put("name", name);
			session.put("group", group);
			session.put("facility", "CSTH");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public void validate(){
		if(login.getUsername().length()==0){
			addFieldError( "login.username", "User name is required." );
		}
		if(login.getPassword().length()==0){
			addFieldError( "login.password", "Password is required." );
		}
	}
	
}
