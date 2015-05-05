
angular.module('memberManagement').controller('NewGainController', function ($scope, $location, locationParser, GainResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.gain = $scope.gain || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Gains/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        GainResource.save($scope.gain, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Gains");
    };
});