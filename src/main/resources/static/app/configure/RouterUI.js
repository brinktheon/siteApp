angular.module('viewCfg', ['ui.router'])
    .config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/main');
    $stateProvider

        .state('main', {
            url: '/main',
            templateUrl: 'mainContent.html'
        })
        .state('employee', {
            url: '/allEmployee',
            templateUrl: 'employees.html'
        })
        .state('SomeSpec', {
            url: '/SomeSpec/',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
            })
});