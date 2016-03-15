package sc.senai.br;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TerrenoDAO;
import model.Terreno;
import model.TerrenoComercial;
import model.TerrenoPredial;
import model.TerrenoResidencial;

/**
 * Servlet implementation class CadastrarTerrenoServlet
 */
@WebServlet("/CadastrarTerrenoServlet")
public class CadastrarTerrenoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarTerrenoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TerrenoDAO dao = new TerrenoDAO();
		
		String tipoTerreno =  request.getParameter("tipoTerreno").toLowerCase();
		Terreno terreno;
		
		if (tipoTerreno.equals("predial")){
			terreno = new TerrenoPredial();
			((TerrenoPredial)terreno).setMaximoAndares(Integer.parseInt(request.getParameter("maximoAndares")));
			((TerrenoPredial)terreno).setPermiteSubsolo(Boolean.parseBoolean(request.getParameter("permiteSubsolo")));
		} else if (tipoTerreno.equals("residencial")){
			terreno = new TerrenoResidencial();
			((TerrenoResidencial) terreno).setGrauInclinacao(Integer.parseInt(request.getParameter("grauInclinacao")));
		} else {
			terreno = new TerrenoComercial();
			((TerrenoComercial)terreno).setNumeroLojas(Integer.parseInt(request.getParameter("numeroLojas")));
			((TerrenoComercial)terreno).setNumeroVagas(Integer.parseInt(request.getParameter("numeroVagas")));
		}
		
		terreno.setEndereco(request.getParameter("endereco"));
		terreno.setFrente(Double.parseDouble(request.getParameter("frente")));
		terreno.setFundo(Double.parseDouble(request.getParameter("fundo")));
		terreno.setIncricaoImobiliaria(request.getParameter("inscricaoImobiliaria"));
		
		dao.persist(terreno);
		
		getServletContext().getRequestDispatcher("/ListarTerrenosServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
