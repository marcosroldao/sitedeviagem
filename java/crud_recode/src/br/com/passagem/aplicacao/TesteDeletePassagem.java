package br.com.passagem.aplicacao;

 
import br.com.crud.dao.PassagemDAO;
import br.com.crud.model.Passagem;

public class TesteDeletePassagem {

    public static void main(String[] args) {
        PassagemDAO passagemDAO = new PassagemDAO();

        int idParaExcluir = 6; //*********** Defina o ID que deseja excluir

        // Armazena o ID antes de excluí-lo
        int idDeletado = idParaExcluir;

        // Certifique-se de que o método deleteByID existe na classe PassagemDAO
        passagemDAO.deleteByID(idParaExcluir);

        // Imprime o ID da passagem que foi deletada
        System.out.println("Passagem deletada com ID: " + idDeletado);

        // Visualização de todos os registros do banco após a exclusão
        for (Passagem c : passagemDAO.getPassagens()) {
            System.out.println("Passagens remanescentes ID: " + c.getId_passagem());
        }
    }
}