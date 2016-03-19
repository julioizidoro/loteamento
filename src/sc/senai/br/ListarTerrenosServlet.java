package sc.senai.br;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TerrenoDAO;
import model.Terreno;

/**
 * Servlet implementation class ListarTerrenos
 */
@WebServlet("/ListarTerrenosServlet")
public class ListarTerrenosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTerrenosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder();
		html.append("<html><head>");
		html.append("<head>");
		html.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		html.append("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\" />");
		html.append("<script src=\"http://code.jquery.com/jquery-2.0.3.min.js\"></script>");
		html.append("<script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>");
		html.append("<title>Lista de Terrenos</title>");
			html.append("<style>");
			html.append("table, th, td {");
			html.append("border: 1px solid black;");
			html.append("border-collapse: collapse;");
			html.append("}");
			html.append("th, td {");
			html.append("padding: 5px;");
			html.append("}");
		html.append("</style>");
		html.append("</head>");
		html.append("<body align=\"center\">");
		html.append("<h2>Listagem de Terrenos</h2>");
		html.append("<input type=\"button\" width=\"100px\" value=\"Incluir\" onClick=\"window.location.href='CadastrarTerreno.html'\">");
		html.append("<table align=\"center\" style=\"width:50%\">");
		html.append("<tr>");
			html.append("<th>Endereco</th>");
			html.append("<th>Area (m2)</th>");
			html.append("<th>Tipo</th>");
			html.append("<th>Acao</th>");
		html.append("</tr>");
		for (Terreno terreno : new TerrenoDAO().findAll()) {
			html.append("<tr>");
				html.append("<td>");
				html.append("<a href='EditarTerrenoServlet?id=" + terreno.getId() + "&tipoTerreno=" + terreno.getClass().getSimpleName() + "'>" + terreno.getEndereco() + "</a>");
				html.append("</td>");
				html.append("<td>" + terreno.getArea() + "</td>");
				html.append("<td>" + terreno.getClass().getSimpleName() + "</td>");
				html.append("<td>");
				html.append("<a href='ExcluirTerrenoServlet?id=" + terreno.getId() + "'>Excluir</a>");
				html.append("</td>");
			html.append("</tr>");
		}
		html.append("</table>");
		html.append("</body>");
		html.append("</html>");
		
		response.getWriter().append(html.toString());	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
