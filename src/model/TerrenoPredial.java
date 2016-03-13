package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PREDIAL")
public class TerrenoPredial extends Terreno{
	
	@Column(name="maximo_andares")
	private int maximoAndares;
	@Column(name="permite_subsolo")
	private boolean permiteSubsolo;
	
	public int getMaximoAndares() {
		return maximoAndares;
	}
	public void setMaximoAndares(int maximoAndares) {
		this.maximoAndares = maximoAndares;
	}
	public boolean isPermiteSubsolo() {
		return permiteSubsolo;
	}
	public void setPermiteSubsolo(boolean permiteSubsolo) {
		this.permiteSubsolo = permiteSubsolo;
	}
	
	
	

}
