/**
 * FE App Script
 */

var myFeApp = angular.module('myFeApp',['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

myFeApp.controller('contactsController',['$scope','$http','filterFilter','addContactFactory',function($scope,$http,filterFilter,addContactFactory){

	 $scope.jasonDataObjects = '';
	 $scope.productID='';
	 $scope.contact = { };
	 
		 
	 $scope.submit = function(){
		 $scope.contact.product = $scope.productID;
		 addContactFactory.AddCustomer($scope.contact);
		 
		/* $scope.contact = '';*/
	 };
	 
	 /*$scope.reset = function(form) {
		    if (form) {
		      form.$setPristine();
		      form.$setUntouched();
		    }
		    $scope.user = angular.copy($scope.contact);
		  };

	 $scope.reset();*/
	 
	// Any function returning a promise object can be used to load values asynchronously
	  $scope.getLocation = function(val) {
	    
		  return $http({method:'GET', url:'http://localhost:8081/SatsoAssess/satso/product/'+val+'',cache:true}).
         then(function(response) {
        	 $scope.jasonDataObjects = response.data;
           return response.data.map(function(item){
		    	  return item.name;
		      });
         }, function(response) {
           $scope.data = response.data || 'Request failed';
           $scope.status = response.status;
       });
	    
	    
	  };

	  $scope.onSelect = function ($item, $model, $label) {
		    $scope.$item = $item;
		    $scope.jasonDataObjects = filterFilter($scope.jasonDataObjects, $item);
		    $scope.productID = $scope.jasonDataObjects[0].id;
	  };
	  
}]);


myFeApp.factory('addContactFactory',['$http',function($http){
	var cont = {};
	
	cont.AddCustomer = function(contacts)
	{
		$http.post('http://localhost:8081/SatsoAssess/satso/customer',contacts).then(function successCallback(response){	
			
				alert('Status: '+response.data.status+'\n'+'Message: '+response.data.message);
		     
		},function errorCallback(response){
			alert('Status: '+response.data.status+'\n'+'Message: '+response.data.message);
		});
	}
	
	return cont;
}]);



myFeApp.controller('cellPatternController',['$scope',function($scope){

	$scope.regex = '(^0[87][123467]((\\d{7})|( |-)((\\d{3}))( |-)(\\d{4})|( |-)(\\d{7})))';

}]);

myFeApp.controller('emailPatternController',['$scope',function($scope){

	$scope.regex = '^(([^<>()\\[\\]\\\\.,;:\\s@"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@"]+)*)|(".+"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$';

}]);


