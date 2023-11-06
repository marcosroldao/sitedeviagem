 package br.com.reserva.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.crud.dao.ReservaDAO;
import br.com.crud.model.Reserva;

public class TesteUpdateReserva {

    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAO();

        // Atualizar a Reserva
        Reserva reserva = new Reserva();
        reserva.setId_reserva(7); //*******Mudar aqui o ID da reserva que deseja atualizar
        reserva.setOrigem("fortaleza"); //**mudar aqui o destino
        reserva.setDestino("brasilia"); //**mudar aqui o destino
        // Formatar datas no formato interno "dd-MM-yyyy"
        SimpleDateFormat sdfInternal = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfExternal = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Defina as datas no formato interno
            Date dataIda = sdfInternal.parse("07-12-2023"); //******mudar aqui a data de ida
            Date dataVolta = sdfInternal.parse("23-12-2023"); //******mudar aqui a data de volta
            // Converta as datas para o formato externo
            reserva.setData_de_ida(sdfExternal.format(dataIda));
            reserva.setData_de_volta(sdfExternal.format(dataVolta));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double preco = 2800.00; // Defina o preço como um valor numérico
        reserva.setPreco(preco);
        

        reservaDAO.update(reserva);

        // Visualização de todos os registros do banco
        for (Reserva p : reservaDAO.getReservas()) {
            System.out.println("Reservas no banco de dados N°: " + p.getId_reserva() +  ", origem: " + p.getOrigem() + ", destino: " + p.getDestino() + ", Data de ida: " + p.getData_de_ida()+ ", Data de volta : " + p.getData_de_volta() + ", Preço R$ : " + p.getPreco());
        }
    }

    // Função para converter a data do formato interno para externo
    public static String convertDateFormat(String internalDate) {
        SimpleDateFormat sdfInternal = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfExternal = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdfExternal.format(sdfInternal.parse(internalDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return internalDate; // Retorna a data original em caso de erro
        }
    }
}

