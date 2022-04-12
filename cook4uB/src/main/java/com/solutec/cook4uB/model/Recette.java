package com.solutec.cook4uB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.solutec.cook4uB.enums.TypeRecette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity

public class Recette {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRecette;
	private String nomRecette;
	private int temps;
	private TypeRecette type;
	
	
	public Recette(Long idRecette, String nomRecette, int temps, TypeRecette type) {
		super();
		this.idRecette = idRecette;
		this.nomRecette = nomRecette;
		this.temps = temps;
		this.type = type;
	}
	
	
	public Recette() {
		
	}


	public Long getIdRecette() {
		return idRecette;
	}


	public void setIdRecette(Long idRecette) {
		this.idRecette = idRecette;
	}


	public String getNomRecette() {
		return nomRecette;
	}


	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}


	public int getTemps() {
		return temps;
	}


	public void setTemps(int temps) {
		this.temps = temps;
	}


	public TypeRecette getType() {
		return type;
	}


	public void setType(TypeRecette type) {
		this.type = type;
	}
	
	
	
}
