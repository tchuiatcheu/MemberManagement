angular.module('memberManagement').factory('IncomeResource', function($resource){
    var resource = $resource('rest/incomes/:IncomeId',{IncomeId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});