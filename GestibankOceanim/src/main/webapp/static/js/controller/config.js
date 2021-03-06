App
		.config(function($stateProvider, $urlRouterProvider) {
			// Système de routage
			/*
			 * $urlRouterProvider.otherwise('');
			 */
			$stateProvider

					.state(
							'acceuil',
							{
								url : '',
								templateUrl : 'static/views/templatesAcceuil/acceuil.html',
								controller : 'LoginController'
							})

					/*-------------------------------------------------------*/
					/*--------------------- Espace Admin -------------------*/
					/*-------------------------------------------------------*/
					.state('espaceAdmin', {
						url : '/admin',
						templateUrl : 'static/views/espaceAdmin.html',
						controller : 'adminCtrl'
					})

					.state(
							'espaceAdmin.gestionConseillers',
							{
								url : '/gestionConseillers',
								templateUrl : 'static/views/templatesAdmin/gestionConseillers.html',// 'partial-home-list.html',
								controller : ''
							})

					.state(
							'espaceAdmin.nouvellesInscriptions',
							{
								url : '/nouvellesInscriptions',
								params : {
									demandesInscription : null,
									listConseillers : null
								},
								templateUrl : 'static/views/templatesAdmin/nouvellesInscriptions.html',// 'partial-home-list.html',
								controller : 'demandesInscriptionsCtrl'
							})
					.state(
							'espaceAdmin.etatsInscriptions',
							{
								url : '/etatsInscriptions',
								templateUrl : 'static/views/templatesAdmin/etatsInscriptions.html',// 'partial-home-list.html',
								controller : 'etatsInscriptionsCtrl'
							})

					.state(
							'espaceAdmin.ajouterConseiller',
							{
								url : '/ajouterConseiller',
								templateUrl : 'static/views/templatesAdmin/ajouterConseiller.html',
								controller : 'ajouterConseillerCtrl'
							})
					.state(
							'espaceAdmin.consulterEtatDemande',
							{
								url : '/consulterEtatDemande',
								params : {
									demande : null
								},
								templateUrl : 'static/views/templatesAdmin/consulterEtatDemande.html',
								controller : 'consulterEtatDemandeCtrl'
							})

					.state(
							'espaceAdmin.consulterConseiller',
							{
								url : '/consulterConseiller',
								templateUrl : 'static/views/templatesAdmin/consulterConseiller.html',
								controller : 'consulterConseillerCtrl'
							})

					/*-------------------------------------------------------*/
					/*--------------------- Espace Conseiller -------------------*/
					/*-------------------------------------------------------*/

					.state('espaceConseiller', {
						url : '/conseiller',
						templateUrl : 'static/views/espaceConseiller.html',
						controller : 'conseillerCtrl'
					})

					.state(
							'espaceConseiller.demandesClients',
							{
								url : '/demandesclients',
								params: {
									demandesChequier:null,
									demandesModif:null,
									demandesNCompte:null
								},
								templateUrl : 'static/views/templatesConseiller/demandesClients.html',// 'partial-home-list.html',
								controller : 'demandesClientsCtrl'
							})

					.state(
							'espaceConseiller.comptesClients',
							{
								url : '/comptesClients',
								params : {
									listClients : null,
									listComptes : null
								},
								templateUrl : 'static/views/templatesConseiller/comptesClients.html',// 'partial-home-list.html',
								controller : 'comptesClientsCtrl'
							})

					.state(
							'espaceConseiller.inscriptions',
							{
								url : '/inscriptions',
								params : {
									demandesInscription : null
								},
								templateUrl : 'static/views/templatesConseiller/inscriptions.html',// 'partial-home-list.html',
								controller : 'inscriptionsCtrl'
							})

					.state(
							'espaceConseiller.messages',
							{
								url : '/messages',
								templateUrl : 'static/views/templatesConseiller/messages.html',// 'partial-home-list.html',
								controller : 'messagesCtrl'
							})

					.state(
							'espaceConseiller.demandeChequierConseiller',
							{
								url : '/demandeChequierConseiller',
								params : {
									demande : null
								},
								templateUrl : 'static/views/templatesConseiller/demandeChequierConseiller.html',
								controller : 'demandeChequierConseillerCtrl'
							})

					.state(
							'espaceConseiller.demandeModifCompte',
							{
								url : '/demandeModifCompte',
								templateUrl : 'static/views/templatesConseiller/demandeModifCompte.html',
								controller : 'demandeModifCompteCtrl'
							})

					.state(
							'espaceConseiller.demandeOuvertureNouveauCompte',
							{
								url : '/demandeOuvertureNouveauCompte',
								templateUrl : 'static/views/templatesConseiller/demandeOuvertureNouveauCompte.html',
								controller : 'demandeOuvertureNouveauCompteCtrl'
							})

					.state(
							'espaceConseiller.detailMessageReçu',
							{
								url : '/detailMessageReçu',
								templateUrl : 'static/views/templatesConseiller/detailMessageReçu.html',
								controller : 'detailMessageReçuCtrl'
							})

					.state(
							'espaceConseiller.detailMessageEnvoye',
							{
								url : '/detailMessageEnvoye',
								templateUrl : 'static/views/templatesConseiller/detailMessageEnvoye.html',
								controller : 'detailMessageEnvoyeCtrl'
							})

					.state(
							'espaceConseiller.consulterDemandesInscriptions',
							{
								url : '/consulterDemandesInscriptions',
								params : {
									demande : null							
								},
								templateUrl : 'static/views/templatesConseiller/consulterDemandesInscriptions.html',
								controller : 'consulterDemandesInscriptionsCtrl'
							})

					.state(
							'espaceConseiller.syntheseComptesClient',
							{
								url : '/syntheseComptesClient',
								templateUrl : 'static/views/templatesConseiller/syntheseComptesClient.html',
								controller : ''
							})

					.state(
							'espaceConseiller.contacterDemandeurInscription',
							{
								url : '/contacterDemandeurInscription',
								templateUrl : 'static/views/templatesConseiller/contacterDemandeurInscription.html',
								controller : 'contacterDemandeurInscriptionCtrl'
							})
							
							.state(
							'espaceConseiller.historiqueConseiller',
							{
								url : '/historiqueConseiller',
								params : {
									compte : null,
									listComptes : null
								},
								templateUrl : 'static/views/templatesConseiller/historiqueConseiller.html',// 'partial-home-list.html',
								controller : 'historiqueConseillerCrtl'
							})
							
					.state(
							'espaceConseiller.contacterClient',
							{
								url : '/contacterClient',
								params : {
									client : null
								},
								templateUrl : 'static/views/templatesConseiller/contacterClient.html',
								controller : 'contacterClientCtrl'
							})

					/*-------------------------------------------------------*/
					/*--------------------- Espace Client -------------------*/
					/*-------------------------------------------------------*/
					.state('espaceClient', {
						url : '/client',
						params : {
							listComptes : null
						},
						templateUrl : 'static/views/espaceClient.html',
						controller : 'clientCtrl'
					})

					.state(
							'espaceClient.messagesConseiller',
							{
								url : '/messagesConseiller',
								templateUrl : 'static/views/templatesClient/messagesConseiller.html',// 'partial-home-list.html',
								controller : 'messagesConseillerCtrl'
							})

					.state(
							'espaceClient.virement',
							{
								url : '/virement',
								templateUrl : 'static/views/templatesClient/virement.html',// 'partial-home-list.html',
								controller : 'virementCtrl'
							})

					.state(
							'espaceClient.editerRIB',
							{
								url : '/editerRIB',
								templateUrl : 'static/views/templatesClient/editerRIB.html',// 'partial-home-list.html',
								controller : function($scope) {
									$scope.dogs = [ 'Bernese', 'Husky',
											'Goldendoodle' ];
								}
							})

					.state(
							'espaceClient.demandeModifCompte',
							{
								url : '/demandeModifCompte',
								params : {
									listComptes : null
								},
								templateUrl : 'static/views/templatesClient/demandeModifCompte.html',// 'partial-home-list.html',
								controller : 'demandeModifCompteCtrl'
								
							})

					.state(
							'espaceClient.demandeChequier',
							{
								url : '/demandeChequier',
								params : {
									listComptes : null
								},
								templateUrl : 'static/views/templatesClient/demandeChequier.html',// 'partial-home-list.html',
								controller : 'demandeChequierCtrl'
							})

					.state(
							'espaceClient.demandeOuvertureCompte',
							{
								url : '/demandeOuvertureCompte',
								params : {
									listComptes : null
								},
								templateUrl : 'static/views/templatesClient/demandeOuvertureCompte.html',// 'partial-home-list.html',
								controller : 'demandeOuvertureCompteCtrl'
							})

					.state(
							'espaceClient.mesInformations',
							{
								url : '/mesInformations',
								templateUrl : 'static/views/templatesClient/mesInformations.html',// 'partial-home-list.html',
								controller : 'modifInfo'
							})

					.state(
							'espaceClient.mesAlertes',
							{
								url : '/mesAlertes',
								templateUrl : 'static/views/templatesClient/mesAlertes.html',// 'partial-home-list.html',
								controller : 'mesAlertesCtrl'
															
							})
							
					.state(
							'espaceClient.notifictionDemande',
							{
								url : '/notifictionDemande',
								params : {
									notif : null
								},
								templateUrl : 'static/views/templatesClient/notifictionDemande.html',// 'partial-home-list.html',
								controller : 'notificationDemandeCtrl'							
							})	
							
					.state(
							'espaceClient.notifictionMessage',
							{
								url : '/notifictionMessage',
								params : {
									notif : null
								},
								templateUrl : 'static/views/templatesClient/notifictionMessage.html',// 'partial-home-list.html',
								controller : 'notifictionMessageCtrl'
															
							})	
							
					.state(
							'espaceClient.notifictionTransaction',
							{
								url : '/notifictionTransaction',
								params : {
									notif : null
								},
								templateUrl : 'static/views/templatesClient/notifictionTransaction.html',// 'partial-home-list.html',
								controller : 'notifictionTransactionCtrl'
															
							})
							
					.state(
							'espaceClient.synthese',
							{
								url : '/synthese',
								templateUrl : 'static/views/templatesClient/synthese.html',// 'partial-home-list.html',
								controller : 'syntheseComptesCtrl'
							})

					.state(
							'espaceClient.historique',
							{
								url : '/historique',
								params : {
									compte : null,
									listComptes : null
								},
								templateUrl : 'static/views/templatesClient/historique.html',// 'partial-home-list.html',
								controller : 'historiqueCrtl'
							});

			/*
			 * .when('/seConnecter',{
			 * templateUrl:'static/views/tempConnexion.html', controller:
			 * 'connexionController' })
			 */
		})
