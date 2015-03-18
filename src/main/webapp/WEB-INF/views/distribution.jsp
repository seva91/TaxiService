<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>

    <jsp:attribute name="header">
      <h1>Welcome</h1>
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
			
				<form:form method="post" action="${action}" modelAttribute="distribution">
				
					<div class="form-group">
						<label for="name"><spring:message code="label.name"/></label>
					    <spring:bind path="name">
					    	<input id="name" name="name" class="form-control" placeholder="<spring:message code="label.name"/>" value="${status.value}" />
					    </spring:bind>
					</div>
					
					<div class="form-group">
						<label for="timeDistribution"><spring:message code="timeDistribution"/></label>
						<spring:bind path="timeDistribution">
							<input name="timeDistribution" type="text" placeholder="<spring:message code="timeDistribution" />" id="timeDistribution" class="form-control" value="${status.value}" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="renewalOrder"><spring:message code="renewalOrder"/></label>
						<spring:bind path="renewalOrder">
							<input value="${status.value}" name="renewalOrder" type="text" placeholder="<spring:message code="renewalOrder" />" id="renewalOrder" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="timeSelectOrder"><spring:message code="timeSelectOrder"/></label>
						<spring:bind path="timeSelectOrder">
							<input value="${status.value}" name="timeSelectOrder" type="text" placeholder="<spring:message code="timeSelectOrder" />" id="timeSelectOrder" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="clientTimeout"><spring:message code="clientTimeout"/></label>
						<spring:bind path="clientTimeout">
							<input value="${status.value}" name="clientTimeout" type="text" placeholder="<spring:message code="clientTimeout" />" id="clientTimeout" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="offerOneOrder"><spring:message code="offerOneOrder"/></label>
						<spring:bind path="offerOneOrder">
							<input value="${status.value}" name="offerOneOrder" type="text" placeholder="<spring:message code="offerOneOrder" />" id="offerOneOrder" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="showActiveOrder"><spring:message code="showActiveOrder"/></label>
						<spring:bind path="showActiveOrder">
							<input value="${status.value}" name="showActiveOrder" type="text" placeholder="<spring:message code="showActiveOrder" />" id="showActiveOrder" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label><spring:message code="borderDistribution" /></label>
						<ul class="list-group">
							<li class="list-group-item"><form:radiobutton path="borderDistribution" value="1" /><spring:message code="insideParking" /></li>
							<li class="list-group-item"><form:radiobutton path="borderDistribution" value="2" /><spring:message code="adjacentParking" /></li>
							<li class="list-group-item"><form:radiobutton path="borderDistribution" value="3" /><spring:message code="through2ParkingLots" /></li>
						</ul>	
					</div>
					
					<div class="form-group">
						<label for="maximumRadius"><spring:message code="maximumRadius"/></label>
						<spring:bind path="maximumRadius">
							<input value="${status.value}" name="maximumRadius" type="text" placeholder="<spring:message code="maximumRadius" />" id="maximumRadius" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label><spring:message code="methodDistribution" /></label>
						<ul class="list-group">
							<li class="list-group-item"><form:radiobutton path="methodDistribution" value="1" /><spring:message code="inTurn" /></li>
							<li class="list-group-item"><form:radiobutton path="methodDistribution" value="2" /><spring:message code="avalanche" /></li>
							<li class="list-group-item"><form:radiobutton path="methodDistribution" value="3" /><spring:message code="openAir" /></li>
						</ul>	
					</div>
					
					<div class="form-group">
						<label><spring:message code="priorityDriver" /></label>
						<ul class="list-group">
							<li class="list-group-item"><form:radiobutton path="priorityDriver" value="1" /><spring:message code="nearest" /></li>
							<li class="list-group-item"><form:radiobutton path="priorityDriver" value="2" /><spring:message code="best" /></li>
							<li class="list-group-item"><form:radiobutton path="priorityDriver" value="3" /><spring:message code="smart" /></li>
						</ul>	
					</div>
					
					<label><spring:message code="preOrder" /></label>
					
					<div class="form-group">
						<label for="advanceOrdersSilentTime"><spring:message code="advanceOrdersSilentTime"/></label>
						<spring:bind path="advanceOrdersSilentTime">
							<input value="${status.value}" name="advanceOrdersSilentTime" type="text" placeholder="<spring:message code="advanceOrdersSilentTime" />" id="advanceOrdersSilentTime" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="advanceOrdersDistribTime"><spring:message code="advanceOrdersDistribTime"/></label>
						<spring:bind path="advanceOrdersDistribTime">
							<input value="${status.value}" name="advanceOrdersDistribTime" type="text" placeholder="<spring:message code="advanceOrdersDistribTime" />" id="advanceOrdersDistribTime" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="maxReserveDrivers"><spring:message code="maxReserveDrivers"/></label>
						<spring:bind path="maxReserveDrivers">
							<input value="${status.value}" name="maxReserveDrivers" type="text" placeholder="<spring:message code="maxReserveDrivers" />" id="maxReserveDrivers" class="form-control" />
						</spring:bind>
					</div>
					
					<div class="form-group">
						<label for="advanceOrdersTimeLimit"><spring:message code="advanceOrdersTimeLimit"/></label>
						<spring:bind path="advanceOrdersTimeLimit">
							<input value="${status.value}" name="advanceOrdersTimeLimit" type="text" placeholder="<spring:message code="advanceOrdersTimeLimit" />" id="advanceOrdersTimeLimit" class="form-control" />
						</spring:bind>
					</div>
					
					<form:input type="hidden" path="id"/>
					<br>
					<input class="btn btn-default" type="submit" value="<spring:message code="label.addbutton"/>" />
				</form:form>
					
			</div>
		</div>	
		
    </jsp:body>
</t:genericpage>


