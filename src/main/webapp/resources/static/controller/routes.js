'use strict';
(function() {
    myApp.controllers.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            controller : 'ProjectController',
            templateUrl : '/view/projects.jsp'
        }).otherwise('/');
    } ]);
})();