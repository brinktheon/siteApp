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
        .state('PharmacisSpec', {
            url: '/PharmacisSpec/',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
            })
        .state('AllergistSpec', {
            url: '/AllergistSpec',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
        })
        .state('CardiologistSpec', {
            url: '/CardiologistSpec',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
        })
        .state('GynecologistSpec', {
            url: '/GynecologistSpec',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
        })
        .state('OtolaryngologistSpec', {
            url: '/OtolaryngologistSpec',
            params: {
                valueSpec: null
            },
            templateUrl: 'specialties.html',
            controller: 'EmpSpecCtrl'
        })
});