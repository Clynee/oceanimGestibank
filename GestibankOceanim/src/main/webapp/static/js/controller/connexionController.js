'use strict';
App.controller('connexionController', [
		'$scope',
		'ConnexionService',
		'$location',
		'$window',
		'$sce',
		function($scope, ConnexionService, $location, $window, $sce) {

			$scope.dynamicPopover = {
				content : 'Hello, World!',
				templateUrl : 'static/views/tempConnexion.html',// 'myPopoverTemplate.html',//
				title : 'Title'
			};
			$scope.placement = {
				options : [ 'top', 'top-left', 'top-right', 'bottom',
						'bottom-left', 'bottom-right', 'left', 'left-top',
						'left-bottom', 'right', 'right-top', 'right-bottom' ],
				selected : 'bottom-right'
			};

			$scope.authenticate = function(user) {
				console.log(user.username)
				console.log("1111");
				ConnexionService.seConnecter(user).then(function(d) {
					$scope.userConnecte = d;
					console.log($scope.userConnecte)
					if ($scope.userConnecte !== null) {
						$location.path('/'+ $scope.userConnecte.ROLE);
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