var app = angular.module('EmployeeModule', ['lazy-scroll']);
app.controller('EmpCtrl', function ($scope, $http) {
   $scope.employees = [];
   $scope.someData = [];
   $scope.page = 0;

   refreshEmployeeData();
   function refreshEmployeeData() {
       $http.get("http://localhost:8080/api/doctors?page=0&size=50")
           .then(function(response) {
               $scope.employees = response.data;
               $scope.someData = $scope.employees.slice(0, 50);
           });
   }

   $scope.loadMore = function () {
       $scope.page++;
       $http.get("http://localhost:8080/api/doctors?page=" + $scope.page + "&size=30")
           .then(function(response) {
               $scope.employees = $scope.employees.concat(response.data);
           });
       $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
   }
});