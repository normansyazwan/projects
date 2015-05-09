'use strict';

var hospitalApp = angular.module('hospitalApp');

hospitalApp.service("patientService", [
		'$scope',
		'$http',
		'$q',
		function($scope, $http, $q) {

			this.saveNewPatient = function() {

				console.log('inside saveNewPatient method');

				$http.post("/rest/patient/add", $scope.newPatient).success(
						function(data, status, headers, config) {
							$scope.message = 'Patient saved successfully. '
									+ data;
						}).error(function(data, status, headers, config) {
					$scope.message = 'Patient Save Failed. ' + data;
				})

			}

		} ]);