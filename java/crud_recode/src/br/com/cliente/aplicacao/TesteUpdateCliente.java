package br.com.cliente.aplicacao;

import java.util.Date;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;

public class TesteUpdateCliente {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
      

        
        //Atualizar o Contato
        
        Cliente c1 = new Cliente();
        c1.setId_cliente(10);// *************************mudar aqui o id do cliente que quer atualizar***************************
        c1.setNomeCompleto("rosangela vieira");
        c1.setEndereco("avenida b");
        c1.setCep("81000");
        c1.setCpf("28888867");
        c1.setE_mail("viera@gmail");
        c1.setSenha("mx34");
        c1.setTelefone("32243567");
        c1.setdataCadastro(new Date ());
     
 
        
        clienteDAO.update(c1); 
        


        // Visualização de todos os registros do banco
        for (Cliente c : clienteDAO.getClientes()) {
            System.out.println("Cliente: " + c.getNomeCompleto());
        }
    }
}
