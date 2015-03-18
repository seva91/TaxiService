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
				<h3 class="panel-title">Службы</h3>
			</div>
			<div class="panel-body">
			
				<form:form action="/taxi/addresses/removemany">
				<a href="<c:url value="/addresses/add" />" class="btn btn-default">Добавить</a>
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
							<c:if test="${!empty addresses}">
							<c:forEach items="${addresses}" var="address">
							<tr>
								<td><input name="selected_address[]" type="checkbox" value="${address.id}"  /></td>
								<td>${address.houseNum}</td>
								<td>${address.street.city.name}</td>
								<td>
									<div class="dropdown">
									  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
										<span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/addresses/edit/${address.id}" />">Редактировать</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/addresses/remove/${address.id}" />">Удалить</a></li>
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


