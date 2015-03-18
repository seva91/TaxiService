<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="head" fragment="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
	<link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/styles/style.css" />" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<jsp:invoke fragment="head"/>
</head>
  <body>
  
    <div class="wrapper">

		<header class="header" id="pageheader">
			<jsp:invoke fragment="header"/>
		</header><!-- .header-->
	
		<div class="middle">
	
			<div class="left-block">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
					  <h4 class="panel-title">
						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
						  Управление
						</a>
					  </h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
					  <div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li role="presentation">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
								  Водители <span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
								  <li role="presentation"><a href="#">Водители</a></li>
								  <li role="presentation"><a href="#">Корректировка</a></li>
								</ul>
							</li>
							<li role="presentation"><a href="#">Карта</a></li>
							<li role="presentation"><a href="#">Диспетчер</a></li>
							<li role="presentation"><a href="#">Менеджер</a></li>
							<li role="presentation"><a href="#">Заказы</a></li>
							<li role="presentation"><a href="#">Клиенты</a></li>
							<li role="presentation"><a href="#">Режимы работы</a></li>
							<li role="presentation"><a href="#">Рассылка сообщений</a></li>
						</ul>
					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
					  <h4 class="panel-title">
						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						  Настройки
						</a>
					  </h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
					  <div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li role="presentation"><a href="#">Службы</a></li>
							<li role="presentation"><a href="#">Стоянки</a></li>
							<li role="presentation"><a href="#">Адреса</a></li>
							<li role="presentation"><a href="#">Водители</a></li>
							<li role="presentation"><a href="#">Клиенты</a></li>
							<li role="presentation"><a href="#">Смены</a></li>
							<li role="presentation"><a href="#">Распределение</a></li>
							<li role="presentation"><a href="#">Пользователи</a></li>
							<li role="presentation"><a href="#">Дисконтные карты</a></li>
							<li role="presentation"><a href="#">Уведомления</a></li>
							<li role="presentation"><a href="#">Машины</a></li>
							<li role="presentation"><a href="#">Платежные системы</a></li>
						</ul>
					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
					  <h4 class="panel-title">
						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						  Отчеты
						</a>
					  </h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
					  <div class="panel-body">
						Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
					  </div>
					</div>
				  </div>
				</div>
			</div><!-- .left-sidebar -->
			
			
			<div class="content" id="body">
				<jsp:doBody/>
			</div><!-- .container-->
	
		</div><!-- .middle-->
	
	</div><!-- .wrapper -->
	
	<footer class="footer" id="pagefooter">
		<jsp:invoke fragment="footer"/>
	</footer><!-- .footer -->
    
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/bootstrap.min.js" />"></script>
    
  </body>
</html>