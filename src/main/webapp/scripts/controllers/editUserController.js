

angular.module('memberManagement').controller('EditUserController', function($scope, $routeParams, $location, UserResource , MemberResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.user = new UserResource(self.original);
            MemberResource.queryAll(function(items) {
                $scope.usernameSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.user.username && item.id == $scope.user.username.id) {
                        $scope.usernameSelection = labelObject;
                        $scope.user.username = wrappedObject;
                        self.original.username = $scope.user.username;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Users");
        };
        UserResource.get({UserId:$routeParams.UserId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.user);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.user.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Users");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Users");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.user.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("usernameSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.user.username = {};
            $scope.user.username.id = selection.value;
        }
    });
    $scope.isActifList = [
        "true",
        "false"
    ];
    
    $scope.get();
});