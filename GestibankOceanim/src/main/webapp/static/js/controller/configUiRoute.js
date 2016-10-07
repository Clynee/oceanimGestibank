routerApp.config(function($stateProvider,$urlRouterProvider){
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
	
	.state('home',{
		url:'/',
		templateUrl:'menuVertical.html',
		controller:'tempCtrl'
	})
	
    
    .state('home.virement', {
        url: '/virement',
        templateUrl: 'templatesClient/virement.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.editerRIB', {
        url: '/editerRIB',
        templateUrl: 'templatesClient/editerRIB.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.demandeModifCompte', {
        url: '/demandeModifCompte',
        templateUrl: 'templatesClient/demandeModifCompte.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.demandeChequier', {
        url: '/demandeChequier',
        templateUrl: 'templatesClient/demandeChequier.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.demandeOuvertureCompte', {
        url: '/demandeOuvertureCompte',
        templateUrl: 'templatesClient/demandeOuvertureCompte.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.mesInformations', {
        url: 'mesInformations',
        templateUrl: 'templatesClient/mesInformations.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    
    .state('home.mesAlertes', {
        url: '/mesAlertes',
        templateUrl: 'templatesClient/mesAlertes.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })
    
    .state('home.synthese', {
        url: '/synthese',
        templateUrl: 'templatesClient/synthese.html',//'partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    });
    
    
    
});


routerApp.controller("modifInfo", function($scope) {
    $scope.showMe = false;
    $scope.modif = function() {
     $scope.showMe = !$scope.showMe;
    }
});


routerApp.controller('tempCtrl', [
                    		'$scope',
                    		'$location',
                    		'$window',
                    		'$sce',function($scope, $location, $window, $sce) {

                    			$scope.dynamicPopover = {
                    				content : 'Hello, World!',
                    				templateUrl : 'virement.html',// 'myPopoverTemplate.html',//
                    				title : 'Title'
                    			};
                    			$scope.placement = {
                    				options : [ 'top', 'top-left', 'top-right', 'bottom',
                    						'bottom-left', 'bottom-right', 'left', 'left-top',
                    						'left-bottom', 'right', 'right-top', 'right-bottom' ],
                    				selected : 'right'
                    			};

                    }]);

