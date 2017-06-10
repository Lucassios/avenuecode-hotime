angular.module("hotime").factory("APILocalidade", function($http){
	var _buuscarlocalidade = function(id){
		return $http.get('http://localhost:8080/api/localidade/' + id);
	};

	var _listarlocalidade = function(){
		return $http.get('http://localhost:8080/api/localidade');
	};

	var _salvarlocalidade = function(localidade){
		return $http.post('http://localhost:8080/api/localidade', localidade);
	};

	var _excluirlocalidade = function(id){
		return $http.delete('http://localhost:8080/api/localidade/' + id);
	};

	return {
		buscar: _buuscarlocalidade,
		salvar: _salvarlocalidade,
		listar: _listarlocalidade,
		excluir: _excluirlocalidade
	};
});