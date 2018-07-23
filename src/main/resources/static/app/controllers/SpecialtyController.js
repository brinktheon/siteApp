angular.module('app.controllers')
    .controller('EmpSpecCtrl', ['$scope','EmployeesService','ngDialog', '$stateParams', function ($scope, EmployeesService, ngDialog, $stateParams) {
        $scope.employees = [];
        $scope.someData = [];
        $scope.page = 0;


        EmployeesService.getSomeSpecData($stateParams.valueSpec).then(function (data) {
            $scope.employees = data;
            $scope.someData = $scope.employees.slice(0, 50);
        });


        $scope.loadMore = function () {
            $scope.page++;
            EmployeesService.loadMoreSpec($scope.page, $stateParams.valueSpec).then(function (data) {
                $scope.employees = $scope.employees.concat(data);
            });
            $scope.someData = $scope.employees.slice(0, $scope.someData.length + 30);
        };


        $scope.cancel = function(){
            ngDialog.close();
        };

        $scope.showInfo = function(person) {
            ngDialog.open({
                template: 'modalDialog.html',
                className: 'ngdialog-theme-default',
                data: {
                    myProperty: person
                }
            });
        }

    }]);