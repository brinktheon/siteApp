angular.module('MainService', [])
    .service('EmployeesService', ['$http', function($http){

        this.getSomeData = function(){
            return $http.get('/api/doctors?page=0&size=50')
                .then(function(response){
                    return response.data;
                });
        };

        this.loadMoreEml = function(page){
            return $http.get("/api/doctors?page=" + page + "&size=30")
                .then(function(response){
                    return response.data;
                });
        };

        this.getSomeSpecData = function(){
            return  $http.get("/api/doctors/Pharmacis?page=0&size=50")
                .then(function(response){
                    return response.data;
                });
        };

        this.loadMoreSpec = function(page){
            return $http.get("/api/doctors/Pharmacis?page=" + page + "&size=30")
                .then(function(response){
                    return response.data;
                });
        };

    }]);