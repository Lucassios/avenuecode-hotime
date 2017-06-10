var funcionarioString = localStorage.getItem('funcionario');
if (funcionarioString != undefined) {
    var funcionario = JSON.parse(funcionarioString);
    if (funcionario == undefined || funcionario.email == undefined) {
        window.location = "http://localhost:8080/index.html";
    }
}