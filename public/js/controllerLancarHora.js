angular.module("hotime").controller('LancarHoraController',function($scope, APIHorasLancadas, APILocalidade, APIValorHora){
	$scope.horasLancadas = [];
	$scope.valorHoras = [];
	$scope.localidades = [];

	$scope.loadAPI = function(){
		APIHorasLancadas.listar().then(function(response){
			console.log("Horas Lancadas");
			console.log(response.data);
			if (response.data) {
				$scope.horasLancadas = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APIValorHora.listar().then(function(response){
			console.log("Valor Horas");
			console.log(response.data);
			if (response.data) {
				$scope.valorHoras = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APILocalidade.listar().then(function(response){
			console.log("Localidades >>> ");
			console.log(response.data);
			if (response.data) {
				$scope.localidades = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});
	}
	$scope.loadAPI();
});
