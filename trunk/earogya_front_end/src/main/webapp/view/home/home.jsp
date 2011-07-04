<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Arogya Home</title>
</head>
<body>
<s:if test="%{#session.logged_in}">
	<table>
		<tr>
			<td width="50%" align="right"><s:text name="logged_user"/> :<s:property value="%{#session.name}"/>(<s:property value="%{#session.group}"/>)</td>
			<td width="25%">Session time: <%= new Date(session.getLastAccessedTime())%></td>
			<td width="25%" align="center"><a href="<s:url action='logout'/>"><s:text name="logout"></s:text></a></td>
		</tr>
	</table>

<%@ include file="/view/template/header.jsp" %>
 <h2>username : <s:property value="login.username"/></h2>
  <h2>password : <s:property value="login.password"/></h2>
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
		</td>
	</tr>
</table>
  </s:if><s:else><jsp:forward page="/index.jsp"/></s:else>
</body>
</html>