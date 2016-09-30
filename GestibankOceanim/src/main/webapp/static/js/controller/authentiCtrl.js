

App.controller ('formCtrl',function($scope){
	$scope.title = "titre de ..";
	});



App.controller('connexionCtrl',function($scope,$location){
	
})





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



 


