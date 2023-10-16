package br.com.passagem.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.crud.dao.PassagemDAO;
import br.com.crud.model.Passagem;

public class TesteUpdatePassagem {

    public static void main(String[] args) {
        PassagemDAO passagemDAO = new PassagemDAO();

        // Atualizar a Passagem
        Passagem passagem = new Passagem();
        passagem.setId_passagem(6); //*******Mudar aqui o ID da passagem que deseja atualizar
        passagem.setDestino("libano"); //**mudar aqui o destino
        // Formatar datas no formato interno "dd-MM-yyyy"
        SimpleDateFormat sdfInternal = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfExternal = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Defina as datas no formato interno
            Date dataIda = sdfInternal.parse("07-12-2023"); //******mudar aqui a data de ida
            Date dataVolta = sdfInternal.parse("23-12-2023"); //******mudar aqui a data de volta
            // Converta as datas para o formato externo
            passagem.setData_de_ida(sdfExternal.format(dataIda));
            passagem.setData_de_volta(sdfExternal.format(dataVolta));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        passagem.setEmpresa("la tam"); //******mudar aqui empresa
        passagem.setHorario_da_ida("01:00"); //******mudar aqui  a data de ida
        passagem.setHorario_da_volta("04:00"); //******mudar aqui  a data de volta

        passagemDAO.update(passagem);

        // Visualização de todos os registros do banco
        for (Passagem p : passagemDAO.getPassagens()) {
            System.out.println("Passagens no vanco de dados N°: " + p.getId_passagem() + ", destino: " + p.getDestino() + ", Data de ida: " + p.getData_de_ida()+ ", Data de volta : " + p.getData_de_volta() );
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
