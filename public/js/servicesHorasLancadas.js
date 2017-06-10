angular.module("hotime").factory("APIHorasLancadas", function($http){
	var _lancarHora = function(horatrabalhada){
		return $http.post("http://localhost:8080/api/horatrabalhada",horatrabalhada);
	};

	var _removerHoraTrabalhada = function(id){
		return $http.delete('http://localhost:8080/api/horatrabalhada/' + id);
	};

	var _buscarHoraTrabalhada = function(id){
		return $http.get('http://localhost:8080/api/horatrabalhada'/ + id);
	};

	var _buscarTodasAsHoras = function(){
		return $http.get('http://localhost:8080/api/horatrabalha');
	};

	return {
		lancarHora: _buuscarCargo,
		remover: _removerHoraTrabalhada,
		listar: _buscarTodasAsHoras,
		obter: _buscarHoraTrabalhada
	};
});/**
 * 
 */