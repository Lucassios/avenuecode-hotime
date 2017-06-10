angular.module("hotime").factory("APIValorHora", function($http){
	var _buuscarValorHora = function(id){
		return $http.get('http://localhost:8080/api/valorHora/' + id);
	};

	var _listarValorHora = function(){
		return $http.get('http://localhost:8080/api/valorHora');
	};

	var _salvarValorHora = function(valorHora){
		return $http.post('http://localhost:8080/api/valorHora', valorHora);
	};

	var _excluirValorHora = function(id){
		return $http.delete('http://localhost:8080/api/valorHora/' + id);
	};

	return {
		buscar: _buuscarValorHora,
		salvar: _salvarValorHora,
		listar: _listarValorHora,
		excluir: _excluirValorHora
	};
});