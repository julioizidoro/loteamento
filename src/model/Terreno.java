package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="terreno")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING)
public abstract class Terreno{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="frente")
	private Double frente;
	@Column(name="fundo")
	private Double fundo;
	@Column(name="endereco")
	private String endereco;
	@Column(name="inscricao_imobiliaria")
	private String incricaoImobiliaria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getFrente() {
		return frente;
	}
	public void setFrente(Double frente) {
		this.frente = frente;
	}
	public Double getFundo() {
		return fundo;
	}
	public void setFundo(Double fundo) {
		this.fundo = fundo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getIncricaoImobiliaria() {
		return incricaoImobiliaria;
	}
	public void setIncricaoImobiliaria(String incricaoImobiliaria) {
		this.incricaoImobiliaria = incricaoImobiliaria;
	}
	
	public Double getArea() {
		return getFundo() * getFrente();
	}

}
