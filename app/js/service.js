app.factory("API", function($http){
	var _salvarTipoHora = function(dados){
		return $http.post('http://localhost:8080/funcionario/cadastrar', funcionario);
	};

	var _excluirTipoHora = function(id){
		return $http.delete('http://localhost:8080/funcionario/excluir/' + id);
	};
	var _listarFuncionarios = function(){
		return $http.get('http://localhost:8080/funcionario/listar');
	}
	return {
		atualizar: _atualizarFuncionario,
		listar: _listarFuncionarios,
		salvar: _salvarFuncionario,
		excluir: _excluirFuncionario
	};
})