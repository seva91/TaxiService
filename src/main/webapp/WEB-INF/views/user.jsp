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
    
    
        <a href="<c:url value="/logout" />">
			<spring:message code="label.logout" />
		</a>
		  
		<h2><spring:message code="label.title" /></h2>
		
		<form:form method="post" action="add" commandName="user">
		
			<table>
				<tr>
					<td>
						<spring:message code="label.firstname" />
					</td>
					<td><form:input path="fullName" /></td>
				</tr>
			</table>
		</form:form>
		
		<h3><spring:message code="label.contacts" /></h3>
		<c:if test="${!empty users}">
			<table class="data">
				<tr>
					<th><spring:message code="label.firstname" /></th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.fullName}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		
    </jsp:body>
</t:genericpage>


