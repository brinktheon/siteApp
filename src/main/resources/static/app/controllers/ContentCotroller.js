angular.module('app.controllers')
    .controller('contentCtrl', ['$scope','EmployeesService', function ($scope, EmployeesService) {
        $scope.employees = [];
        $scope.someData = [];
        $scope.page = 0;

        EmployeesService.getContentData().then(function(data) {
            $scope.employees = data;
            $scope.someData = $scope.employees.slice(0, 50);
        });
    }]);