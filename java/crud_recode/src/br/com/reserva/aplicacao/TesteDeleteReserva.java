package br.com.reserva.aplicacao;

 
import br.com.crud.dao.ReservaDAO;
import br.com.crud.model.Reserva;

public class TesteDeleteReserva {

    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAO();

        int idParaExcluir = 6; //*********** Defina o ID que deseja excluir

        // Armazena o ID antes de excluí-lo
        int idDeletado = idParaExcluir;

        // Certifique-se de que o método deleteByID existe na classe ReservaDAO
        reservaDAO.deleteByID(idParaExcluir);

        // Imprime o ID da reserva que foi deletada
        System.out.println("Reserva deletada com ID: " + idDeletado);

        // Visualização de todos os registros do banco após a exclusão
        for (Reserva c : reservaDAO.getReservas()) {
            System.out.println("Reservas remanescentes ID: " + c.getId_reserva());
        }
    }
}