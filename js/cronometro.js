const promoEndDate = new Date();
promoEndDate.setDate(promoEndDate.getDate() + 2); // Adiciona 2 dias à data atual

function updateCountdown() {
    const currentDate = new Date();
    const timeRemaining = promoEndDate - currentDate;

    if (timeRemaining <= 0) {
        document.getElementById('cronometro').innerHTML = 'Promoção encerrada!';
        return; // Não é necessário continuar a atualização se a promoção já tiver encerrado
    }

    const days = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
    const hours = Math.floor((timeRemaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((timeRemaining % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((timeRemaining % (1000 * 60)) / 1000);

    document.getElementById('cronometro').innerHTML = `${days}d ${hours}h ${minutes}m ${seconds}s`;
}

setInterval(updateCountdown, 1000);
updateCountdown(); // Atualizar o cronômetro imediatamente
