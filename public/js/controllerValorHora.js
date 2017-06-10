angular.module("hotime").controller("ValorHora", function($scope, APIValorHora, APICargo){
	$scope.valorHoras = [];
	$scope.cargos = [];

	$scope.salvar = function (data) {
		console.log(data);
		APIValorHora.salvar(data).then(function(response){
			console.log(response.data);
			if (response.data) {
				$scope.valorHoras = response.data;
			}
		},function(err){
			alert("Erro ao salvar Valor Hora!");
			console.log("Erro");
			console.log(err);
		});
	};

	$scope.loadAPI = function(){
		APIValorHora.listar().then(function(response){
			console.log("Cargos");
			console.log(response.data);
			if (response.data) {
				$scope.valorHoras = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APICargo.listar().then(function(response){
			console.log(response.data);
			if (response.data) {
				$scope.cargos = response.data;
			}
		},function(err){
			alert("Erro ao consultar API Cargos");
			console.log("Erro");
			console.log(err);
		});
	}
	$scope.loadAPI();
});
