angular.module('app.controllers')
    .controller('EmpSpecCtrl', ['$scope','EmployeesService', function ($scope, EmployeesService) {
        $scope.employees = [];
        $scope.someData = [];
        $scope.page = 0;

        EmployeesService.getSomeSpecData().then(function(data) {
            $scope.employees = data;
            $scope.someData = $scope.employees.slice(0, 50);
        });

        $scope.loadMore = function () {
            $scope.page++;
            EmployeesService.loadMoreSpec($scope.page).then(function (data) {
                $scope.employees = $scope.employees.concat(data);
            });
            $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
        }
    }]);