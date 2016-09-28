'use strict';

angular.module('app', [])
.controller('ProductController', function($http) {
	var vm = this;
	function refreshData() {
		// console.log('loading');
		$http({
			method : 'GET',
			url : 'api/products'
		}).then(function success(response) {
			vm.products = response.data;
		}, function error(response) {
			console.log('API error ' + response.status);
		});
	}

	vm.addProduct = function(product) {
		$http({
			method : 'POST',
			url : 'api/products',
			data : product
		}).then(function success(response) {
			console.log(response);
			refreshData();
			vm.product = {};
		}, function error(response) {
			console.log('Data not saved ' + product);
		});
	}
	refreshData();
});