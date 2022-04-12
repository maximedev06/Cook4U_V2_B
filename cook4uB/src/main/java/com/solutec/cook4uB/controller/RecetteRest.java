package com.solutec.cook4uB.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.cook4uB.model.Recette;
import com.solutec.cook4uB.repository.RecetteRepository;

@RestController
@CrossOrigin("*")
public class RecetteRest {

	@Autowired
	private RecetteRepository recetteRepo;
	
	//Afficher toutes les recetes
	@GetMapping(value = "/recette")
	public Iterable<Recette> findAllRecette(){
		return recetteRepo.findAll();
	}
	
	//afficher une recette a partir de son id
	@GetMapping(value = "/recette/{id}")
	public Optional<Recette> findRecetteById(@PathVariable Long id){
		return recetteRepo.findById(id);
	}
	
	//Ajouter une recette
	@PostMapping(value = "/recette")
	public Recette ajoutRecette(@RequestBody Recette r) {
		return recetteRepo.save(r);
	}
	
	//Modifier le temps total pour réaliser une recette (temps total = temps de préparation + temps de cuisson)
	@PatchMapping("/recette/{id}/{temps}")
	public Optional<Recette> updateRecetteTemps (@PathVariable Long id,@PathVariable int temps){
		Optional<Recette> e = recetteRepo.findById(id);
		if(temps != (int) temps) {
			return null;
		} else {
			if (e.isPresent()) {
				Recette recette = recetteRepo.findById(id).get();				
				recette.setTemps(temps);
				recetteRepo.save(recette);				
				return recetteRepo.findById(id);
						
			} else {
				return null;
			}
		}
	}
	
	//Modifier une recette en fonction de son id
	@PutMapping(value = "/recette/{id}")
	public Recette modifierRecette(@PathVariable Long id, @RequestBody Recette rDetail) {
		Optional<Recette> e = recetteRepo.findById(id);
		if (e.isPresent()) {
			rDetail.setIdRecette(id);
			return recetteRepo.save(rDetail);
		} else {
			return null;
		}
	}
	
	//Supprimer une recette (ainsi que les étapes liées)
	@DeleteMapping(value = "/recette/{id}")
	public boolean deleteRecette(@PathVariable Long id) {
		Optional<Recette> e = recetteRepo.findById(id);
		if(e.isPresent()) {
			recetteRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
}
