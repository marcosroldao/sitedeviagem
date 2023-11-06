package controller.mvc;

import java.io.IOException;
import java.util.List;
import br.com.crud.dao.ReservaDAO;
import br.com.crud.model.Reserva;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/reserva", "/reserva-create", "/reserva-edit", "/reserva-update", "/reserva-delete", })
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO rdao= new ReservaDAO();
	Reserva reserva = new Reserva();
	
	
	public ReservaServlet() {
 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String action = request.getServletPath();

		switch (action) {
		case "/reserva":
			read(request, response);
			break;
			
		case "/reserva-create":
			save(request, response);
			break;

		case "/reserva-edit":
			edit(request, response);
			break;
			
			
		case "/reserva-update":
			update(request, response);
			break;
			
		case "/reserva-delete":
			delete(request, response);
			 
			break;

			
			
		default:
			response.sendRedirect("index_reserva.jsp");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reserva> lista = rdao.read();
		
	 
		

	    request.setAttribute("listaReservas", lista);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/index_reserva.jsp");
	    rd.forward(request, response);
	    
	    
	    for (Reserva reserva : lista) {
	        System.out.println("ID: " + reserva.getId_reserva());
	        System.out.println("Origem: " + reserva.getOrigem());
	        System.out.println("Destino: " + reserva.getDestino());
	        System.out.println("Data de Ida: " + reserva.getData_de_ida());
	        System.out.println("Data de Volta: " + reserva.getData_de_volta());
	        System.out.println("Preço: " + reserva.getPreco());
	        System.out.println(); // Adicionar uma linha em branco para separar os itens
	    }
	    
	}
	
		 
		
 
	
	
	
	
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reserva.setOrigem(request.getParameter("Origem"));
        reserva.setDestino(request.getParameter("Destino"));
        reserva.setData_de_ida(request.getParameter("Data_de_ida"));
        reserva.setData_de_volta(request.getParameter("Data_de_volta"));
        double preco = Double.parseDouble(request.getParameter("Preco"));
        reserva.setPreco(preco);
        
       
        rdao.save(reserva); // Chama o método de salvamento do ReservaDAO
        response.sendRedirect("reserva");
    }
    
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_reserva"));
		reserva= rdao.readById(id);
		request.setAttribute("reserva", reserva);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/update_reserva.jsp");
		rd.forward(request, response);
		
		
		
	}
    
    
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		reserva.setId_reserva(Integer.parseInt(request.getParameter("id_reserva")));
        reserva.setOrigem(request.getParameter("origem"));
        reserva.setDestino(request.getParameter("destino"));
        reserva.setDestino(request.getParameter("destino"));
        reserva.setData_de_ida(request.getParameter("data_de_ida"));
        reserva.setData_de_volta(request.getParameter("data_de_volta"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        reserva.setPreco(preco);
    

        rdao.update(reserva); // Chama o método de salvamento do ClienteDAO
        response.sendRedirect("reserva");
		 
	}
    
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		rdao.deleteByID(id);
		response.sendRedirect("reserva");
		
	}
	
	
	
	
}



