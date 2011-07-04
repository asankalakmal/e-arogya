<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admit Patient</title>
<sx:head />
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
			<s:form action="admit_patient_form">
			<tr><th align="left"  bgcolor="#ddd"><s:text name="admit.admission_information" /></th> </tr>
				<s:textfield key="admit.patient_id" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" /> 
				</s:textfield>
				<s:textfield key="admit.admiting_officer" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.bed" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.ward" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.admit_reason" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.consultant_id" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<sx:datetimepicker key="admit.admission_date" adjustWeeks="true" toggleType="wipe"/>
				<s:textfield key="admit.diagnosis" size="70" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}" /> 
    				<s:param name="inputcolspan" value="%{5}" />
				</s:textfield>
				<s:textfield key="admit.observation" size="70" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{5}" />
				</s:textfield>
				<tr><th align="left" bgcolor="#ddd"><s:text name="admit.guardian_information"/></th> </tr>
				<s:select key="admit.guardian.prefix" list="#{'Rev.': 'Rev.', 'Dr.': 'Dr.', 'Mr.': 'Mr.', 'Mrs.': 'Mrs.', 'Miss.': 'Miss.'}" headerKey="1" headerValue="---Select Prefix---" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:select>
				<s:textfield key="admit.guardian.given_name" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.furthur_names" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.surname" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.nic_no" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<tr><th align="left" bgcolor="#ddd"><s:text name="admit.guardian_contact_details_address"/></th></tr>
				<s:textfield key="admit.guardian.addresses.house_number" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.addresses.street" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.addresses.city_1" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.addresses.city_2" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.addresses.country" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<tr><th align="left" bgcolor="#ddd"><s:text name="admit.guardian_contact_details_other"/></th></tr>
				<s:textfield key="admit.guardian.telephoneNumbers" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:textfield key="admit.guardian.email" size="30" theme="qxhtml">
					<s:param name="labelcolspan" value="%{1}"/> 
    				<s:param name="inputcolspan" value="%{3}" />
				</s:textfield>
				<s:submit key="admit.submit" theme="qxhtml"/>
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