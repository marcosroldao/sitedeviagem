package controller.mvc;

import java.io.IOException;
import java.util.List;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delete", })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO udao= new ClienteDAO();
	Cliente cliente = new Cliente();
	
	
	public UsuarioServlet() {
 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String action = request.getServletPath();

		switch (action) {
		case "/usuario":
			read(request, response);
			break;
			
		case "/usuario-create":
			save(request, response);
			break;

		case "/usuario-edit":
			edit(request, response);
			break;
			
			
		case "/usuario-update":
			update(request, response);
			break;
			
		case "/usuario-delete":
			delete(request, response);
			 
			break;

			
			
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista = udao.read();
		
		request.setAttribute("listaUsuarios", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/index.jsp");
		rd.forward(request, response);
		 
		
	}
	
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cliente.setNomeCompleto(request.getParameter("NomeCompleto"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setE_mail(request.getParameter("e_mail"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setSenha(request.getParameter("senha"));
        cliente.setdataCadastro(java.sql.Date.valueOf(java.time.LocalDate.now()));

        udao.save(cliente); // Chama o método de salvamento do ClienteDAO
        response.sendRedirect("usuario");
    }
    
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_cliente"));
		cliente= udao.readById(id);
		request.setAttribute("cliente", cliente);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/update.jsp");
		rd.forward(request, response);
		
		
		
	}
    
    
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		cliente.setNomeCompleto(request.getParameter("NomeCompleto"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setE_mail(request.getParameter("e_mail"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setSenha(request.getParameter("senha"));
        cliente.setdataCadastro(java.sql.Date.valueOf(java.time.LocalDate.now()));

        udao.update(cliente); // Chama o método de salvamento do ClienteDAO
        response.sendRedirect("usuario");
		 
	}
    
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		udao.deleteByID(id);
		response.sendRedirect("usuario");
		
	}
	
	
	
	
}



