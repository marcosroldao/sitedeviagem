package br.com.cliente.aplicacao;

 
import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;

public class TesteDeleteCliente {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
       
 
        
        
        clienteDAO.deleteByID(3); //**** colocar aqui o id do contato que quer  deletar *********************
        

        // Visualização de todos os registros do banco
        for (Cliente c : clienteDAO.getClientes()) {
            System.out.println("Cliente: " + c.getNomeCompleto());
        }
    }
}
