angular.module("hotime", []);

function downloadQRCode(){
    var data = "1 John Snow";
    var qrcode = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=" + encodeURIComponent(data);
    window.open(qrcode);
}