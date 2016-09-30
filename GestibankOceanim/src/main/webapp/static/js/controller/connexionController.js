'use strict';
//angular.module('myApp')
App.controller('connexionController',
		[ '$scope', 'ConnexionService','$location', function($scope, ConnexionService,$location) {
			//var self = this;
		//	self.auth = {
		//			username : '',
		//		password:''
		// };

			//self.authenticate = authenticate;
			//self.reset = reset;
			$scope.conseiller=null
			

			function seConnecter(ident, mtp) {
				console.log("1111");
				ConnexionService.seConnecter(ident, mtp).then(function(d) {
					$scope.conseiller = d;
				}, function(errResponse) {
					console.error('Error while fetching Users');
				});

			}

			$scope.authenticate = function() {
				seConnecter($scope.auth.username, $scope.auth.password)
				if($scope.conseiller===null){
					$scope.reset();
				}else{
					$location.url("/conseiller");
				}
			}

			$scope.reset=function() {
				console.log("1111");
				$scope.monForm.$setPristine(); // reset Form
				
			}

		} ]);