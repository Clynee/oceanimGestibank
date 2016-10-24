App
		.factory(
				'adminServices',
				[
						'$http',
						'$q',
						function($http, $q) {
							var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/';
							var factory = {
								getDemandesInscriptions : getDemandesInscriptions,
								getDemandesAffectes : getDemandesAffectes,
								getConseillers : getConseillers,
								affecter : affecter
							};

							return factory;
							
							
							function getDemandesAffectes(idUser) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI + '/demandesAffectes/' + idUser)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Erreur lors de chargement des demandes !!!')
													deferred
															.reject(errResponse);
												})
								return deferred.promise;
							}

							
							
							
							function getDemandesInscriptions(idUser) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI + '/demandes/'
														+ idUser)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Erreur lors de chargement des demandes !!!')
													deferred
															.reject(errResponse);
												})
								return deferred.promise;
							}

							function getConseillers() {
								var deferred = $q.defer();
								$http
										.get(REST_SERVICE_URI + 'conseillers/')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Erreur lors de chargement des conseillers')
												})
								return deferred.promise;
							}

							function affecter(infos) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'affecterDemandeToConseiller/',
												infos)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error("Erreur lors de l'affectation !!!")
												})
								return deferred.promise;
							}

						} ])