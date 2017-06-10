angular.module("hotime").controller("ValorHora", function($scope, APIValorHora){
	//Todos
	APIValorHora.listar().then(function(response){
		console.log(response.data);
	},function(err){
		console.log("Erro");
		console.log(err);
	});

	//Buscar 1
	APIValorHora.buscar(1).then(function(response){
		console.log(response.data);
	},function(err){
		console.log("Erro");
		console.log(err);
	});
});
