package controller.mvc;

import java.io.IOException;
import java.util.List;

import br.com.crud.dao.PassagemDAO;
import br.com.crud.model.Passagem;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/passagem", "/passagem-create", "/passagem-edit", "/passagem-update",
		"/passagem-delete", })
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassagemDAO pdao = new PassagemDAO();
	Passagem passagem = new Passagem();

	public PassagemServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/passagem":
			read(request, response);
			break;

		case "/passagem-create":
			save(request, response);
			break;

		case "/passagem-edit":
			edit(request, response);
			break;

		case "/passagem-update":
			update(request, response);
			break;

		case "/passagem-delete":
			delete(request, response);

			break;

		default:
			response.sendRedirect("index_passagem.jsp");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passagem> lista = pdao.read();

		request.setAttribute("listaPassagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagem/index_passagem.jsp");
		rd.forward(request, response);
		
		for (Passagem passagem : lista) {
		
		   
		   System.out.println("ID: " + passagem.getId_passagem());
		    System.out.println("Destino: " + passagem.getDestino());
		    System.out.println("Data de Ida: " + passagem.getData_de_ida());
		    System.out.println("Data de Volta: " + passagem.getData_de_volta());
		    System.out.println("Empresa: " + passagem.getEmpresa());
		    System.out.println("Horário de Ida: " + passagem.getHorario_da_ida());
		    System.out.println("Horário de Volta: " + passagem.getHorario_da_volta());
		
		}

	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		passagem.setDestino(request.getParameter("Destino"));
		passagem.setData_de_ida(request.getParameter("Data_de_ida"));
		passagem.setData_de_volta(request.getParameter("Data_de_volta"));
		passagem.setEmpresa(request.getParameter("Empresa"));
		passagem.setHorario_da_ida(request.getParameter("Horario_da_ida"));
		passagem.setHorario_da_volta(request.getParameter("Horario_da_volta"));

		pdao.save(passagem); // Chama o método de salvamento da PassagemDAO
		response.sendRedirect("passagem");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_passagem"));
		passagem = pdao.readById(id);
		request.setAttribute("passagem", passagem);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagem/update_passagem.jsp");
		rd.forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		passagem.setId_passagem(Integer.parseInt(request.getParameter("id_passagem")));
		passagem.setDestino(request.getParameter("destino"));
		passagem.setData_de_ida(request.getParameter("data_de_ida"));
		passagem.setData_de_volta(request.getParameter("data_de_volta"));
		passagem.setEmpresa(request.getParameter("empresa"));
		passagem.setHorario_da_ida(request.getParameter("horario_da_ida"));
		passagem.setHorario_da_volta(request.getParameter("horario_da_volta"));

		pdao.update(passagem); // Chama o método de salvamento da PassagemDAO
		response.sendRedirect("passagem");

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pdao.deleteByID(id);
		response.sendRedirect("passagem");

	}

}
