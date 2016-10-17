'use strict';


App.controller('clientCtrl',function($scope,clientServices,$state,$stateParams){
	$scope.listComptes={}
	console.log($scope.listComptes)
	
	this.getComptes= function(user){
		var comptes = {}
		clientServices.getComptes(user).then(function(d){
			console.log(d);
			$scope.listComptes = d;
			
		},function(errResponse){
			console.error('Erreur lors du chargement des comptes');
		});
		return comptes;
	}
	
	// console.log($scope.listComptes)
	this.getComptes(window.currentUser)
	console.log('fin client controller')
	// $state.go('.synthese',{listCompte:$scope.listComptes})
	
	
})




App.controller('virementCtrl',function($scope,clientServices,$stateParams){
	$scope.listComptes = $stateParams.listComptes
	$scope.infosVirement={}
	$scope.virement=function(infos){
		console.log(infos)
		clientServices.virement(infos).then(function(d) {
			console.log(d);
		}, function(errResponse) {
			console.error('Error while update User');
		});
	}
	
});





App.controller("modifInfo", function($scope,clientServices) {
	$scope.showMe = false;
	console.log("-----------------")
	console.log($scope.currentUser)
	$scope.modif = function() {
		$scope.showMe = !$scope.showMe;
	}
	
	$scope.updateInfos=function(user){
		clientServices.updateInfos(user).then(function(d) {
					console.log(d);
				}, function(errResponse) {
					console.error('Error while update User');
				});
		window.currentUser = user;
		$scope.showMe = false;
	}
});

App.controller('syntheseComptesCtrl',function($scope,$location,$stateParams,clientServices){
	
	$scope.listComptes=$stateParams.listComptes
	// getComptes(window.currentUser)
	console.log($stateParams.listComptes)
			/*
			 * this.getComptes= function(user){ var comptes = {}
			 * clientServices.getComptes(user).then(function(d){ console.log(d);
			 * $scope.listComptes = d; },function(errResponse){
			 * console.error('Erreur lors du chargement des comptes'); });
			 * 
			 * return comptes; } this.getComptes(window.currentUser)
			 * console.log($scope.listComptes)
			 */
	
	$scope.consulter= function(compte){
		console.log('/historique/'+ compte)
		$location.path("/historique/" + compte);
	}
});


App.controller('historiqueCrtl',function($scope,$stateParams,clientServices){
	$scope.compteSelected = $stateParams.compte;
	$scope.date = new Date();
	console.log($scope.compteSelected)
	$scope.listComptes = $stateParams.listComptes;

	$scope.listOperations = {}
	
	$scope.getOperations = function(){
	clientServices.getOperations($scope.compteSelected.codeCompte).then(function(d){
		$scope.listOperations = d;
	},function(errResponse){
		console.error('Erreur lors du chargement des operations');
	});
	
	}
	
	$scope.getOperations();
	
	console.log($scope.listOperations);
});




