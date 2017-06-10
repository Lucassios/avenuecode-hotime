angular.module("hotime").factory("APIAutenticacao", function($http){
	var _autenticar = function(email, senha){
		return $http.get('http://localhost:8080/api/funcionario/autenticar', { params: { email: email, senha: senha } });
	};

	return {
		autenticar: _autenticar,
	};
});