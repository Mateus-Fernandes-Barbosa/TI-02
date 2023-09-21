/*Sprint_3_cadastro_Samuel*/
/*------------------DECLARAÇÃO DAS VARIAVEIS PARA CADASTRO------------------------------*/

let username = document.querySelector('#nome')
let labelNome = document.querySelector('#labelNome')
let validNome = false

let email = document.querySelector('#Email')
let labelEmail = document.querySelector('#labelEmail')
let validEmail = false

let senha = document.getElementById('senha')
let labelPassword = document.getElementById('labelSenha')
let validPassword = false

let Confirmarsenha = document.getElementById('confirmSenha')
let labelConfirmPassword = document.getElementById('labelConfirmSenha')
let validConfirmPassword = false


let msgError = document.getElementById('msgError')
let msgSuccess = document.getElementById('msgSuccess')


/*----------------REQUISITO PARA VALIDAÇÃO DO NOME-----------------------------------*/
username.addEventListener('keyup',()=>{

    if(username.value.length <= 3){
        labelNome.setAttribute('style','color:red')
        labelNome.innerHTML = 'Nome *Coloque mais de 3 caracteres'
        validNome = false

    } else{
        labelNome.setAttribute('style','color:green')
        labelNome.innerHTML = 'Nome'
        username.setAttribute('style','border-color:green')
        validNome = true
    }
})

/*----------------REQUISITO PARA VALIDAÇÃO DE SENHA----------------------------------*/
senha.addEventListener('keyup',()=>{

    if(senha.value.length <= 5){
        labelPassword.setAttribute('style','color:red')
        labelPassword.innerHTML = 'Senha *Coloque mais de 6 caracteres'
        validPassword = false

    } else{
        labelPassword.setAttribute('style','color:green')
        labelPassword.innerHTML = 'Senha'
        senha.setAttribute('style','border-color:green')
        validPassword = true

    }
})

/*----------------REQUISITO PARA VALIDAÇÃO DE CONFIRMAR SENHA------------------------*/
Confirmarsenha.addEventListener('keyup',()=>{

    if(senha.value == Confirmarsenha.value){
        labelConfirmPassword.setAttribute('style','color:green')
        labelConfirmPassword.innerHTML = 'Confirmar Senha'
        Confirmarsenha.setAttribute('style','border-color:green')
        validConfirmPassword = true

    } else{
        labelConfirmPassword.setAttribute('style','color:red')
        labelConfirmPassword.innerHTML = 'Confirmar Senha *As senhas não se coincidem'
        Confirmarsenha.setAttribute('style','border-color:red')
        validConfirmPassword = false
    }
})

/*----------------MOCK/FAKE USER---------------------------------------------------*/
document.addEventListener("DOMContentLoaded", function() {
    let listaUsuarios = '';
    var db_contaInicial = {
        usuarios: [{
            Nome: 'Julio',
            Email: 'Julio.Santos@gmail.com',
            Senha: '123456'
        }]
    }
    
    var usuario = db_contaInicial.usuarios[0];
    
    listaUsuarios += `<tr><td scope="row">${usuario.Nome}</td><td>${usuario.Email}</td><td>${usuario.Senha}</td></tr>`;
    
    document.getElementById("table-usuarios").innerHTML = listaUsuarios;
});


/*----------------FUNÇÃO PARA CADASTRO DE USUÁRIO-----------------------------------*/
function cadastrar() {
    if (validNome && validPassword && validConfirmPassword) {
        let listaUser = JSON.parse(localStorage.getItem('listaUser') || '[]');
    
        listaUser.push({
            Nome: username.value,
            Email: email.value,
            Senha: senha.value
        });

        localStorage.setItem('listaUser', JSON.stringify(listaUser));

        let listaUsuarios = '';
        listaUser.forEach((user) => {
            listaUsuarios += `<tr><td scope="row">${user.Nome}</td><td>${user.Email}</td><td>${user.Senha}</td></tr>`;
        });

        document.getElementById("table-usuarios").innerHTML = listaUsuarios;

        msgSuccess.setAttribute('style', 'display: block');
        msgSuccess.innerHTML = '<strong>Cadastrado com sucesso</strong>';

        msgError.setAttribute('style', 'display: none');
        msgError.innerHTML = '';

    } else {
        msgError.setAttribute('style', 'display: block');
        msgError.innerHTML = '<strong>Preencha todos os campos corretamente antes de cadastrar</strong>';

        msgSuccess.innerHTML = '';
        msgSuccess.setAttribute('style', 'display: none');
    }
}

/*----------------FUNÇÃO PARA RETIRAR USUÁRIO-------------------------------------*/
function remover() {

    let listaUser = JSON.parse(localStorage.getItem('listaUser') || '[]');

    if (listaUser.length > 0) {

      listaUser.pop();
      localStorage.setItem('listaUser', JSON.stringify(listaUser));

      let listaUsuarios = '';
      listaUser.forEach((user) => {
        listaUsuarios += `<tr><td scope="row">${user.Nome}</td><td>${user.Email}</td><td>${user.Senha}</td></tr>`;
      });

      document.getElementById('table-usuarios').innerHTML = listaUsuarios;
    }
}

document.querySelector('.formularioCadastro').addEventListener('submit', function (event) {
    event.preventDefault();
});
/*--------------------------------------------------------------------------------------------------------------------------------*/