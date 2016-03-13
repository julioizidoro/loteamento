package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="COMERCIAL")
public class TerrenoComercial extends Terreno{
	
	@Column(name="numero_lojas")
	private int numeroLojas;
	@Column(name="numero_vagas")
	private int numeroVagas;
	
	
	public int getNumeroLojas() {
		return numeroLojas;
	}
	public void setNumeroLojas(int numeroLojas) {
		this.numeroLojas = numeroLojas;
	}
	public int getNumeroVagas() {
		return numeroVagas;
	}
	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	
	

}
