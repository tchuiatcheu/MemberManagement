
angular.module('memberManagement').controller('NewMemberController', function ($scope, $location, locationParser, MemberResource , MemberResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.member = $scope.member || {};
    
    $scope.invitedByList = MemberResource.queryAll(function(items){
        $scope.invitedBySelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("invitedBySelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.member.invitedBy = {};
            $scope.member.invitedBy.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Members/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        MemberResource.save($scope.member, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Members");
    };
});