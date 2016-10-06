

App.controller ('formCtrl',function($scope){
	$scope.title = "titre de ..";
	});



App.controller('connexionCtrl',function($scope,$location){
	
});



App.controller('PopoverDemoCtrl', function ($scope, $sce) {
  $scope.dynamicPopover = {
    content: 'Hello, World!',
    templateUrl: 'static/views/tempConnexion.html',//'myPopoverTemplate.html',//
    title: 'Title'
  };

  $scope.placement = {
    options: [
      'top',
      'top-left',
      'top-right',
      'bottom',
      'bottom-left',
      'bottom-right',
      'left',
      'left-top',
      'left-bottom',
      'right',
      'right-top',
      'right-bottom'
    ],
    selected: 'bottom-right'
  };
  
  $scope.htmlPopover = $sce.trustAsHtml('<b style="color: red">I can</b> have <div class="label label-success">HTML</div> content');
});

App.controller('AccordionDemoCtrl', function ($scope,$location) {
	  $scope.oneAtATime = true;

	  $scope.click = function(url){
		  	$location.url(url);
	  }
	  
	  $scope.groups = [
	    {
	      title: 'Dynamic Group Header - 1',
	      content: 'Dynamic Group Body - 1'
	    },
	    {
	      title: 'Dynamic Group Header - 2',
	      content: 'Dynamic Group Body - 2'
	    }
	  ];

	  $scope.items = ['Item 1', 'Item 2', 'Item 3'];

	  $scope.addItem = function() {
	    var newItemNo = $scope.items.length + 1;
	    $scope.items.push('Item ' + newItemNo);
	  };

	  $scope.status = {
	    isFirstOpen: true,
	    isFirstDisabled: false
	  };
	});


/*------ De Céline --------*/

App.controller("modifInfo", function($scope) {
    $scope.showMe = false;
    $scope.modif = function() {
     $scope.showMe = !$scope.showMe;
    }
});

App.controller('tempCtrl', [
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


