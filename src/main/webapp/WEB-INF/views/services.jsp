<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="UTF-8"%>
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
				<h3 class="panel-title">Службы</h3>
			</div>
			<div class="panel-body">
			
				<form:form action="/taxi/roles/removemany">
				<a href="<c:url value="/services/add" />" class="btn btn-default">Добавить</a>
				<input type="submit" class="btn btn-default" value="Удалить отмеченое" />  	
				  
					<table class="table">
						<thead>
							<tr>
								<th><input type="checkbox"/></th>
								<th>Название</th>
								<th>Город</th>
								<th>Действия</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty services}">
							<c:forEach items="${services}" var="service">
							<tr>
								<td><input name="selected_roles[]" type="checkbox" value="${service.id}"  /></td>
								<td>${service.name}</td>
								<td>${service.city.name}</td>
								<td>
									<div class="dropdown">
									  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
										<span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/service/edit/${service.id}" />">Редактировать</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/service/remove/${service.id}" />">Удалить</a></li>
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

<script type="text/javascript">

</script>


