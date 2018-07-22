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
        .state('spec', {
                url: '/PharmacisSpec',
                templateUrl: 'specialties.html'
            });
});