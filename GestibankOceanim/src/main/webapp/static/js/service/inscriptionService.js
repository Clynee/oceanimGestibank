'use strict';
App
		.factory(
				'inscriptionService',
				[
						'$http',
						'$q',
						function($http, $q) {
							var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/inscription/';
							var factory = {
									inscription : inscription,
							};

							return factory;

							function inscription(form) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI, form)
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

						} ])