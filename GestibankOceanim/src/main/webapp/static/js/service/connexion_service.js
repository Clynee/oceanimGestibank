App.factory('ConnexionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/seConnecter/';
    var factory={
    	seConnecter : seConnecter
    }

    
    	return factory; 
    
    function seConnecter(user){
    	        var deferred = $q.defer();
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
