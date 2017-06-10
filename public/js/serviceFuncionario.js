angular.module("hotime").factory("APIFuncionario", function($http){
	var _buuscarfuncionario = function(id){
		return $http.get('http://localhost:8080/api/funcionario/' + id);
	};

	var _listarfuncionario = function(){
		return $http.get('http://localhost:8080/api/funcionario');
	};

	var _salvarfuncionario = function(funcionario){
		return $http.post('http://localhost:8080/api/funcionario', funcionario);
	};

	var _excluirfuncionario = function(id){
		return $http.delete('http://localhost:8080/api/funcionario/' + id);
	};

	return {
		buscar: _buuscarfuncionario,
		salvar: _salvarfuncionario,
		listar: _listarfuncionario,
		excluir: _excluirfuncionario
	};
});