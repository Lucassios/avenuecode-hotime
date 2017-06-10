angular.module("hotime").factory("APICargo", function($http){
	var _buuscarCargo = function(id){
		return $http.get('http://localhost:8080/api/cargo/' + id);
	};

	var _listarCargo = function(){
		return $http.get('http://localhost:8080/api/cargo');
	};

	var _salvarCargo = function(cargo){
		return $http.post('http://localhost:8080/api/cargo', cargo);
	};

	var _excluirCargo = function(id){
		return $http.delete('http://localhost:8080/api/cargo/' + id);
	};

	return {
		buscar: _buuscarCargo,
		salvar: _salvarCargo,
		listar: _listarCargo,
		excluir: _excluirCargo
	};
});