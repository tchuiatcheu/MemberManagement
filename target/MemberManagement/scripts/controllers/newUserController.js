
angular.module('memberManagement').controller('NewUserController', function ($scope, $location, locationParser, UserResource , MemberResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.user = $scope.user || {};
    
    $scope.usernameList = MemberResource.queryAll(function(items){
        $scope.usernameSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("usernameSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.user.username = {};
            $scope.user.username.id = selection.value;
        }
    });
    
    $scope.isActifList = [
        "true",
        "false"
    ];


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Users/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        UserResource.save($scope.user, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Users");
    };
});