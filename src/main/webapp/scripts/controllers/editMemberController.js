

angular.module('memberManagement').controller('EditMemberController', function($scope, $routeParams, $location, MemberResource , MemberResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.member = new MemberResource(self.original);
            MemberResource.queryAll(function(items) {
                $scope.invitedBySelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.member.invitedBy && item.id == $scope.member.invitedBy.id) {
                        $scope.invitedBySelection = labelObject;
                        $scope.member.invitedBy = wrappedObject;
                        self.original.invitedBy = $scope.member.invitedBy;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Members");
        };
        MemberResource.get({MemberId:$routeParams.MemberId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.member);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.member.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Members");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Members");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.member.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("invitedBySelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.member.invitedBy = {};
            $scope.member.invitedBy.id = selection.value;
        }
    });
    
    $scope.get();
});