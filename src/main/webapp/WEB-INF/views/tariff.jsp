<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body">
			
				<form:form method="post" action="${pageContext.request.contextPath}${action}" modelAttribute="tariff">
				
					<div class="form-group">
						<label for="name"><spring:message code="label.name"/></label>
					    <spring:bind path="name">
					    	<input type="text" id="name" name="name" class="form-control" placeholder="<spring:message code="label.name"/>" value="${status.value}" >
					    </spring:bind>
					</div>
					
					<spring:message code="selectService" var="selectService" />
					<div class="form-group">
						<label for="serviceId"><spring:message code="service"/></label>
						<form:select path="serviceId" class="form-control">
							<form:option value="0" label="--${selectService}" />
							<form:options items="${services}" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
					
					<div class="form-group">
						<label for="type"><spring:message code="typeTariff"/></label>
						<form:select path="type" id="type" class="form-control">
							<form:option value="1"><spring:message code="tariffGPS" /></form:option>
							<form:option value="2"><spring:message code="tariffSchedule" /></form:option>
						</form:select>
					</div>
					
					<%-- <div class="checkbox">
						<label>
							<input type="checkbox" name="driverShowToBefore"> <spring:message code="driverShowToBefore" />
						</label>
					</div> --%>
					
					
				</form:form>
					
			</div>
		</div>	
	</jsp:body>
</t:genericpage>