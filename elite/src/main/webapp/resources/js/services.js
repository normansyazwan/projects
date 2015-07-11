'use strict';

var hospitalApp = angular.module('hospitalApp');

hospitalApp.service("patientService", [
		'$http',
		'$q',
		function($http, $q) {

			this.saveNewPatient = function(newPatientData) {

				console.log('inside saveNewPatient method');

				$http.post("rest/patient/add", newPatientData).success(
						function(data, status, headers, config) {
							console.log('Patient saved successfully. '
									+ data);
						}).error(function(data, status, headers, config) {
					console.log('Patient Save Failed. ' + data);
				})

			};
			
			this.listPatients = function(){
				
				console.log("inside list patients to fetch list of patients");
				
				var deferred = $q.defer();
				$http.get("rest/patients").then(function(data){
					deferred.resolve(data);
				});
				
				return deferred.promise;
			};

			
			this.getPatientById = function(){
				
			};
			
		} ]);



