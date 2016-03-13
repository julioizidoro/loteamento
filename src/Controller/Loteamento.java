package Controller;

import java.util.ArrayList;
import java.util.List;

import Exception.Excecao;
import Interface.ILoteamento;
import model.Terreno;

public class Loteamento implements ILoteamento{
	
	private List<Terreno> listaTerreno;
	
	

	public Loteamento() {
		listaTerreno = new ArrayList<Terreno>();
	}
	@Override
	public void incluirTerreno(Terreno terreno) throws Excecao {
		if (terreno!=null){
			listaTerreno.add(terreno);
		}else throw new Excecao("Terreno inválido");
		
	}
	@Override
	public Terreno buscarTerreno(String inscricaoImobiliaria) throws Excecao {
		if (inscricaoImobiliaria.length()>0){
			for(int i=0;i<listaTerreno.size();i++){
				if (listaTerreno.get(i).getIncricaoImobiliaria().equalsIgnoreCase(inscricaoImobiliaria)){
					return listaTerreno.get(i);
				}
			}
		}else throw new Excecao("Inscrição inválida");
		return null;
	}
	
	@Override
	public boolean removerTerreno(Terreno terreno) throws Excecao {
		if (terreno!=null){
			return listaTerreno.remove(terreno);
		}else {
			throw new Excecao("Inscrição inválida");
		}
	}

	

}
