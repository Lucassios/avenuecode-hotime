angular.module("hotime").controller("Autenticacao", function($scope, APIAutenticacao){

	$scope.autenticar = function (email, senha) {
        APIAutenticacao.autenticar(email, senha).then(function(response){
        	if (response.data.length != undefined) {
                alert("Falha na autenticação! Verifique seu usuário e senha.");
			} else {
                localStorage.setItem('funcionario', JSON.stringify(response.data));
                console.log(localStorage.getItem('funcionario'));
        		window.location = "http://localhost:8080/pages/index.html"
			}
		},function(err){
			alert("Falha na autenticação! Verifique seu usuário e senha.");
			console.log("Erro");
			console.log(err);
		});
	};

});
