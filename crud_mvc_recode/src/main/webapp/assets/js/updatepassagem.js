function validarpassagem() {
    // Obtenha os valores dos campos do formulário
    var destino = document.getElementById("Destino").value;
    var dataIda = document.getElementById("Data_de_ida").value;
    var dataVolta = document.getElementById("Data_de_volta").value;
    var empresa = document.getElementById("Empresa").value;
    var horarioIda = document.getElementById("Horario_da_ida").value;
    var horarioVolta = document.getElementById("Horario_da_volta").value;

    // Verifique se todos os campos estão preenchidos
    if (destino === "" || dataIda === "" || dataVolta === "" || empresa === "" || horarioIda === "" || horarioVolta === "") {
        alert("Por favor, preencha todos os campos.");
        return false;
    }

    // Verifica o formato das datas (ano-mes-dia com hífen ou barra)
    if (!validarFormatoData(dataIda) || !validarFormatoData(dataVolta)) {
        alert("Formato de data inválido. Use o formato ano-mes-dia (exemplo: 2023-12-31).");
        return false;
    }

    // Verifica o formato das horas (HH:mm)
    if (!validarFormatoHora(horarioIda) || !validarFormatoHora(horarioVolta)) {
        alert("Formato de hora inválido. Use o formato HH:mm (exemplo: 09:30).");
        return false;
    }

    // Verifica se a data de ida não é posterior à data de volta
    if (new Date(dataIda) > new Date(dataVolta)) {
        alert("A data de ida não pode ser posterior à data de volta.");
        return false;
    }

    return true;
}

// Função para verificar o formato da data (ANO-MÊS-DIA com hífen ou barra)
function validarFormatoData(data) {
    var regexData = /^\d{4}[-/]\d{2}[-/]\d{2}$/;
    return regexData.test(data);
}

// Função para verificar o formato da hora (HH:mm)
function validarFormatoHora(hora) {
    var regexHora = /^([01]\d|2[0-3]):([0-5]\d)$/;
    return regexHora.test(hora);
}