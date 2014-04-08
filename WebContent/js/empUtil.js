var frontEndApp = angular.module('EmpProject', []);
frontEndApp.controller('EmpCtrl', ['$scope','$http',
                                   function($scope, $http) {
	$scope.getDatafrmServer = function() {
		//alert("entered"+$scope.empIdText+ "   ..  "+$http );
		$http({method: 'GET', url: 'getEmpName.html?id='+$scope.empIdText,headers : { 'Content-Type': 'application/json' }}).
		success(function(data, status, headers, config) {
			//alert("success status"+status+"  .... "+ data.firstName);
			$scope.loadingIsDone = true;
			$scope.content = "Employee Id: "+data.id + " First Name: "+data.firstName + " Last Name: "+data.lastName + " Salary: " + data.salary;
		
		}).
		error(function(data, status, headers, config) {
			alert("error status"+status);
			
		});
	};
}]);