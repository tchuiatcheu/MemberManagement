angular.module('memberManagement').factory('GainResource', function($resource){
    var resource = $resource('rest/gains/:GainId',{GainId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});