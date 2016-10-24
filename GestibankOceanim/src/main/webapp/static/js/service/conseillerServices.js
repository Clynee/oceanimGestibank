'use strict';
App
		.factory(
				'conseillerServices',
				[
						'$http',
						'$q',
						function($http, $q) {
							var REST_SERVICE_URI = 'http://localhost:8080/SpringAngularStartProject/';
							var factory = {
								getDemandes : getDemandes,
								confirmerDemande: confirmerDemande,
								getClients: getClients,
								envoyerMessage: envoyerMessage,
							};

							return factory;
							
							
							
							
							function envoyerMessage(infosMessage){
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + 'envoyerMessage/', infosMessage)
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
							
							function getClients(idUser) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI + 'clients/'
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
							
							
							
							
							function confirmerDemande(demande){
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + 'confirmerDemande/', demande)
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
							
							function getDemandes(idUser) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI + 'demandes/'
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

						} ])