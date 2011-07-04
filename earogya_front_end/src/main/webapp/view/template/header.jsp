<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="headerStyle.css">
</head>
<body>
<table width="88%">
	<tr>
    	<td width="100%" height="118" align="center">
        	<img name="logo_bar" src="earogya.jpg" width="1090" height="112" alt="logo_and_name" />
        </td>
    </tr>
	<tr>
    	<td width="100%">
        <div id="centeredmenu">
   <ul>
      <li><a href="#"><s:text name="menu.system_admin"/></a>
         <ul>
            <li><a href="#"><s:text name="menu.system_admin.add_user_class"/></a></li>
            <li><a href="#"><s:text name="menu.system_admin.change_user_class_privilages"/></a></li>
            <li><a href="#"><s:text name="menu.system_admin.create_users"/></a></li>
            <li><a href="#"><s:text name="menu.system_admin.add_users_to_user_class"/></a></li>
            <li><a href="#"><s:text name="menu.system_admin.view_log_history"/></a></li>
         </ul>
      </li>
      <li><a href="#"><s:text name="menu.patient_registration"/></a>
         <ul>
            <li><s:url action="add_patient" var="add_patient_action"/><a href="${add_patient_action}"><s:text name="menu.patient_registration.add_patient"/></a></li>
            <li><s:url action="admit_patient" var="admit_patient_action"/><a href="${admit_patient_action}"><s:text name="menu.patient_registration.admit_patient"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.edit_patient_details"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.search_patient"/></a></li>
            <li><s:url action="add_health_records" var="add_health_records_action"/><a href="${add_health_records_action}"><s:text name="menu.patient_registration.add_health_records"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.show_previous_health_records"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.drugs_given_to_a_patient"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.clinical_items_given_to_patient"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.transfer_patient"/></a></li>
            <li><a href="#"><s:text name="menu.patient_registration.discharge_patient"/></a></li>
         </ul>
      </li>
      <li><a href="#"><s:text name="menu.investigations_and_results"/></a>
         <ul>
            <li><a href="#"><s:text name="menu.investigations_and_results.investigation"/></a></li>
            <li><a href="#"><s:text name="menu.investigations_and_results.request"/></a></li>
         </ul>
      </li>
      <li><a href="#"><s:text name="menu.supply_chain"/></a>
         <ul>
            <li><a href="#"><s:text name="menu.supply_chain.new_orders"/></a></li>
            <li><a href="#"><s:text name="menu.supply_chain.view_pending_orders"/></a></li>
            <li><a href="#"><s:text name="menu.supply_chain.view_supply_items_history"/></a></li>
         </ul>
      </li>
      <li><a href="#"><s:text name="menu.support_service"/></a>
         <ul>
            <li><a href="#"><s:text name="menu.support_service.ambulance"/></a></li>
            <li><a href="#"><s:text name="menu.support_service.meals"/></a></li>
            <li><a href="#"><s:text name="menu.support_service.cleaning"/></a></li>
            <li><a href="#"><s:text name="menu.support_service.laundry"/></a></li>
         </ul>
      </li>
      <li><a href="#"><s:text name="menu.death_certification"/></a>
         <ul class="last">
            <li><a href="#"><s:text name="menu.death_certification.issue_death_certificate"/></a></li>
            <li><a href="#"><s:text name="menu.death_certification.inform"/></a></li>
         </ul>
      </li>
   </ul>
</div>
        </td>
    </tr>
</table>
</body>
</body>
</html>