<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-arogya login</title>
<style type="text/css">
  .label {color:blue; font-style:normal; font-weight:bold}
</style>
<s:head /> 
</head>
<body>
<table width="100%">
	<tr><td width="100%" align="center" height="50">
		<s:action name="logout" executeResult="Successfully Logged Out."></s:action>
	</td></tr>
	<tr><td width="100%" align="center" height="50">
	<table>
		<tr>
			<td width="50%" align="right">
				<s:url action="index" var="login_in_english">
	    			<s:param name="request_locale">en</s:param>
				</s:url>
				<a href="${login_in_english}"><s:text name="english"/></a>
			</td>
			<td width="50%" align="left">
				<s:url action="index" var="login_in_sinhala">
	    			<s:param name="request_locale">si_LK</s:param>
				</s:url>
				<a href="${login_in_sinhala}"><s:text name="sinhala"/></a>
			</td>
		</tr>
	</table>
	</td></tr>
	<tr>
    	<td width="100%" align="center"><img name="logo" src="earogya_logo.jpg" width="250" height="250" alt="earogya logo" /></td>
    </tr>
    <tr>
    	<td width="100%" align="center">
    		<s:form action="login">
    			<s:textfield key="login.username" required="true"/>
    			<s:password key="login.password" required="true"/>
    			<s:submit key="login_button"/>
    		</s:form>
    	</td>
    </tr>  
</table>
</body>
</html>