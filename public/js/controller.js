angular.module("hotime").controller("ValorHora", function($scope, APIValorHora){
	APIValorHora.listar().then(function(response){
		console.log(response);
	},function(response){
		console.log(response);
	});
});
