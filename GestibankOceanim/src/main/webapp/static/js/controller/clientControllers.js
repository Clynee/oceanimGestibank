'use strict';

App.controller('clientCtrl', function($scope, clientServices, $state,
		$stateParams) {
	$scope.listComptes = {}
	console.log($scope.listComptes)

	this.getComptes = function(user) {
		var comptes = {}
		clientServices.getComptes(user).then(function(d) {
			console.log(d);
			$scope.listComptes = d;

		}, function(errResponse) {
			console.error('Erreur lors du chargement des comptes');
		});
		return comptes;
	}

	
	
	/* ----- Notifications -----*/ 
	$scope.listNotifications = {}
	$scope.getNotification = function(idUser){
		clientServices.getNotifications(idUser)
		.then(
				function(d) {
					console.log(d)
					$scope.listNotifications = d;
					console.log($scope.listNotifications);
					$scope.nonlus = $scope.listNotifications.filter(function(item) { return  item.etat ==="NONLUE" ; })
					console.log($scope.listNotifications)
					console.log($scope.nonlus)
				},
				function(errResponse) {
					console
							.error('Erreur lors du chargement des Notifications');
				});
	}
	$scope.getNotification(window.currentUser.id)
	// console.log($scope.listComptes)
	this.getComptes(window.currentUser)
	console.log('fin client controller')
	// $state.go('.synthese',{listCompte:$scope.listComptes})
	
})

App.controller('virementCtrl', function($scope, clientServices, $stateParams) {
	$scope.listComptes = $stateParams.listComptes
	$scope.infosVirement = {}
	$scope.virement = function(infos) {
		console.log(infos)
		clientServices.virement(infos).then(function(d) {
			console.log(d);
		}, function(errResponse) {
			console.error('Error while update User');
		});
	}

});

App.controller("modifInfo", function($scope, clientServices) {
	$scope.showMe = false;
	console.log("-----------------")
	console.log($scope.currentUser)
	$scope.modif = function() {
		$scope.showMe = !$scope.showMe;
	}

	$scope.updateInfos = function(user) {
		clientServices.updateInfos(user).then(function(d) {
			console.log(d);
		}, function(errResponse) {
			console.error('Error while update User');
		});
		window.currentUser = user;
		$scope.showMe = false;
	}
});

App.controller('syntheseComptesCtrl', function($scope, $location, $stateParams,
		clientServices) {

	$scope.listComptes = {} //$stateParams.listComptes
	// getComptes(window.currentUser)
	console.log($stateParams.listComptes)
	
	  this.getComptes= function(user){ 
		var comptes = {}
	  clientServices.getComptes(user).then(function(d){ 
		  console.log(d);
		  $scope.listComptes = d;
	   },function(errResponse){ 
		   console.error('Erreur lors du chargement des comptes'); 
			});
	  
	  return comptes; } 
	
	this.getComptes(window.currentUser)
	console.log($scope.listComptes)
	 

	$scope.consulter = function(compte) {
		console.log('/historique/' + compte)
		$location.path("/historique/" + compte);
	}
});

App
		.controller(
				'historiqueCrtl',
				function($scope, $stateParams, clientServices) {
					$scope.compteSelected = $stateParams.compte;
					$scope.date = new Date();
					console.log($scope.compteSelected)
					$scope.listComptes = $stateParams.listComptes;

					$scope.listOperations = {}

					$scope.getOperations = function() {
						clientServices
								.getOperations($scope.compteSelected.codeCompte)
								.then(
										function(d) {
											$scope.listOperations = d;
											console.log($scope.listOperations);
										},
										function(errResponse) {
											console
													.error('Erreur lors du chargement des operations');
										});

					}

					$scope.getOperations();

					console.log($scope.listOperations);
				});

App.controller('messagesConseillerCtrl', function($scope, $location) {
	$scope.consulter = function() {
		console.log('/messagesConseiller/')
		$location.path("/messagesConseiller/");
	}
})

App.controller('mesAlertesCtrl',function($scope,clientServices,$location,$state){
	$scope.listNotifications = {}
	$scope.getNotification = function(idUser){
		clientServices.getNotifications(idUser)
		.then(
				function(d) {
					$scope.listNotifications = d;
					console.log($scope.listNotifications);
				},
				function(errResponse) {
					console
							.error('Erreur lors du chargement des Notifications');
				});
	}
	
	
	$scope.consulterNotification = function(notif) {
		console.log(notif.type)
		var urlTypeNotif = ''
		switch(notif.type){
		case "MESSAGE":
			//urlTypeNotif = '/client/notifictionMessage'
				$state.go('espaceClient.notifictionMessage',{notif:notif})
				break;
		case "DEMANDE":
			//urlTypeNotif = '/client/notifictionDemande'
			$state.go('espaceClient.notifictionDemande',{notif:notif})	
			break;
		case "VIREMENT":
			//urlTypeNotif = '/client/notifictionTransaction'
			$state.go('espaceClient.notifictionTransaction',{notif:notif})	
			break;
		}
		
		//$location.path(urlTypeNotif);
		
	}
	
	$scope.getNotification(window.currentUser.id)
	
})

App.controller('notificationDemandeCtrl',function($scope,$stateParams){
	$scope.notif = $stateParams.notif
	console.log($stateParams.notif)
})

App.controller('notifictionMessageCtrl',function($scope,$stateParams){
	$scope.notif = $stateParams.notif
	console.log($stateParams.notif)
})

App.controller('notifictionTransactionCtrl',function($scope,$stateParams){
	$scope.notif = $stateParams.notif
	console.log($stateParams.notif)
})

App.controller('demandeChequierCtrl',function($scope,$stateParams,clientServices){
	$scope.listComptes = $stateParams.listComptes
	
	$scope.confirmerDemande = function(compte){
		clientServices.demandeChequier(compte)
		.then(
				function(d) {
					console.log("c'est bon !!!")
				},
				function(errResponse) {
					console
							.error('Erreur lors du chargement des Notifications');
				});
	}
})


App.controller('demandeOuvertureCompteCtrl',function($scope,$stateParams){
	$scope.listComptes = $stateParams.listComptes
})

App.controller('demandeModifCompteCtrl',function($scope,$stateParams){
	$scope.listComptes = $stateParams.listComptes
})

