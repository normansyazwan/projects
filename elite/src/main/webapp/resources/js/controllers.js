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
		
		patientService.saveNewPatient();
		
	}

} ]);