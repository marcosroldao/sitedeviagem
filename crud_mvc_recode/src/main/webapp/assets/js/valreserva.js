 
function valreserva() {
    // Obtenha os valores dos campos do formulário
    var origem = document.getElementById("Origem").value;
    var destino = document.getElementById("Destino").value;
    var dataIda = document.getElementById("Data_de_ida").value;
    var dataVolta = document.getElementById("Data_de_volta").value;
    var preco = document.getElementById("Preco").value;

    // Verifique se todos os campos estão preenchidos
    if (origem === "" || destino === "" || dataIda === "" || dataVolta === "" || preco === "") {
        alert("Por favor, preencha todos os campos.");
        return false;
    }

    // Verifica o formato das datas (ano-mes-dia)
    if (!validarFormatoData(dataIda) || !validarFormatoData(dataVolta)) {
        alert("Formato de data inválido. Use o formato ano-mes-dia e utilize hifen (exemplo: 2023-12-31).");
        return false;
    }

    if (dataIda > dataVolta) {
        alert("A data de ida não pode ser posterior à data de volta.");
        return false;
    }
 
    return true;
}

// Função para verificar o formato da data (ANO-MÊS-DIA)
function validarFormatoData(data) {
    var regexData = /^\d{4}-\d{2}-\d{2}$/;
    return regexData.test(data);
}
 