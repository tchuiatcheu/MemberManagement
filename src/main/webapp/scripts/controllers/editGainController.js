

angular.module('memberManagement').controller('EditGainController', function($scope, $routeParams, $location, GainResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.gain = new GainResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Gains");
        };
        GainResource.get({GainId:$routeParams.GainId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.gain);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.gain.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Gains");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Gains");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.gain.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});