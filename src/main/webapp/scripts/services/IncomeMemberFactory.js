angular.module('memberManagement').factory('IncomeMemberResource', function($resource){
    var resource = $resource('rest/incomemembers/:IncomeMemberId',{IncomeMemberId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});