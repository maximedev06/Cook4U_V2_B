package com.solutec.cook4uB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.solutec.cook4uB.enums.DifficulteRecette;
import com.solutec.cook4uB.enums.TypeRecette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity

public class Recette {
	
	/* Classe des recettes de cuisine avec leurs paramètres principaux :
	 * 
	 * A ajouter : 
	 *  - tempsTotal - cuisson - préparation - repos ? 
	 *  - Une photo :
	 *        - Lien photo dans un premier temps
	 *        - Save les photos dans la DdDR
	 * 
	 * */
	
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRecette;
	// Nom de la recette de cuisine
	private String nomRecette;
	
	//Temps pour réaliser la recette de cuisine (temps de préparation + temps de cuisson)
	private int temps;
	
	//Le type de la recette 
	private TypeRecette type;
	
	//La difficulté de la recette
	private DifficulteRecette difficulte;
	
	//Nombre de part de la recette
	private int nombrePart;
	
	//Calorie par personnes de la recette
	private float calorie;
	
	//lien photo de la recette, dans un second temps la save en blob dans la base de donnée
	private String photoRecette;
	
	//Présentation de la recette
	private String texteRecette;
	
	
	
	
	//constructor
	
	public Recette(Long idRecette, String nomRecette, int temps, TypeRecette type, DifficulteRecette difficulte,
			int nombrePart, float calorie, String photoRecette, String texteRecette) {
		super();
		this.idRecette = idRecette;
		this.nomRecette = nomRecette;
		this.temps = temps;
		this.type = type;
		this.difficulte = difficulte;
		this.nombrePart = nombrePart;
		this.calorie = calorie;
		this.photoRecette = photoRecette;
		this.texteRecette = texteRecette;
	}
	
	
	
	public Recette() {
		
	}

	//Getters & Setters
	
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

	public DifficulteRecette getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(DifficulteRecette difficulte) {
		this.difficulte = difficulte;
	}

	public int getNombrePart() {
		return nombrePart;
	}

	public void setNombrePart(int nombrePart) {
		this.nombrePart = nombrePart;
	}

	public float getCalorie() {
		return calorie;
	}

	public void setCalorie(float calorie) {
		this.calorie = calorie;
	}

	public String getPhotoRecette() {
		return photoRecette;
	}

	public void setPhotoRecette(String photoRecette) {
		this.photoRecette = photoRecette;
	}

	public String getTexteRecette() {
		return texteRecette;
	}

	public void setTexteRecette(String texteRecette) {
		this.texteRecette = texteRecette;
	}


	
	
	
	
}
