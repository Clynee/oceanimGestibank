var app = angular.module("monApp",['ngRoute']);

app.controller ('formCtrl',function($scope){
	$scope.submitForm=function(){
		console.log ('valid'+ $scope.form.username.$valid)
		console.log ('valid' + $scope.form.password.$valid)
		console.log ('valid' + $scope.form.cp.$valid)
	}
	/*$scope.username="";
	$scope.password="";
	$scope.auth="Données saisies";
	$scope.authenticate(monForm, auth)=function(){
		//Renvoi sur les pages le concernant selon id

	}
*/
	})
	



 


