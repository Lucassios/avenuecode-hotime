angular.module("hotime").controller("ValorHora", function ($scope, APIValorHora, APICargo, APILocalidade) {
    window.onload = function () {
        getLocation();
    };

    $scope.valorHoras = [];
    $scope.cargos = [];
    $scope.localidades = [];
    $scope.localidadeAtual = {};

    var removeID = function (id) {
        $scope.valorHoras = $scope.valorHoras.map(function (valor) {
            if (valor.id != id) {
                return valor;
            }
        });
    }

    $scope.excluir = function (id) {
        console.log(id);
        APIValorHora.excluir(id).then(function (response) {
            console.log(response.data);
            alert("Valor de hora excluĩda com sucesso!");
            removeID(id);
        }, function (err) {
            alert("Erro ao salvar Valor Hora!");
            console.log("Erro");
            console.log(err);
        });
    };

    $scope.salvar = function (valor) {
        console.log(valor);
        APIValorHora.salvar(valor).then(function (response) {
            console.log("Result");
            $scope.valorHoras.push(response.data);
            alert("Valor de hora cadastrado com sucesso!")
            console.log(response.data);
        }, function (err) {
            alert("Erro ao salvar funcionario");
            console.log("Erro");
            console.log(err);
        });
    };

    $scope.loadAPI = function () {
        APIValorHora.listar().then(function (response) {
            console.log("Cargos");
            console.log(response.data);
            if (response.data) {
                $scope.valorHoras = response.data;
            }
        }, function (err) {
            alert("Erro ao consultar API");
            console.log("Erro");
            console.log(err);
        });

        APILocalidade.listar().then(function (response) {
            console.log("Localidades >>> ");
            console.log(response.data);
            if (response.data) {
                $scope.localidades = response.data;
            }
        }, function (err) {
            alert("Erro ao consultar API");
            console.log("Erro");
            console.log(err);
        });

        APICargo.listar().then(function (response) {
            console.log(response.data);
            if (response.data) {
                $scope.cargos = response.data;
            }
        }, function (err) {
            alert("Erro ao consultar API Cargos");
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
