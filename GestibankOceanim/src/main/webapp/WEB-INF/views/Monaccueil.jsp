<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head> 
<meta charset="utf-8">
		<title>Oceanim votre banque en ligne</title>
	
		<!--  <script type="text/javascript" src="../bower_components/jquery/dist/jquery.js"></script> -->
		<!-- <script type="text/javascript" src="../bower_components/bootstrap/dist/js/bootstrap.js"></script> -->
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="<c:url value= '/static/css/styleaccueil.css' />"/>
		<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash' rel='stylesheet' type='text/css'>
</head>
<body ng-app="monApp" class="container">
	<header class="row">
		
        <div class="row">
             <div id="titre_principal" class="col-sm-5">
                  <h1>Océanim</h1>    
                     <h2>Votre banque en ligne</h2>
              </div>
              <div class="ouvrircompte">
				<a href="./FormulaireVisiteur.html" class="btn btn-danger btn-lg">Ouvrir un compte</a>
			</div>
         </div>




		<div ng-controller="formCtrl">
				<form class="form-inline" name="monForm" ng-submit="authenticate(monForm, auth);">
		 			 <div class="form-group">
		   				 <label for="username">Identifiant : &nbsp</label>
		    			<input type="text" class="form-control" name="username" placeholder="Identifiant" ng-model="auth.username" required="required"/>
		 			</div>
		 			<div class="form-group">
		    			<label for="password">Mot de passe : &nbsp</label>
		    			<input type="password" class="form-control" name="password" placeholder="Mot de passe" ng-model="auth.password"required="required"/>
		  			</div>
		  		<a href="../MyGestiBank/FormulaireVisiteur.html" ><button type="submit" class="btn btn-default" ng-disabled="monForm.$invalid">Valider</button></a>
				</form>
			</div>
               
     </header>

     
     <div ng-view></div>
    
     <div class="row no2 container ">
   		
	     <ul class="nav nav-pills nav-stacked navbar-left">
	  		<li class="active"><a data-toggle="pill" href="#accueil">Accueil</a></li>
	  		<li><a data-toggle="pill" href="#produits">Nos produits</a></li>
	 	 	<li><a data-toggle="pill" href="#services">Nos services</a></li>
	  		<li><a data-toggle="pill" href="#engagement">Nos engagements</a></li>
		</ul>
	
		<div class="tab-content">
   			<div id="accueil" class="tab-pane fade in active">
   				<img src="<c:url value= '/static/images/photoArgent.jpg' />" alt="image accueil"style="width:804px;height:408px">
   			</div>
   			<div id="produits" class="tab-pane fade">
   			

			<center><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nec sagittis massa. Nulla facilisi. Cras id arcu lorem, et semper purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel enim mi, in lobortis sem. Vestibulum luctus elit eu libero ultrices id fermentum sem sagittis. Nulla imperdiet mauris sed sapien dignissim id aliquam est aliquam. Maecenas non odio ipsum, a elementum nisi. Mauris non erat eu erat placerat convallis. Mauris in pretium urna. Cras laoreet molestie odio, consequat consequat velit commodo eu. Integer vitae lectus ac nunc posuere pellentesque non at eros. </p>
			<p>
			Vivamus sed libero nec mauris pulvinar facilisis ut non sem. Quisque mollis ullamcorper diam vel faucibus. Vestibulum sollicitudin facilisis feugiat. Nulla euismod sodales hendrerit. Donec quis orci arcu. Vivamus fermentum magna a erat ullamcorper dignissim pretium nunc aliquam. Aenean pulvinar condimentum enim a dignissim. Vivamus sit amet lectus at ante adipiscing adipiscing eget vitae felis. In at fringilla est. Cras id velit ut magna rutrum commodo. Etiam ut scelerisque purus. Duis risus elit, venenatis vel rutrum in, imperdiet in quam. Sed vestibulum, libero ut bibendum consectetur, eros ipsum ultrices nisl, in rutrum diam augue non tortor.</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nec sagittis massa. Nulla facilisi. Cras id arcu lorem, et semper purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel enim mi, in lobortis sem. Vestibulum luctus elit eu libero ultrices id fermentum sem sagittis. Nulla imperdiet mauris sed sapien dignissim id aliquam est aliquam. Maecenas non odio ipsum, a elementum nisi. Mauris non erat eu erat placerat convallis. Mauris in pretium urna. Cras laoreet molestie odio, consequat consequat velit commodo eu. Integer vitae lectus ac nunc posuere pellentesque non at eros. </p>
			</center>


   			</div>
   			<div id="services" class="tab-pane fade">
   			
			<center><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nec sagittis massa. Nulla facilisi. Cras id arcu lorem, et semper purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel enim mi, in lobortis sem. Vestibulum luctus elit eu libero ultrices id fermentum sem sagittis. Nulla imperdiet mauris sed sapien dignissim id aliquam est aliquam. Maecenas non odio ipsum, a elementum nisi. Mauris non erat eu erat placerat convallis. Mauris in pretium urna. Cras laoreet molestie odio, consequat consequat velit commodo eu. Integer vitae lectus ac nunc posuere pellentesque non at eros. </p>
			<p>
			Vivamus sed libero nec mauris pulvinar facilisis ut non sem. Quisque mollis ullamcorper diam vel faucibus. Vestibulum sollicitudin facilisis feugiat. Nulla euismod sodales hendrerit. Donec quis orci arcu. Vivamus fermentum magna a erat ullamcorper dignissim pretium nunc aliquam. Aenean pulvinar condimentum enim a dignissim. Vivamus sit amet lectus at ante adipiscing adipiscing eget vitae felis. In at fringilla est. Cras id velit ut magna rutrum commodo. Etiam ut scelerisque purus. Duis risus elit, venenatis vel rutrum in, imperdiet in quam. Sed vestibulum, libero ut bibendum consectetur, eros ipsum ultrices nisl, in rutrum diam augue non tortor.</p></center>
   			</div>
   			<div id="engagement" class="tab-pane fade">
   			
			<center><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nec sagittis massa. Nulla facilisi. Cras id arcu lorem, et semper purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel enim mi, in lobortis sem. Vestibulum luctus elit eu libero ultrices id fermentum sem sagittis. Nulla imperdiet mauris sed sapien dignissim id aliquam est aliquam. Maecenas non odio ipsum, a elementum nisi. Mauris non erat eu erat placerat convallis. Mauris in pretium urna. Cras laoreet molestie odio, consequat consequat velit commodo eu. Integer vitae lectus ac nunc posuere pellentesque non at eros. </p>
			<p>
			Vivamus sed libero nec mauris pulvinar facilisis ut non sem. Quisque mollis ullamcorper diam vel faucibus. Vestibulum sollicitudin facilisis feugiat. Nulla euismod sodales hendrerit. Donec quis orci arcu. Vivamus fermentum magna a erat ullamcorper dignissim pretium nunc aliquam. Aenean pulvinar condimentum enim a dignissim. Vivamus sit amet lectus at ante adipiscing adipiscing eget vitae felis. In at fringilla est. Cras id velit ut magna rutrum commodo. Etiam ut scelerisque purus. Duis risus elit, venenatis vel rutrum in, imperdiet in quam. Sed vestibulum, libero ut bibendum consectetur, eros ipsum ultrices nisl, in rutrum diam augue non tortor.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nec sagittis massa. Nulla facilisi. Cras id arcu lorem, et semper purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel enim mi, in lobortis sem. Vestibulum luctus elit eu libero ultrices id fermentum sem sagittis. Nulla imperdiet mauris sed sapien dignissim id aliquam est aliquam. Maecenas non odio ipsum, a elementum nisi. Mauris non erat eu erat placerat convallis. Mauris in pretium urna. Cras laoreet molestie odio, consequat consequat velit commodo eu. Integer vitae lectus ac nunc posuere pellentesque non at eros. </p>
			</center>
   			</div>
   		</div>
   	</div>	

	<br>
  <div class:"convertisseur">
  <center>Ici se trouvera notre super convertisseur de devises!</center>
  </div>				     
	<br>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
	<script type="text/javascript" src="<c:url value= '/static/js/controller/authentiCtrl.js' />"></script>
	<script type="text/javascript" src="<c:url value= '/static/js/controller/config.js' />"></script>
	<!--  <script src="../MyGestiBank/admin.js"></script>
    <script src="../MyGestiBank/stock.js"></script>
    <script src="../MyGestiBank/config.js"></script>-->
</body>
</html>

