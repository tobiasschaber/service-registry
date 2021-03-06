'use strict';

angular.module('service-registry.services', ['ngResource'])
.factory('Service', ['$resource',
  function($resource){
    return $resource(
    		'/api/services', {}, {
    			query: {method:'GET', isArray:true},
    			create: { method: 'POST' }
    		});
  }])
  .factory('ServiceDetail', ['$resource',
  function($resource){
    return $resource(
    		'/api/services/:id', 
    		{id:'@id'}, {
    			show: { method: 'GET' },
    			update: {method: 'PUT', params: {id: '@id'} },
    			delete: {method:'DELETE', params: {id: '@id'} }
    		});
  }]);