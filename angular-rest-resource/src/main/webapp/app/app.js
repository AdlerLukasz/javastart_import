'use strict';

angular.module('app', ['ngResource'])
.controller('ProductController', function($resource) {
	var vm = this;
	var Product = $resource('api/products/:productId');
	vm.product = new Product();
	
	function refreshData() {
		console.log('loading via resource');
		vm.products = Product.query(
				function success(data, headers) {
					console.log('Pobrano dane: ' + data);
					console.log(headers('Content-Type'));
				},
				function error(response) {
					console.log(response.status); //np. 404
				});
	}
	
	vm.addProduct = function(product) {
		console.log(vm.product.__proto__);
		vm.product.$save(function(data) {
			console.log("$save " + JSON.stringify(data));
			refreshData();
			vm.product = new Product();
		});
	}
	
	vm.loadDetails = function(id) {
		vm.details = Product.get({productId: id});
	}
	
	refreshData();
});