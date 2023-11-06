  function updatereserva() {
        var origem = document.getElementById("origem").value;
        var destino = document.getElementById("destino").value;
        var dataDeIda = document.getElementById("data-de-ida").value;
        var dataDeVolta = document.getElementById("data_de_volta").value;
        var preco = document.getElementById("preco").value;

        // Verifique se nenhum campo obrigatório está em branco
        if (origem === "" || destino === "" || dataDeIda === "" || dataDeVolta === "" || preco === "") {
            alert("Por favor, preencha todos os campos obrigatórios.");
            return false;
        }

        // Verifique o formato das datas (você pode ajustar o formato conforme necessário)
        var dateRegex = /^\d{4}-\d{2}-\d{2}$/;
        if (!dateRegex.test(dataDeIda) || !dateRegex.test(dataDeVolta)) {
            alert("Formato de data inválido. Use o formato yyyy-mm-dd.");
            return false;
        }

        // Verifique se o preço é um número válido
        if (isNaN(preco)) {
            alert("Preço deve ser um número válido.");
            return false;
        }

        // Outras validações específicas podem ser adicionadas aqui

        return true;
    }