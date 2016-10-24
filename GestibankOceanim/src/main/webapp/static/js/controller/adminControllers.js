'use strict';
App.controller('adminCtrl', function($scope, adminServices, $state,
		$stateParams) {
	$scope.demandesInscription = {}
	$scope.listConseillers = {}

	console.log($scope.demandesInscription)

	$scope.getDemandesInscriptions = function(iduser) {
		adminServices.getDemandesInscriptions(iduser).then(function(d) {
			console.log(d);
			$scope.demandesInscription = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}
	// console.log($scope.listComptes)

	this.getConseillers = function() {
		adminServices.getConseillers().then(function(d) {
			console.log(d);
			$scope.listConseillers = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}

	$scope.getDemandesInscriptions(window.currentUser.id)
	this.getConseillers(window.currentUser)

	console.log('fin admin controller')
	// $state.go('.synthese',{listCompte:$scope.listComptes})
})

App.controller('demandesInscriptionsCtrl', function($scope, adminServices,
		$stateParams) {
	$scope.demandesInscription = {}
	console.log($scope.demandesInscription)

	$scope.getDemandesInscriptions = function(iduser) {
		adminServices.getDemandesInscriptions(iduser).then(function(d) {
			console.log(d);
			$scope.demandesInscription = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}

	$scope.getDemandesInscriptions(window.currentUser.id)
	$scope.affecter = function(infos) {
		adminServices.affecter(infos).then(function(d) {
			$scope.getDemandesInscriptions(window.currentUser.id)
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		})
		console.log("je suis passé par ici !!!!")
	}
})


App.controller('etatsInscriptionsCtrl',function($scope,adminServices){
	$scope.demandesInscription = {}
	console.log($scope.demandesInscription)

	$scope.getDemandesAffectes = function(iduser) {
		adminServices.getDemandesAffectes(iduser).then(function(d) {
			console.log(d);
			$scope.demandesInscription = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}

	$scope.getDemandesAffectes(window.currentUser.id)
})

App.controller('consulterEtatDemandeCtrl',function($scope,$stateParams,adminServices){
	$scope.demande = $stateParams.demande
	$scope.listConseillers={}
	
	this.getConseillers = function() {
		adminServices.getConseillers().then(function(d) {
			console.log(d);
			$scope.listConseillers = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}
	
	$scope.affecter = function(infos) {
		adminServices.affecter(infos).then(function(d) {
			//$scope.getDemandesInscriptions(window.currentUser.id)
			$scope.demande = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		})
		console.log("je suis passé par ici !!!!")
	}
	
	this.getConseillers(window.currentUser)
})




