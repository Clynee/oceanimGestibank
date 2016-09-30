App.factory('ConnexionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/seConnecter/';
    var factory={
    	seConnecter : seConnecter
    }

    
    	return factory; 
    
    function seConnecter(ident,mtp){
    	        var deferred = $q.defer();
    	        $http.get(REST_SERVICE_URI + ident)
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
