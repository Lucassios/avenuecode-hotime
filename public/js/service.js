angular.module("hotime").factory("APIValorHora", function($http){
	var _listarValorHora = function(){
		return $http.get('http://localhost:8080/valorHoras');
	};

	var _excluirValorHora = function(id){
		return $http.delete('http://localhost:8080/valorHora/' + id);
	};

	return {
		listar: _listarValorHora,
		excluir: _excluirValorHora
	};
});