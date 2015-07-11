'use strict';

var hospitalApp = angular.module('hospitalApp');

hospitalApp.controller('hospitalController', [ '$scope', function($scope) {

	$scope.saveNewPatientRecord = function() {
		alert($scope.newPatient.firstName);
	}
	
} ]);


hospitalApp.controller('newPatientController', [ '$scope','patientService', function($scope, patientService) {

	$scope.newPatient = {};
	
	$scope.message = 'Waiting for Patient details';
	
	console.log('patient: '+ $scope.newPatient);
	
	$scope.saveNewPatientRecord = function() {
		
		console.log('inside saveNewPatientRecord method in controller');
		
		// alert($scope.newPatient);
		
		patientService.saveNewPatient($scope.newPatient);
		
	}

} ]);


hospitalApp.controller("listPatientsController", ['$scope', 'patientService', function($scope, patientService) {
	
	var promise = patientService.listPatients();
	
	promise.then(function(data){
		$scope.patients = data;
	})
} ]);


hospitalApp.controller("patientProfileController", ['$scope','patientService', function($scope, patientService){

	
		var promise = patientService.getPatientById();
		
		promise.then(function(data){
			$scope.patientProfile = data;
		})
	
	
}]);