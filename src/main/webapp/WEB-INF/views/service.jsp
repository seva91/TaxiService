<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header">
     ${pageContext.request.contextPath}${action}
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    
    <jsp:body>
    
    	<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body">
			
				<form:form method="post" action="${pageContext.request.contextPath}${action}" modelAttribute="service">
				
					<%-- Название --%>
					<spring:message code="label.name" var="nameService"/>
					<div class="form-group">
						<label for="name">${nameService}</label>
						<spring:bind path="name">
					    	<input class="form-control" id="name" name="name" placeholder="${nameService}" value="${status.value}">
					    </spring:bind>
					</div>
					
					<%-- Город --%>
					<spring:message code="label.city" var="cityName"/>
					<div class="form-group">
						<label for="cityId">${cityName}</label>
						<form:select path="cityId" class="form-control" id="cityId">
							<form:option value="0"><spring:message code="selectCity"/></form:option>
							<form:options items="${cities}" itemLabel="name" itemValue="id" />
						</form:select>
					</div>
					
					<div class="form-group">
						<label for="timeZone"><spring:message code="UTC"/></label>
						<spring:bind path="timeZone">
							<input type="text" class="form-control" id="timeZone" name="timeZone" placeholder="<spring:message code="UTC"/>" value="${status.value}" />
						</spring:bind>
					</div>
					
					
					<div class="checkbox">
						<label>
							<form:checkbox path="tariffAutoChange" /> <spring:message code="tariffAutoChange" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="fixedPrice"/> <spring:message code="fixedPrice" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="driverNonCash"/> <spring:message code="driverNonCash" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="driverShowToBefore"/> <spring:message code="driverShowToBefore" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="driverShowTo"/> <spring:message code="driverShowTo" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="driverShowCost"/> <spring:message code="driverShowCost" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="allowManualAssign"/> <spring:message code="allowManualAssign" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="showCarsCount"/> <spring:message code="showCarsCount" />
						</label>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="showParking"/> <spring:message code="showParking" />
						</label>
					</div>
					
					<spring:message code="distribution" var="distributionLabel" />
					<spring:message code="select" var="selectLabel" />
					<div class="form-group">
						<label for="distributionId">${distributionLabel}</label>
						<form:select path="distributionId" id="distributionId" class="form-control">
							<form:option value="0">${selectLabel}</form:option>
						</form:select>
					</div>
					
					<div class="form-group">
						<label for="tariffCityId"><spring:message code="tariffCity" /></label>
						<form:select path="tariffCityId" id="tariffCityId" class="form-control">
							<form:option value="0">${selectLabel}</form:option>
						</form:select>
					</div>
					
					<div class="form-group">
						<label for="tariffOutsideCityId"><spring:message code="tariffOutsideCity" /></label>
						<form:select path="tariffOutsideCityId" id="tariffOutsideCityId" class="form-control">
							<form:option value="0">${selectLabel}</form:option>
						</form:select>
					</div>
					
					<div class="checkbox">
						<label>
							<form:checkbox path="allowPreliminary"/> <spring:message code="allowPreliminary" />
						</label>
					</div>
					
					<form:hidden path="id" id="id" />
					
					<br>
					<input class="btn btn-default" type="submit" value="<spring:message code="label.addbutton"/>" />
				</form:form>
					
			</div>
		</div>	
		
    </jsp:body>
</t:genericpage>


