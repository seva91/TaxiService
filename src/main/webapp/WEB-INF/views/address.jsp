<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<% 
	request.setAttribute("host", request.getRemoteHost()); 
%>
<%--ddddd --%>
<t:genericpage>

	<jsp:attribute name="head">
    	<link href="<c:url value="/resources/js/jquery-ui/jquery-ui.min.css" />" rel="stylesheet">
    	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui/jquery-ui.min.js" />"></script>
    	<script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    
    <jsp:attribute name="footer">
    	Имя вашего хоста: ${host}
    </jsp:attribute>
    
    <jsp:body>
    	
    	<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body">
			
				<form:form method="post" action="${action}" modelAttribute="address">
					
					<%--<div>
						<label for="cityId"><spring:message code="label.city"/></label>
						<select class="form-control" name="cityId" id="cityId" onchange="changeCity(this)">
							<option value="0"><spring:message code="selectCity"/></option>
							<c:if test="${!empty cities}">
								<c:forEach items="${cities}" var="city">
									<option coordinatesX="${city.coordinatesX}" coordinatesY="${city.coordinatesY}" value="${city.id}">${city.name}</option>
								</c:forEach>
							</c:if>
						</select>
					</div>--%>
					
					<div>
						<label for="city"><spring:message code="label.city"/></label>
						<input class="form-control" id="city" name="city" />
					</div>
					
					<div>
						<label for="streetId"><spring:message code="street"/></label>
						<form:input class="form-control" path="street"  />
						<form:input type="hidden" id="streetId" path="streetId" />
					</div>
					
					<div class="form-group">
						<label for="houseNum"><spring:message code="houseNum"/></label>
					    <form:input class="form-control" id="houseNum" path="houseNum" />
					</div>
					
					<div class="form-group">
						<label for="place"><spring:message code="namePlace"/></label>
					    <a class="btn btn-default" id="addPlace">+</a>
					    
					    <ul class="list-group address-place">
						    <c:forEach varStatus="vs" items="${address.places}">
						    	<li class="list-group-item">
						    		<form:input path="places[${vs.index}].name"  class="form-control" />
						    	</li>
						    </c:forEach>
					    </ul>
					</div>
					
					<div class="form-group">
						<div id="map" style="width: 600px; height: 400px"></div>
						<div id="map-marker"></div>
						<form:input type="text" id="lat" path="coordinatesX" />
						<form:input type="text" id="lon" path="coordinatesY" />
					</div>
					
					<br>
					<input class="btn btn-default" type="submit" value="<spring:message code="label.addbutton"/>" />
				</form:form>
					
			</div>
		</div>	
		
    </jsp:body>
</t:genericpage>

<script type="text/javascript" src="<c:url value="/resources/js/geo/geo.js" />"></script>
<script type="text/javascript">

var data_address = {
	home: { number: '' },
	street: { id: 0, name: '' },
	city: { id: 0, name: '', x: 0, y: 0 }
};

var map;

ymaps.ready(function() {
	map = new AddressMap();
});


function createPlaceElement(place) {
	var placeDiv = document.getElementsByClassName('address-place')[0];
	var count = placeDiv.children.length;
	var li = document.createElement('LI');
	li.setAttribute('class', 'list-group-item');
	var input = '<input id="places' + count + '.name" name="places[' + count + '].name" class="form-control" type="text" value=""/>';
	li.innerHTML = input;
	placeDiv.appendChild(li);	
}

$(document).ready(function() {
	
	var street = $("#street");
	street.autocomplete({
		select: function(event, ui) {
			data_address.street.id = ui.item.value;
			data_address.street.name = ui.item.label;
			$('#streetId').val(data_address.street.id);
		},
		close: function(event, ui) {
			street.val(data_address.street.name);
		},
		source: function(request, response) {
			$.ajax({
				url: "/taxi/streets",
				dataType: "json",
				data: {
					cityId: data_address.city.id,
					term: "%" + street.val() + "%"
				},
				success: function(data) {
					var result = [];
					for(var i = 0; i < data.length; i++) {
						result.push({ value: data[i].id, label: data[i].name });
					}
					response(result);
				},
				error: function(error) { }
			});
		},
		minLength: 1
	});
	
	var city = $('#city');
	city.autocomplete({
		select: function(event, ui) {
			data_address.city.id = ui.item.value.id;
			data_address.city.name = ui.item.label;
			data_address.city.x = ui.item.value.x;
			data_address.city.y = ui.item.value.y;
			map.changeCity(data_address.city.x, data_address.city.y);
		},
		close: function(event, ui) {
			city.val(data_address.city.name);
		},
		source: function(request, response) {
			$.ajax({
				url: "/taxi/cities",
				dataType: "json",
				data: {
					term: "%" + city.val() + "%"
				},
				success: function(data) {
					var result = [];
					for(var i = 0; i < data.length; i++) {
						var x = 0, y = 0;
						if (data[i].coordinates != null) {
							x = data[i].coordinates.x;
							y = data[i].coordinates.y;
						}
						result.push({ value: { id: data[i].id, x: x, y: y }, label: data[i].name });
					}
					response(result);
				},
				error: function(error) { }
			});
		},
		minLength: 1
	});
	
	var addPlace = $('#addPlace');
	addPlace.click(function() {
		createPlaceElement('');
	});
});

</script>


