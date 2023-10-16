package br.com.passagem.aplicacao;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import br.com.crud.dao.PassagemDAO;
import br.com.crud.model.Passagem;

public class TesteCreatePassagem {

    public static void main(String[] args) {
        PassagemDAO passagemDAO = new PassagemDAO();
        Passagem passagem = new Passagem();

        passagem.setDestino("goiania"); //*******colocar  aqui o destino

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

        passagem.setData_de_ida(sdfOutput.format(dataIda));
        passagem.setData_de_volta(sdfOutput.format(dataVolta));

        passagem.setEmpresa("avianca"); //******colocar aqui a empresa
        passagem.setHorario_da_ida("11:00"); //******colocar aqui o horario da ida
        passagem.setHorario_da_volta("11:00"); //******colocar aqui o horario da volta

        passagemDAO.save(passagem);

        // Visualização de todos os registros do banco
        for (Passagem p : passagemDAO.getPassagens()) {
            System.out.println("Passagem criada N°: " + p.getId_passagem() + ", destino: " + p.getDestino() + ", Data de ida: " + p.getData_de_ida()+ ", Data de volta : " + p.getData_de_volta() );
        }
    }
}
