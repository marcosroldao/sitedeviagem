<script>
    window.onload = function () {
        const dataIda = document.getElementById('dataIda');
        const dataVolta = document.getElementById('dataVolta');

        const dataAtual = new Date();
        const dia = dataAtual.getDate().toString().padStart(2, '0');
        const mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0');
        const ano = dataAtual.getFullYear();

        dataIda.value = `${dia}/${mes}/${ano}`;
        dataVolta.value = `${dia}/${mes}/${ano}`;
    };
</script>
