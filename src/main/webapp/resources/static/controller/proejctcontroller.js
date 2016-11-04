'use strict';
(function() {
    var ProjectController = function($scope, GenericFactory) {
        $scope.projects = [],
       $scope.project = {gender:'M'};
        var me = this;
         
        me.doGetProjects = function(){
            GenericFactory.getMethod({
                url : '/projects',
                successCB : function(result) {
                    $scope.projects = result;
                }
            });
        }
         
        $scope.doDeleteProject = function(id){
            GenericFactory.deleteMethod({
                url : '/projects',
                data : id,
                successCB : function(result) {
                    me.doGetProjects();
                }
            });
        }
         
        $scope.doEditProject = function(id){
            for (var i = 0; i < $scope.projects.length; i++) {
                if($scope.projects[i].id === id){
                    $scope.project = $scope.projects[i];
                    break;
                }
            }
        }
         
        me.createProject = function(){
            GenericFactory.postMethod({
                url : '/projects',
                data : $scope.project, 
                successCB : function(result) {
                    me.doGetProjects();
                }
            });
        }
         
        me.updateProject = function(){
            GenericFactory.putMethod({
                url : '/projects',
                data : $scope.project, 
                successCB : function(result) {
                    me.doGetProjects();
                }
            });
        }
         
        $scope.doSubmit = function(){
            if($scope.projects.id !== ''){
                me.updateProject();
            }else{
                me.createProject();
            }
        }
         
        $scope.reset = function(){
           // $scope.project = {gender:'M'};
            $scope.projectForm.$setPristine();
        }
         
        function init() {
            me.doGetProjects();
        }
        init();
         
    };
 
    myApp.controllers.controller('ProjectController', [ '$scope', 'GenericFactory', ProjectController ]);
})();