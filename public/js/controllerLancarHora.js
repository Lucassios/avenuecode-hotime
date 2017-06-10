angular.module("hotime").controller('LancarHoraController',function($scope, APIHorasLancadas, APILocalidade, APIValorHora){

    window.onload = function () {
        getLocation();
    };

	$scope.horasLancadas = [];
	$scope.valorHoras = [];
	$scope.localidades = [];

	$scope.loadAPI = function(){
		APIHorasLancadas.listar().then(function(response){
			console.log("Horas Lancadas");
			console.log(response.data);
			if (response.data) {
				$scope.horasLancadas = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APIValorHora.listar().then(function(response){
			console.log("Valor Horas");
			console.log(response.data);
			if (response.data) {
				$scope.valorHoras = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});

		APILocalidade.listar().then(function(response){
			console.log("Localidades >>> ");
			console.log(response.data);
			if (response.data) {
				$scope.localidades = response.data;
			}
		},function(err){
			alert("Erro ao consultar API");
			console.log("Erro");
			console.log(err);
		});
	}
	$scope.loadAPI();

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition, showError);
        }
        else {
            alert("Não há suporte nesse navegador.");
        }
    }

    function showPosition(position) {
        var lat = position.coords.latitude;
        var lng = position.coords.longitude;

        console.log("Lat >> "+ lat);
        console.log("Lng >> "+ lng);

        APILocalidade.obterLocalidade(lat + ',' + lng).then(function (response) {
            console.log("LocalidadeAtual >>> ");
            console.log(response.data);
            if (response.data) {
                $scope.localidadeAtual = response.data;
            }
        }, function (err) {
            alert("Erro ao consultar API");
            console.log("Erro");
            console.log(err);
        })

    }

    function showError(error) {
        switch (error.code) {
            case error.PERMISSION_DENIED:
                alert("Usuário rejeitou a solicitação de Geolocalização.");
                break;

            case error.POSITION_UNAVAILABLE:
                alert("Localização indisponível.");
                break;

            case error.TIMEOUT:
                alert("O tempo da requisição expirou.");
                break;

            case error.UNKNOWN_ERROR:
                alert("Algum erro desconhecido aconteceu.");
                break;
        }
    }
});
