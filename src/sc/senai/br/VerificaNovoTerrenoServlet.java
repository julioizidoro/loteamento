package sc.senai.br;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirTerrenoServlet
 */
@WebServlet("/VerificaNovoTerrenoServlet")
public class VerificaNovoTerrenoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificaNovoTerrenoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipoTerreno = request.getParameter("tipoTerreno");
		if (tipoTerreno.equalsIgnoreCase("Comercial")){
			response.sendRedirect("CadastrarTerrenoComercial.html");
		} else if (tipoTerreno.equalsIgnoreCase("Predial")) {
			//response.sendRedirect("CadastrarTerrenoPredial.html");
			getServletContext().getRequestDispatcher("/CadastrarTerrenoPredial.html").forward(request, response);
			
		} else if (tipoTerreno.equalsIgnoreCase("Residencial")){
			response.sendRedirect("CadastrarTerrenoResidencial.html");
		} else {
			response.sendRedirect("CadastrarTerreno.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
