App.controller('formCtrl', function($scope) {
	$scope.title = "titre de ..";
});

App.controller('connexionCtrl', function($scope, $location) {

});

//App.controller('demandesClientsCtrl', function($scope, $log) {
//
//	$scope.listDemandes = listDemandes;
//	// $scope.totalItems = 4;
//	// $scope.currentPage = 4;
//
//	$scope.setPage = function(pageNo) {
//		$scope.currentPage = pageNo;
//
//	};
//
//	$scope.pageChanged = function() {
//		$log.log('Page changed to: ' + $scope.currentPage);
//	};
//
//	$scope.itemsPerPage = 4;
//	$scope.maxSize = 5;
//	$scope.bigTotalItems = listDemandes.length;
//	$scope.bigCurrentPage = 1;
//});

//App.controller('comptesClientsCtrl', function($scope, $log) {
//
//	$scope.listComptes = listComptes;
//	// $scope.totalItems = 4;
//	// $scope.currentPage = 4;
//
//	$scope.setPage = function(pageNo) {
//		$scope.currentPage = pageNo;
//
//	};
//
//	$scope.pageChanged = function() {
//		$log.log('Page changed to: ' + $scope.currentPage);
//	};
//
//	$scope.itemsPerPage = 4;
//	$scope.maxSize = 5;
//	$scope.bigTotalItems = listComptes.length;
//	$scope.bigCurrentPage = 1;
//});

//// Demande Inscriptions
//
//App.controller('inscriptionsCtrl', function($scope, $log) {
//
//	$scope.listdemIns = listdemIns;
//	// $scope.totalItems = 4;
//	// $scope.currentPage = 4;
//
//	$scope.setPage = function(pageNo) {
//		$scope.currentPage = pageNo;
//	};
//
//	$scope.pageChanged = function() {
//		$log.log('Page changed to: ' + $scope.currentPage);
//	};
//
//	$scope.itemsPerPage = 4;
//	$scope.maxSize = 5;
//	$scope.bigTotalItems = listdemIns.length;
//	$scope.bigCurrentPage = 1;
//});
//
App.filter('offset', function() {
	return function(input, start) {
//		return input.slice(start);
	};
})

App
		.controller(
				'PopoverDemoCtrl',
				function($scope, $sce) {
					$scope.dynamicPopover = {
						content : 'Hello, World!',
						templateUrl : 'static/views/tempConnexion.html',// 'myPopoverTemplate.html',//
						title : 'Title'
					};

					$scope.placement = {
						options : [ 'top', 'top-left', 'top-right', 'bottom',
								'bottom-left', 'bottom-right', 'left',
								'left-top', 'left-bottom', 'right',
								'right-top', 'right-bottom' ],
						selected : 'bottom-right'
					};

					$scope.htmlPopover = $sce
							.trustAsHtml('<b style="color: red">I can</b> have <div class="label label-success">HTML</div> content');
				});

App.controller('AccordionDemoCtrl', function($scope, $location) {
	$scope.oneAtATime = true;

	$scope.click = function(url) {
		$location.url(url);
	}

	$scope.groups = [ {
		title : 'Dynamic Group Header - 1',
		content : 'Dynamic Group Body - 1'
	}, {
		title : 'Dynamic Group Header - 2',
		content : 'Dynamic Group Body - 2'
	} ];

	$scope.items = [ 'Item 1', 'Item 2', 'Item 3' ];

	$scope.addItem = function() {
		var newItemNo = $scope.items.length + 1;
		$scope.items.push('Item ' + newItemNo);
	};

	$scope.status = {
		isFirstOpen : true,
		isFirstDisabled : false
	};
});

/*------ De Céline --------*/



App.controller('tempCtrl', [
		'$scope',
		'$location',
		'$window',
		'$sce',
		function($scope, $location, $window, $sce) {

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

		} ]);
