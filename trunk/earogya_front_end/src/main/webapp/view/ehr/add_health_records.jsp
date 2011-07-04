<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Arogya Health Records</title>
<sx:head/>
</head>
<body>
<s:if test="%{#session.logged_in}">
	<table>
		<tr>
			<td width="50%" align="right"><s:text name="logged_user"/> :<s:property value="%{#session.name}"/>(<s:property value="%{#session.group}"/>)</td>
			<td width="25%" align="right">Session time: <%= new Date(session.getLastAccessedTime())%></td>
			<td width="25%" align="right"><a href="<s:url action='logout'/>"><s:text name="logout"></s:text></a></td>
		</tr>
	</table>

<%@ include file="/view/template/header.jsp" %>
 <table border="1px" width="88%">
	<tr>
		<td width="20%">
			<table border="1px" bordercolor="#FF0000" width="20%">
				<tr><td><h3><s:text name="search.search_label"/></h3></td></tr>
				<tr><td>
					<s:bean name="java.util.HashMap" id="qTableLayout">
    					<s:param name="tablecolspan" value="%{3}" />
					</s:bean>
					<s:form action="search_patient_id" theme="qxhtml">
						<s:select name="search.searchCategory" list="#{'name': 'name', 'date of birth': 'date of birth', 'nic no': 'nic no'}" headerKey="1" headerValue="---Select Category---"/>
						<s:textfield name="search.searchValue"/>
						<s:submit key="search.search_button" align="center"/>
					</s:form>
				</td></tr>
				<s:if test="%{results.isResults}">
				<tr><td><h3>
				<s:text name="search.results"/></h3>
				<s:property value="results.searchResults"/>
				</td></tr>
				</s:if>
			</table>
		</td>
		<td width="80%">
		 	<s:bean name="java.util.HashMap" id="qTableLayout">
    			<s:param name="tablecolspan" value="%{6}" />
			</s:bean>

			<s:form action="add_health_records_form">
				<tr><th align="left"  bgcolor="#ddd"><s:text name="medicalRecords.patient_information" /></th> </tr>
				<s:textfield key="medicalRecords.patientId" theme="qxhtml" size="30" required="true">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<tr><th align="left"  bgcolor="#ddd"><s:text name="medicalRecords.observation_information" /></th> </tr>
				<s:textfield key="medicalRecords.observation" theme="qxhtml" size="70">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{4}" />
				</s:textfield>
				<s:textfield key="medicalRecords.observerId" theme="qxhtml" size="30">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<sx:datetimepicker key="medicalRecords.observationdate" adjustWeeks="true" template="datetimepicker"/>
				<tr><th align="left"  bgcolor="#ddd"><s:text name="medicalRecords.diagosis_information" /></th> </tr>
				<s:textfield key="medicalRecords.diagosis" theme="qxhtml" size="70">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{4}" />
				</s:textfield>
				<s:textfield key="medicalRecords.diagnosingClinicianId" theme="qxhtml" size="30">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<sx:datetimepicker key="medicalRecords.diagnosingDate" adjustWeeks="true" template="datetimepicker"/>
				<s:submit key="medicalRecords.submit" theme="qxhtml" align="center"/>
			</s:form>
	
			<s:if test="%{message.message!=empty}">
				<s:property value="message.message"/>
			</s:if> 
		</td>
	</tr>
</table>

 </s:if>
 <s:else>
 	<jsp:forward page="/index.jsp"/>
 </s:else>
 
</body>
</html>