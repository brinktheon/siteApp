var app = angular.module('EmployeeModule', ['lazy-scroll']);
app.controller('EmpCtrl', function ($scope, $http) {
   $scope.employees = [];
        $scope.someData = [];
        _refreshEmployeeData();
        function _refreshEmployeeData() {
            $http.get("http://localhost:8080/api/doctors")
                .then(function(response) {
                    $scope.employees = response.data;
                    $scope.someData = $scope.employees.slice(0, 50);
                });
        }


        $scope.loadMore = function () {
            $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
        }
});