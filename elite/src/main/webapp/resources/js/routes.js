'use strict';

var hospitalApp = angular.module('hospitalApp');

hospitalApp
.config([
		'$routeProvider',
		'$locationProvider',
		function($routeProvider, $locationProvider) {
			$routeProvider
					.when(
							'/',
							{
								controller : 'homeController',
								templateUrl : 'resources/app/partials/homePage.html'
							})
					.when(
							"/addPatient",
							{
								controller : 'newPatientController',
								templateUrl : 'resources/app/partials/patient/addPatient.html'
							})
					.when(
							"/listPatients",
							{
								controller : 'listPatientsController',
								templateUrl : 'resources/app/partials/patient/listPatients.html'
							})
					.when(
							"/patient/profile",
							{
								controller : 'patientProfileController',
								templateUrl : 'resources/app/partials/patient/patientProfile.html'
							})
					.otherwise({ redirectTo : '/'});

		} ]);