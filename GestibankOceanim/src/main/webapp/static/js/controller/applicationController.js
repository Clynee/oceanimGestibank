App.constant('AUTH_EVENTS', {
	  loginSuccess: 'auth-login-success',
	  loginFailed: 'auth-login-failed',
	  logoutSuccess: 'auth-logout-success',
	  sessionTimeout: 'auth-session-timeout',
	  notAuthenticated: 'auth-not-authenticated',
	  notAuthorized: 'auth-not-authorized'
	})
	

App.constant('USER_ROLES', {
  all: '*',
  admin: 'admin',
  conseiller: 'conseiller',
  client: 'client'
})

App.service('Session', function () {
  this.create = function (sessionId, userId, userRole) {
    this.id = sessionId;
    this.userId = userId;
    this.userRole = userRole;
  };
  this.destroy = function () {
    this.id = null;
    this.userId = null;
    this.userRole = null;
  };
})


App.controller('ApplicationController', function ($scope,
                                               USER_ROLES,
                                               AuthService) {
  $scope.currentUser = null;
  $scope.userRoles = USER_ROLES;
  $scope.isAuthorized = AuthService.isAuthorized;
 
  $scope.setCurrentUser = function (user) {
    $scope.currentUser = user;
    window.currentUser = user;
 
  };
})


App.controller('contentCtrl',['$scope','$http','$q',function($scope,$http,$q) {
		  
		    $scope.result=0;
		  var recupDonne=function(url){
			  var deferred = $q.defer();
			  $http.get(url).then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					deferred.reject(errResponse);
				}
			  );
			  return deferred.promise;
		  }
		  $scope.data={}
		  recupDonne("http://api.fixer.io/latest").then(function(d){
			  $scope.data=d;
		  },function(errResponse){
			  console.log("Errrrrrrrrror");
		  })
		  
		
     $scope.demo = function() {
			console.log($scope.data)
			fx.rates = $scope.data.rates
			console.log(fx.rates)
			console.log($scope.currency_calc_to)
			$scope.result=fx($scope.montant).convert({ from:$scope.currency_calc_from, to:$scope.currency_calc_to });
			//$scope.result= fx($scope.montant).from($scope.currency_calc_from).to($scope.currency_calc_to);
			console.log($scope.currency_calc_to)
			//var rate = fx(1).from("GBP").to("USD")
			//alert("£1 = $" + $scope.result)
		}
	
    
      }]);

