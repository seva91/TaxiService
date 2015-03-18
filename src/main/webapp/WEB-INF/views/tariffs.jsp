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
				<h3 class="panel-title">Тарифы</h3>
			</div>
			<div class="panel-body">
			
				<form:form action="/taxi/tariffs/remove">
				<a href="<c:url value="/tariff/add" />" class="btn btn-default">Добавить</a>
				<input type="submit" class="btn btn-default" value="Удалить отмеченое" />  	
				  
					<table class="table">
						<thead>
							<tr>
								<th><input type="checkbox"/></th>
								<th>Название</th>
								<th>Действия</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty tariffs}">
							<c:forEach items="${tariffs}" var="tariff">
							<tr>
								<td><input name="selected_roles[]" type="checkbox" value="${tariff.id}"  /></td>
								<td>${tariff.name}</td>
								<td>
									<div class="dropdown">
									  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
										<span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/services/edit/${tariff.id}" />">Редактировать</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/services/remove/${tariff.id}" />">Удалить</a></li>
									  </ul>
									</div>
								</td>
							</tr>
							</c:forEach>
							</c:if>
							
						</tbody>
					</table>
					</form:form>
					
				  </div>
				</div>	
	</jsp:body>
	
</t:genericpage>