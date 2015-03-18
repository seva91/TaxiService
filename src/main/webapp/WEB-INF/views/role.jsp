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
			
				<form:form method="post" action="${action}" commandName="role">
					<div class="form-group">
						<label for="exampleInputEmail1"><spring:message code="label.name"/></label>
					    <input class="form-control" id="name" name="name" placeholder="<spring:message code="label.name"/>" <c:if test="${!empty role}"> value="${role.name}" </c:if> >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><spring:message code="label.description2"/></label>
					    <input class="form-control" id="description" name="description" placeholder="<spring:message code="label.description2"/>" <c:if test="${!empty role}"> value="${role.description}" </c:if>>
					</div>
					
					<c:if test="${!empty role}"> <input type="hidden" value="${role.id}" name="id"></c:if>
					
					<input class="btn btn-default" type="submit" value="<spring:message code="label.addbutton"/>" />
				</form:form>
					
			</div>
		</div>	
		
    </jsp:body>
</t:genericpage>


