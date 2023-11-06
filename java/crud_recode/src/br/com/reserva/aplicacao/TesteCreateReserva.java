package br.com.reserva.aplicacao;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import br.com.crud.dao.ReservaDAO;
import br.com.crud.model.Reserva;

public class TesteCreateReserva {

    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAO();
        Reserva reserva = new Reserva();
        
        reserva.setOrigem("maceio"); //*******colocar  aqui a cidade de origem
        reserva.setDestino("rio de janeiro"); //*******colocar  aqui a cidade de destino

        // Formatar datas
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
        Date dataIda = null;
        Date dataVolta = null;

        try {
            dataIda = sdfInput.parse("09-08-2023");//*******colocar data de ida formato  dd-MM-yyyy
            dataVolta = sdfInput.parse("15-08-2023"); //******colocar data de volta formato  dd-MM-yyyy
        } catch (ParseException e) {
            e.printStackTrace();
        }

        reserva.setData_de_ida(sdfOutput.format(dataIda));
        reserva.setData_de_volta(sdfOutput.format(dataVolta));

        double preco = 3500.00; // Defina o preço como um valor numérico
        reserva.setPreco(preco); // Define o preço na reserva
        
        
        reservaDAO.save(reserva);

        // Visualização de todos os registros do banco
        for (Reserva p : reservaDAO.getReservas()) {
            System.out.println("Reserva criada N°: " + p.getId_reserva() + ", destino: " + p.getDestino() + ", Data de ida: " + p.getData_de_ida() + ", Data de volta: " + p.getData_de_volta() + ", Preço R$ : " + p.getPreco());
        }
    }
}
