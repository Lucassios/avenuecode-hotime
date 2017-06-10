angular.module("hotime").controller("Funcionario", function($scope, APIFuncionario, APICargo){
	$scope.funcionarios = [];
	$scope.cargos = [];

	$scope.salvar = function (data) {
		console.log(data);
		APIFuncionario.salvar(data).then(function(response){
			console.log(response.data);
			if (response.data) {
				$scope.valorHoras = response.data;
			}
		},function(err){
			alert("Erro ao salvar Fucnioanario!");
			console.log("Erro");
			console.log(err);
		});
	};

	$scope.loadAPI = function(){
		APIFuncionario.listar().then(function(response){
			console.log("Cargos");
			console.log(response.data);
			if (response.data) {
				$scope.funcionarios = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APICargo.listar().then(function(response){
			console.log("Cargos");
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
	$scope.excluir = function(id){
		alert(id);
	};
	$scope.salvar = function(funcionario) {
		console.log(funcionario);
		APIFuncionario.salvar(funcionario).then(function(response){
			console.log("Result");
			console.log(response.data);
		},function(err){
			alert("Erro ao salvar funcionario");
			console.log("Erro");
			console.log(err);
		});
	};
	$scope.loadAPI();
});