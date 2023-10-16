package br.com.cliente.aplicacao;

import java.util.Date;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;

public class TesteCreateCliente {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();

        cliente.setNomeCompleto("jorge silva ");
        cliente.setEndereco("jardim riviera");
        cliente.setCep("25039434");              //*** cep é unico
        cliente.setCpf("437772911");         //****cpf é unico
        cliente.setE_mail("jorge@gmail.com"); //*** e-mail é unico
        cliente.setSenha("axx3345");
        cliente.setTelefone("139281111");  //*** telefone é unico
        cliente.setdataCadastro(new Date ());

        clienteDAO.save(cliente);   
        
        
        // Visualização de todos os registros do banco
        for (Cliente c : clienteDAO.getClientes()) {
            System.out.println("Cliente: " + c.getNomeCompleto());
        }
    }
}
