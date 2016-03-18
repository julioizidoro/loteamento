package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="RESIDENCIAL")
public class TerrenoResidencial extends Terreno{
	
	@Column(name="grauInclinacao")
	private int grauInclinacao;

	public int getGrauInclinacao() {
		return grauInclinacao;
	}

	public void setGrauInclinacao(int grauInclinacao) {
		this.grauInclinacao = grauInclinacao;
	}
	
	

}
