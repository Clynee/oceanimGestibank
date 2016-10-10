App.factory('ConnexionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/seConnecter/';
    var factory={
    	seConnecter : seConnecter
    }

    
    	return factory; 
    
    function seConnecter(user){
    	        var deferred = $q.defer();
    	        console.log("dans le service :" + user);
    	        $http.post(REST_SERVICE_URI,user)
    	            .then(
    	            function (response) {
    	                deferred.resolve(response.data);
    	            },
    	            function(errResponse){
    	                console.error('Error while deleting User');
    	                deferred.reject(errResponse);
    	            }
    	        );
    	        return deferred.promise;
    }
}]);



App.factory('AuthService', function ($http, Session) {
	var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/seConnecter/';
	  var authService = {};
	 
	  authService.login = function (credentials) {
	    return $http
	      .post(REST_SERVICE_URI, credentials)
	      .then(function (res) {
	        Session.create(res.data[1], res.data[0].username,
	                       res.data[0].roleUsers);
	        return res.data[0];
	      });
	  };
	 
	  authService.isAuthenticated = function () {
	    return !!Session.userId;
	  };
	 
	  authService.isAuthorized = function (authorizedRoles) {
	    if (!angular.isArray(authorizedRoles)) {
	      authorizedRoles = [authorizedRoles];
	    }
	    return (authService.isAuthenticated() &&
	      authorizedRoles.indexOf(Session.userRole) !== -1);
	  };
	 
	  return authService;
	})
