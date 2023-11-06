function validar() {
    var nome = document.getElementById("NomeCompleto").value;
    var endereco = document.getElementById("endereco").value;
    var cep = document.getElementById("cep").value;
    var cpf = document.getElementById("cpf").value;
    var email = document.getElementById("e_mail").value;
    var senha = document.getElementById("senha").value;
    var telefone = document.getElementById("telefone").value;

    // Validação de CEP
    if (!/^\d{4,9}$/.test(cep)) {
        alert("CEP inválido. O CEP deve conter de 4 a 9 dígitos numéricos.");
        return false;
    }

    // Validação de CPF
    if (!/^\d{4,11}$/.test(cpf)) {
        alert("CPF inválido. O CPF deve conter de 4 a 11 dígitos numéricos.");
        return false;
    }

    // Validação de e-mail
    if (!/\S+@\S+\.\S+/.test(email)) {
        alert("E-mail inválido. O e-mail deve estar no formato correto (exemplo@dominio.com).");
        return false;
    }

    // Validação de e-mail duplicado (você deve implementar a lógica de consulta ao banco de dados)
    if (emailJaExisteNoBanco(email)) {
        alert("E-mail já cadastrado. Use um e-mail diferente.");
        return false;
    }

    // Validação de senha
    if (senha.length > 8) {
        alert("Senha inválida. A senha deve conter no máximo 8 caracteres.");
        return false;
    }

    // Validação de número de telefone
    if (!/^\d{1,15}$/.test(telefone)) {
        alert("Número de telefone inválido. O número deve conter até 15 dígitos numéricos.");
        return false;
    }

    // Implemente outras validações, se necessário

    return true;
}

function emailJaExisteNoBanco(email) {
    // Aqui, você deve implementar a lógica para verificar se o e-mail já existe no banco de dados.
    // Se o e-mail existir, retorne true; caso contrário, retorne false.
    // Esta função simula a lógica; você deve adaptá-la para seu ambiente e tecnologias de banco de dados.
    var emailsCadastrados = ["email1@example.com", "email2@example.com"]; // Substitua por sua lista de e-mails cadastrados
    return emailsCadastrados.includes(email);
}
