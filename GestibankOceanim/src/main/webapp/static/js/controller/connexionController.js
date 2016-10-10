'use strict';
App.controller('connexionController', [
		'$scope',
		'ConnexionService',
		'$location',
		'$window',
		'$sce',
		function($scope, ConnexionService, $location, $window, $sce) {

			$scope.connexionPopover = {
				content : 'Hello, World!',
				templateUrl : 'static/views/templatesAcceuil/tempConnexion.html',// 'myPopoverTemplate.html',//
				title : 'Connexion'
			};
			$scope.placement = {
				options : [ 'top', 'top-left', 'top-right', 'bottom',
						'bottom-left', 'bottom-right', 'left', 'left-top',
						'left-bottom', 'right', 'right-top', 'right-bottom' ],
				selected : 'bottom-right'
			};
			
			$scope.formulairePopover = {
					content : 'Hello, World!',
					templateUrl : 'static/views/templatesAcceuil/FormulaireVisiteur.html',// 'myPopoverTemplate.html',//
					title : "Demande d'ouverture de compte"
				};

			$scope.authenticate = function(user) {
				console.log(user.username)
				console.log("1111");
				ConnexionService.seConnecter(user).then(function(d) {
					console.log(d);
					$scope.userConnecte = d[0];
					console.log(d);
					console.log($scope.userConnecte)
					if ($scope.userConnecte !== null) {
						$location.path('/'+ $scope.userConnecte.roleUsers);
						// $window.location.href="static/views/ConseillerComptes.html"
					} else {
						$scope.monForm.$setPristine();
						console.log("conseiller est vide !!! ")
					}

				}, function(errResponse) {
					console.error('Error while fetching Users');
				});
			}
			/*
			 * $scope.reset = function() { // reset Form }
			 */

		} ]);


App.controller('LoginController', function ($scope,$location, $rootScope, AUTH_EVENTS, AuthService) {
	
	$scope.connexionPopover = {
			content : 'Hello, World!',
			templateUrl : 'static/views/templatesAcceuil/tempConnexion.html',// 'myPopoverTemplate.html',//
			title : 'Connexion'
		};
		$scope.placement = {
			options : [ 'top', 'top-left', 'top-right', 'bottom',
					'bottom-left', 'bottom-right', 'left', 'left-top',
					'left-bottom', 'right', 'right-top', 'right-bottom' ],
			selected : 'bottom-right'
		};
		
	
	/* 
	$scope.credentials = {
	    username: '',
	    password: ''
	  };*/
	  $scope.login = function (credentials) {
	    AuthService.login(credentials).then(function (user) {
	      $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
	      $scope.setCurrentUser(user);
	      var role=''
	    	  console.log(user.roleUsers)
	    	  console.log(user)
	      switch(user.roleUsers) {
	      case 1:
	    	  role = 'admin';
	          break;
	      case 2:
	    	  role = 'conseiller';
	          break;
	      case 3:
	    	  role = 'client';
	  }
	      $location.path('/'+role);
	      
	    }, function () {
	      $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
	    });
	  };
	})