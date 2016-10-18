<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>Oceanim votre banque en ligne</title>



<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular-animate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular-sanitize.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.1.4.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>

<script src="<c:url value='/static/js/librairie/money.js' />"></script>
<script src="<c:url value='/static/js/librairie/money.min.js' />"></script>

<script src="<c:url value='/static/js/app.js' />"></script>
<script type="text/javascript"
	src="<c:url value= '/static/js/controller/config.js' />"></script>
	<script type="text/javascript"
	src="<c:url value= '/static/js/controller/applicationController.js' />"></script>
	<script src="<c:url value='/static/js/service/clientServices.js' />"></script>
<script src="<c:url value='/static/js/controller/authentiCtrl.js' />"></script>
<script src="<c:url value='/static/js/controller/clientControllers.js' />"></script>

<script src="<c:url value='/static/js/service/connexion_service.js' />"></script>
<script
	src="<c:url value='/static/js/controller/connexionController.js' />"></script>
	<script
	src="<c:url value='/static/js/controller/conseillerControllers.js' />"></script>
	<script
	src="<c:url value='/static/js/controller/adminControllers.js' />"></script>
	<script src="<c:url value='/static/js/service/conseillerServices.js' />"></script>

	
	
	





<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="<c:url value= '/static/css/styleaccueil.css' />" />
<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash'
	rel='stylesheet' type='text/css'>
</head>
<body ng-app="myApp" ng-controller="ApplicationController as appCont" class="container">
	<header class="row">
		<div class="row">
			<div id="titre_principal" class="col-sm-5">
				<h1>Océanim</h1>
				<h2>Votre banque en ligne</h2>
			</div>
		</div>
	</header>
<!--  
	<a href="#/admin">Admin</a>
	<br>
	<a href="#/conseiller">Conseiller</a>
	<br>
	<a href="#/client">client</a>
-->
	<div class="row">
		<div ui-view></div>
	</div>
	<!--  <script src="../MyGestiBank/admin.js"></script>
    <script src="../MyGestiBank/stock.js"></script>
    <script src="../MyGestiBank/config.js"></script>-->
</body>
</html>

