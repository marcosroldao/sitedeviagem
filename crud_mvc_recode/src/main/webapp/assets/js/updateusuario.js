function updateusuario() {
    // Obtenha os valores dos campos do formulário
    var nome = document.getElementById("NomeCompleto").value;
    var endereco = document.getElementById("endereco").value;
    var cep = document.getElementById("cep").value;
    var cpf = document.getElementById("cpf").value;
    var telefone = document.getElementById("telefone").value;
    var senha = document.getElementById("senha").value;
    var email = document.getElementById("e_mail").value;

    // Verifique se nenhum campo obrigatório está em branco
    if (nome === "" || endereco === "" || senha === "" || email === "") {
        alert("Por favor, preencha todos os campos obrigatorios.");
        return false;
    }


   // Verifique se o campo "Endereço" não está em branco e não contém apenas números
    if (endereco.trim() === "" || /^[0-9]+$/.test(endereco)) {
        alert("O campo 'Endereco' e obrigatorio, prencha completamente");
        return false;
    }


    // Verifique o formato do CEP (apenas números e no máximo 9 dígitos)
    var regexCEP = /^\d{1,9}$/;
    if (cep !== "" && !regexCEP.test(cep)) {
        alert("CEP invalido. Deve conter apenas numeros e no maximo 9 digitos.");
        return false;
    }

    // Verifique o formato do CPF (apenas números e no máximo 11 dígitos)
    var regexCPF = /^\d{1,11}$/;
    if (cpf !== "" && !regexCPF.test(cpf)) {
        alert("CPF invalido. Deve conter apenas numeros e no maximo 11 digitos.");
        return false;
    }

    // Verifique o formato do telefone (apenas números e no máximo 11 dígitos)
    var regexTelefone = /^\d{1,11}$/;
    if (telefone !== "" && !regexTelefone.test(telefone)) {
        alert("Telefone invalido. Deve conter apenas numeros e no maximo 11 digitos.");
        return false;
    }

    // Verifique o formato da senha (no máximo 8 dígitos)
    if (senha.length > 8) {
        alert("A senha deve ter no maximo 8 digitos.");
        return false;
    }

    // Verifique o formato do email (formato de email válido)
    var regexEmail = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
    if (!regexEmail.test(email)) {
        alert("Formato de email invalido. Exemplo de formato valido: exemplo@email.com");
        return false;
    }

    return true;
}
