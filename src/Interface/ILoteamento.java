package Interface;

import Exception.Excecao;
import model.Terreno;

public interface ILoteamento {
	
	void incluirTerreno(Terreno terreno) throws Excecao;
	Terreno buscarTerreno(String inscricaoImobiliaria)throws Excecao;
	boolean removerTerreno(Terreno terreno)throws Excecao;

}
