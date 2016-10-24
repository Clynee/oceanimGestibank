App
		.factory(
				'clientServices',
				[
						'$http',
						'$q',
						function($http, $q) {
							var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/';
							var factory = {
								updateInfos: updateInfos,
								getComptes: getComptes,
								getOperations: getOperations,
								virement: virement,
								getNotifications: getNotifications,
								demandeChequier: demandeChequier
							};

							return factory;
							
							
							function demandeChequier(compte){
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + 'demandeChequier/',compte)
								.then(function(response){
									deferred.resolve(response.data);
								}, function(errResponse){
									console.error('Erreur de virement !!!')
									deferred.reject(errResponse);
								})
							return deferred.promise;
							}
							
							
							function getNotifications(idUser){
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + 'notifications/' + idUser)
									.then(function(response){
										deferred.resolve(response.data);
									}, function(errResponse){
										console.error('Erreur de notifications !!!')
										deferred.reject(errResponse);
									})
								return deferred.promise;
							}
							
							
							
							function virement(infosVirement){
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + 'virement/',infosVirement)
									.then(function(response){
										deferred.resolve(response.data);
									}, function(errResponse){
										console.error('Erreur de virement !!!')
										deferred.reject(errResponse);
									})
								return deferred.promise;
							}
							
							function getOperations(codeCompte){
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + '/operations/' + codeCompte)
									.then(function(response){
										deferred.resolve(response.data);
									}, function(errResponse){
										console.error('Erreur lors de chargement des operations !!!')
										deferred.reject(errResponse);
									})
								return deferred.promise;
							}
							

							function updateInfos(user) {
								var deferred = $q.defer();
								$http.put(REST_SERVICE_URI + 'updateUser/',
										user).then(function(response) {
									deferred.resolve(response.data);
								}, function(errResponse) {
									console.error('Error while deleting User');
									deferred.reject(errResponse);
								});
								return deferred.promise;
							}

							function getComptes(user) {
								var deferred = $q.defer();
								$http
										.post(REST_SERVICE_URI + 'comptes/',
												user)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Erreur lors de chargement des comptes')
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
