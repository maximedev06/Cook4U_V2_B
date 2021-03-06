package com.solutec.cook4uB.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Entity @Data 

public class Etape {
	
	/*Classe étape des recettes avec le numéro de l'étape avec l'instruction associées
	 * 
	 * A rajouter ? : une moyen d'avoir une photo dans l'étape/lien vers une vidéo ? 
	 * */

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEtape;
	
	//numéro de l'étape 
	private int numEtape;
	
	//instruction de l'étape
	private String texteEtape;
	
	@ManyToOne
	@JoinColumn(name="idRecette")
	private Recette recette;

	
	//Constructor complet et vide
	
	public Etape(Long idEtape, int numEtape, String texteEtape, Recette recette) {
		super();
		this.idEtape = idEtape;
		this.numEtape = numEtape;
		this.texteEtape = texteEtape;
		this.recette = recette;
	}
	
	public Etape() {
		
	}
	
	//Getters & Setters 

	public Long getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(Long idEtape) {
		this.idEtape = idEtape;
	}

	public int getNumEtape() {
		return numEtape;
	}

	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	public String getTexteEtape() {
		return texteEtape;
	}

	public void setTexteEtape(String texteEtape) {
		this.texteEtape = texteEtape;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	
	
	
	
}
