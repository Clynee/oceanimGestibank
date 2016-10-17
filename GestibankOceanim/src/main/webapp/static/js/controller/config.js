App.config(function ($stateProvider,$urlRouterProvider){
	//Système de routage
	/*$urlRouterProvider.otherwise('');
	*/
	$stateProvider
	
	.state('acceuil',{
		url:'',
		templateUrl:'static/views/templatesAcceuil/acceuil.html',
		controller: 'LoginController'
	})
	
	
	/*-------------------------------------------------------*/
	/*--------------------- Espace Admin -------------------*/
	/*-------------------------------------------------------*/
	.state('espaceAdmin',{
		url:'/admin',
		templateUrl:'static/views/espaceAdmin.html',
		controller: ''
	})
	
	.state('espaceAdmin.gestionConseillers', {
        url: '/gestionConseillers',
        templateUrl: 'static/views/templatesAdmin/gestionConseillers.html',//'partial-home-list.html',
        controller: ''
    })
    
    .state('espaceAdmin.nouvellesInscriptions', {
        url: '/nouvellesInscriptions',
        templateUrl: 'static/views/templatesAdmin/nouvellesInscriptions.html',//'partial-home-list.html',
        controller: ''
    })
	
    .state('espaceAdmin.etatsInscriptions', {
        url: '/etatsInscriptions',
        templateUrl: 'static/views/templatesAdmin/etatsInscriptions.html',//'partial-home-list.html',
        controller: ''
    })
    
    
	/*-------------------------------------------------------*/
	/*--------------------- Espace Conseiller -------------------*/
	/*-------------------------------------------------------*/
	
	.state('espaceConseiller',{
		url:'/conseiller',
		templateUrl:'static/views/espaceConseiller.html',
		controller: ''
	})
	
	.state('espaceConseiller.demandesClients', {
        url: '/virement',
        templateUrl: 'static/views/templatesConseiller/demandesClients.html',//'partial-home-list.html',
        controller: 'demandesClientsCtrl'
    })
    
    .state('espaceConseiller.comptesClients', {
        url: '/comptesClients',
        templateUrl: 'static/views/templatesConseiller/comptesClients.html',//'partial-home-list.html',
        controller: 'comptesClientsCtrl'
    })
    
    .state('espaceConseiller.inscriptions', {
        url: '/inscriptions',
        templateUrl: 'static/views/templatesConseiller/inscriptions.html',//'partial-home-list.html',
        controller: 'inscriptionsCtrl'
    })
    
    .state('espaceConseiller.messages', {
        url: '/messages',
        templateUrl: 'static/views/templatesConseiller/messages.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
	/*-------------------------------------------------------*/
	/*--------------------- Espace Client -------------------*/
	/*-------------------------------------------------------*/
	.state('espaceClient',{
		url:'/client',
		params:{
        	listComptes:null
        },
		templateUrl:'static/views/espaceClient.html',
		controller: 'clientCtrl'
	})
	
	
	.state('espaceClient.virement', {
        url: '/virement',
        templateUrl: 'static/views/templatesClient/virement.html',//'partial-home-list.html',
        controller: 'virementCtrl'
    })
    
    .state('espaceClient.editerRIB', {
        url: '/editerRIB',
        templateUrl: 'static/views/templatesClient/editerRIB.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('espaceClient.demandeModifCompte', {
        url: '/demandeModifCompte',
        templateUrl: 'static/views/templatesClient/demandeModifCompte.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('espaceClient.demandeChequier', {
        url: '/demandeChequier',
        templateUrl: 'static/views/templatesClient/demandeChequier.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('espaceClient.demandeOuvertureCompte', {
        url: '/demandeOuvertureCompte',
        templateUrl: 'static/views/templatesClient/demandeOuvertureCompte.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('espaceClient.mesInformations', {
        url: '/mesInformations',
        templateUrl: 'static/views/templatesClient/mesInformations.html',//'partial-home-list.html',
        controller: 'modifInfo'
    })
    
    
    .state('espaceClient.mesAlertes', {
        url: '/mesAlertes',
        templateUrl: 'static/views/templatesClient/mesAlertes.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('espaceClient.synthese', {
        url: '/synthese',
        templateUrl: 'static/views/templatesClient/synthese.html',//'partial-home-list.html',
        controller: 'syntheseComptesCtrl'
    })
    
	.state('espaceClient.historique', {
        url: '/historique',
        params: {
            compte: null,
            listComptes:null
        },
        templateUrl: 'static/views/templatesClient/historique.html',//'partial-home-list.html',
        controller: 'historiqueCrtl'        
    });
	
	/*
	.when('/seConnecter',{
		templateUrl:'static/views/tempConnexion.html',
		controller: 'connexionController'
	})
	*/
})
