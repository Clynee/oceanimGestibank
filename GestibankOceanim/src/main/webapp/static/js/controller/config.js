app.config(['$routeProvider',
	function ($routeProvider){
	//Système de routage
	$routeProvider
	.when('/FormulaireVisiteur',{
		templateUrl:'/FormulaireVisiteur.html',
	});
}])

//Problème au niveau du routage de la page formulaire à partir du bouton "ouvrir un compte"
