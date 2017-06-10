angular.module("hotime").controller("Index", function($scope){
    $scope.gerarQrCode = function() {
    	var funcionario = localStorage.getItem('funcionario');
        var qrcode = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=" + funcionario;
        window.open(qrcode);
    };
});