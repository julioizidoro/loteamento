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
 * Servlet implementation class EditarTerrenoPredial
 */
@WebServlet("/EditarTerrenoServlet")
public class EditarTerrenoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTerrenoServlet() {
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
		Terreno t = dao.findById(Integer.parseInt(request.getParameter("id")));
		
		String terrenoResidencial = "none";
		String terrenoComercial = "none";
		String terrenoPredial = "none";
		
		if (tipoTerreno.equals("terrenopredial")){
			terrenoPredial = "block";
		} else if (tipoTerreno.equals("terrenoresidencial")){
			terrenoResidencial = "block";
		} else {
			terrenoComercial = "block";
		}
		
		StringBuilder html = new StringBuilder();
		html.append(
		"<!DOCTYPE html>" +
		"<html>" +
		"<head>" +
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
			"<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\" />" +
			"<script src=\"http://code.jquery.com/jquery-2.0.3.min.js\"></script>" +
			"<script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>" +
			"<meta charset=\"ISO-8859-1\">" +
		"<title>Cadastro de Pessoas</title>" +
		"</head>" +
		"<body>" +
		"<div style=\"margin: 0 auto; width:350px;\">" +
		"<h2>Editar dados do Terreno</h2>" +		
		"<form name=\"form1\" id=\"form-1\" action=\"AtualizarTerrenoServlet\" method=\"post\">" +
			"<input name=\"id\" id=\"id\" value=\""+ t.getId() + "\" type=\"hidden\"/>" +
			"<input name=\"tipoTerreno\" id=\"tipoTerreno\" value=\""+ tipoTerreno + "\" type=\"hidden\"/>" +
			"<div class=\"ui-field-contain\">" +
				"<label for=\"endereco\">Endereço:</label>" +
				"<input name=\"endereco\" id=\"endereco\" data-clear-btn=\"true\" value=\""+ t.getEndereco() + "\" type=\"text\"/>" +
			"</div>" +
			"<div class=\"ui-field-contain\">" +
				"<label for=\"frente\">Metragem Frente:</label>" +
				"<input name=\"frente\" id=\"frente\" data-clear-btn=\"true\" value=\""+ t.getFrente() + "\" type=\"text\"/>" +
			"</div>" +
			"<div class=\"ui-field-contain\">" +
				"<label for=\"fundo\">Metragem Fundos:</label>" +
				"<input name=\"fundo\" id=\"fundo\" data-clear-btn=\"true\" value=\""+ t.getFundo() + "\" type=\"text\"/>" +
			"</div>" +
			"<div class=\"ui-field-contain\">" +
				"<label for=\"inscricaoImobiliaria\">Inscrição Imobiliária:</label>" +
				"<input name=\"inscricaoImobiliaria\" id=\"inscricaoImobiliaria\" data-clear-btn=\"true\" value=\""+ t.getIncricaoImobiliaria() + "\" type=\"text\"/>" +
			"</div>" +
			"<div id=\"divComercial\" style=\"display:" + terrenoComercial + "\">" +
				"<div class=\"ui-field-contain\">" +
					"<label for=\"numeroLojas\">Número de Lojas:</label>" +
					"<input name=\"numeroLojas\" id=\"numeroLojas\" data-clear-btn=\"true\" value=\"" + ((t.getClass().getSimpleName().equals("TerrenoComercial")) ? ((TerrenoComercial)t).getNumeroLojas() : "") + "\" type=\"text\"/>" +
				"</div>" +
				"<div class=\"ui-field-contain\">" +
					"<label for=\"numeroVagas\">Número de Vagas:</label>" +
					"<input name=\"numeroVagas\" id=\"numeroVagas\" data-clear-btn=\"true\" value=\"" + ((t.getClass().getSimpleName().equals("TerrenoComercial")) ? ((TerrenoComercial)t).getNumeroVagas() : "") + "\" type=\"text\"/>" +
				"</div>" +		
			"</div>" +
			"<div id=\"divPredial\" style=\"display:" + terrenoPredial + "\">" +
				"<div class=\"ui-field-contain\">" +
					"<label for=\"maximoAndares\">Máximo de Andares:</label>" +
					"<input name=\"maximoAndares\" id=\"maximoAndares\" data-clear-btn=\"true\" value=\"" + ((t.getClass().getSimpleName().equals("TerrenoPredial")) ? ((TerrenoPredial)t).getMaximoAndares() : "") + "\" type=\"text\"/>" +
				"</div>" +
				"<div class=\"ui-field-contain\">" +
					"<label for=\"permiteSubsolo\">Permite Subsolo:</label>" +
					"<select name=\"permiteSubsolo\" id=\"permiteSubsolo\" data-clear-btn=\"true\">" +
						"<option value=\"true\" " + (((TerrenoPredial)t).isPermiteSubsolo() ? "selected":"") + ">Sim</option>" +
						"<option value=\"false\" " + (((TerrenoPredial)t).isPermiteSubsolo() ? "":"selected") + ">Não</option>" +
					"</select>" +
				"</div>	" +
			"</div>" +
			"<div id=\"divResidencial\" style=\"display:" + terrenoResidencial + "\">" +
				"<div class=\"ui-field-contain\">" +
					"<label for=\"grauInclinacao\">Grau de Inclinação:</label>" +
					"<input name=\"grauInclinacao\" id=\"grauInclinacao\" data-clear-btn=\"true\" value=\"" + ((t.getClass().getSimpleName().equals("TerrenoResidencial")) ? ((TerrenoResidencial)t).getGrauInclinacao() : "") + "\" type=\"text\"/>" +
				"</div>	" +
			"</div>" +	
			"<div class=\"ui-input-btn ui-btn ui-corner-all ui-btn-b\">" +
				"Enviar" +
				"<input data-enhanced=\"true\" type=\"submit\" value=\"Enviar\" id=\"button-1\"/>" +
			"</div>" +
		"</form>" +
		"</div>" +
		"</body>" +
		"</html>");		
		
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
