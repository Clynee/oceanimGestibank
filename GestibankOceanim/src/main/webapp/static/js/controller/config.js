App.config(function ($routeProvider){
	//Système de routage
	$routeProvider
	.when('/FormulaireVisiteur',{
		templateUrl:'static/views/FormulaireVisiteur.html',
		controller: 'formCtrl'
	})
	/*
	.when('/seConnecter',{
		templateUrl:'static/views/tempConnexion.html',
		controller: 'connexionController'
	})
	*/
	.when('/conseiller/{id}',{
		templateUrl:'static/views/tempConnexion.html',
		controller:'connexionCtrl'
	});
})
