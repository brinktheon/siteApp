var app = angular.module('EmployeeSpecialtyModule', ['lazy-scroll']);
app.controller('EmpSpecCtrl', function ($scope, $http) {
    $scope.employees = [];
    $scope.someData = [];
    $scope.page = 0;


    refreshEmployeeData();
    function refreshEmployeeData() {
        $http.get("/api/doctors/Pharmacis?page=0&size=50")
            .then(function(response) {
                $scope.employees = response.data;
                $scope.someData = $scope.employees.slice(0, 50);у
            });
    }

    $scope.loadMore = function () {
        $scope.page++;
        $http.get("/api/doctors/Pharmacis?page=" + $scope.page + "&size=30")
            .then(function(response) {
                $scope.employees = $scope.employees.concat(response.data);
            });
        $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
    }
});