angular.module('app.controllers')
    .controller('appCtrl', ['$scope','EmployeesService', function ($scope, EmployeesService) {
        $scope.employees = [];
        $scope.someData = [];
        $scope.page = 0;

        EmployeesService.getSomeData().then(function(data) {
            $scope.employees = data;
            $scope.someData = $scope.employees.slice(0, 50);
        });

        $scope.loadMore = function () {
            $scope.page++;
            EmployeesService.loadMoreEml($scope.page).then(function (data) {
                $scope.employees = $scope.employees.concat(data);
            });
            $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
        }
    }]);