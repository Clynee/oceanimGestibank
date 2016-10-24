'use strict';
App.controller('conseillerCtrl', function($scope, conseillerServices, $state,
		$stateParams) {
	$scope.listDemandes = {}
	$scope.demandesInscription = {}
	$scope.demandesChequier = {}
	$scope.demandesModif = {}
	$scope.demandesNCompte = {}
	
	
	$scope.listClients={}
	
	console.log($scope.demandesInscription)

	$scope.getDemandes = function(iduser) {
		conseillerServices.getDemandes(iduser).then(function(d) {
			console.log(d);
			//$scope.demandesInscription = d;
			$scope.listDemandes = d;
			$scope.demandesInscription = $scope.listDemandes.filter(function(item) { return  item.type === 'INSCRIPTION'; })
			$scope.demandesChequier = $scope.listDemandes.filter(function(item) { return  item.type === 'CHEQUIER'; })
			$scope.demandesModif =	$scope.listDemandes.filter(function(item) { return  item.type === 'MODIF'; })
			$scope.demandesNCompte = $scope.listDemandes.filter(function(item) { return  item.type === 'NCOMPTE'; })
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}
	// console.log($scope.listComptes)
	
	
	$scope.getClients = function(iduser){
		conseillerServices.getClients(iduser).then(function(d) {
			console.log(d);
			//$scope.demandesInscription = d;
			$scope.listClients = d;
		}, function(errResponse) {
			console.error('Erreur lors du chargement des clients');
		});
	}
	
	//$scope.getDemandes(window.currentUser.id)
	$scope.getClients(window.currentUser.id)

})

App.controller('inscriptionsCtrl', function($scope, $log, $stateParams) {
	$scope.demandesInscription = $stateParams.demandesInscription
	$scope.listdemIns = listdemIns;
	// $scope.totalItems = 4;
	// $scope.currentPage = 4;

	$scope.setPage = function(pageNo) {
		$scope.currentPage = pageNo;
	};

	$scope.pageChanged = function() {
		$log.log('Page changed to: ' + $scope.currentPage);
	};

	$scope.itemsPerPage = 4;
	$scope.maxSize = 5;
	$scope.bigTotalItems = listdemIns.length;
	$scope.bigCurrentPage = 1;
});

App.controller('consulterDemandesInscriptionsCtrl',function($scope, $log, $stateParams){
	$scope.demande = $stateParams.demande
})


App.controller('demandesClientsCtrl',function($scope,$stateParams,conseillerServices){
	$scope.demandesChequier = {}
	$scope.demandesModif = {}
	$scope.demandesNCompte = {}
	
	this.getDemandes = function(iduser) {
		conseillerServices.getDemandes(iduser).then(function(d) {
			console.log(d);
			//$scope.demandesInscription = d;
			$scope.listDemandes = d;
			$scope.demandesChequier = $scope.listDemandes.filter(function(item) { return  item.type === 'CHEQUIER'; })
			$scope.demandesModif =	$scope.listDemandes.filter(function(item) { return  item.type === 'MODIF'; })
			$scope.demandesNCompte = $scope.listDemandes.filter(function(item) { return  item.type === 'NCOMPTE'; })
		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
	}
	// console.log($scope.listComptes)
	this.getDemandes(window.currentUser.id)
	
})

App.controller('demandeChequierConseillerCtrl',function($scope,$stateParams,conseillerServices){
	$scope.demande = $stateParams.demande
	$scope.confirmerDemande = function(demande){
		conseillerServices.confirmerDemande(demande).then(function(d){
			console.log("c'est bien !!!")
		}, function(errResponse) {
			console.error('Erreur lors de la confirmation de la demande');
		})
	}
})


App.controller('contacterClientCtrl', function($scope, $location,$stateParams,conseillerServices) {
	$scope.client = $stateParams.client
	console.log($scope.client)
	$scope.message={}
	$scope.message.concerne = $scope.client
	
	$scope.envoyerMessage = function(message){
		console.log("debut")
		conseillerServices.envoyerMessage(message).then(function(d){
			console.log("c'est bien !!!")
		}, function(errResponse) {
			console.error('Erreur lors de la confirmation de la demande');
		})
	}
	
	
})


App.controller('messagesCtrl',function($scope,$stateParams){
	$scope.consulter = function() {
		console.log('/contacterClient/')
		$location.path("/contacterClient/");
	}
})




