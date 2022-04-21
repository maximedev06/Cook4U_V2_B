package com.solutec.cook4uB.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.cook4uB.enums.DifficulteRecette;
import com.solutec.cook4uB.enums.TypeRecette;
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
	
	//Savoir si le nom de la recette est disponible
	@GetMapping(value = "/recette/dispo/{nom}")
	public boolean nomRecetteDispo(@PathVariable String nom) {
		Optional<Recette> r = recetteRepo.findNomRecette(nom);
		if(r.isPresent()) {
			return false;
		} else {
			return true;
		}
	}
			
	//Avoir les 9 dernières recettes
	@GetMapping(value = "/recette/last")
	public Iterable<Recette> findLastRecette(){
		return recetteRepo.findLastRecette(PageRequest.of(0,9));
	}
	
	//avoir la last recette
	@GetMapping(value = "recette/last1")
	public Optional<Recette> lastRecette(){
		return recetteRepo.lastRecette((PageRequest.of(0,1)));
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
	
	//recherche avancée par nom - type - calorie max - temps max et difficulté max de la recette
	
		// nom type cal max temps max difficulté
		@GetMapping(value = "/recette/avance/{type}/{nom}/{cal}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance(@PathVariable TypeRecette type,@PathVariable String nom, @PathVariable float cal,@PathVariable int temps,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance0(type,nom,cal,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance01(type,nom,cal,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance1(type,nom,cal,temps);
			}
		} 
			
		///nom type cal temps
		@GetMapping(value = "recette/avance1/{type}/{nom}/{cal}/{temps}")
		public Iterable<Recette> findRecetteAvance1 (@PathVariable TypeRecette type,@PathVariable String nom, @PathVariable float cal,@PathVariable int temps){
	
			return recetteRepo.findRecetteAvance1(type,nom,cal,temps);
		} 
		
		//nom cal temps diff
		@GetMapping(value = "/recette/avance2/{nom}/{cal}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance2(@PathVariable String nom, @PathVariable float cal,@PathVariable int temps,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance2(nom,cal,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance21(nom,cal,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance3(nom,cal,temps);
			}
		} 
			
		//nom cal temps
		@GetMapping(value = "recette/avance3/{nom}/{cal}/{temps}")
		public Iterable<Recette> findRecetteAvance3 (@PathVariable String nom, @PathVariable float cal,@PathVariable int temps){
			return recetteRepo.findRecetteAvance3(nom,cal,temps);
		} 
		
		//type cal temps diff
		@GetMapping(value = "recette/avance4/{type}/{cal}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance4(@PathVariable TypeRecette type, @PathVariable float cal,@PathVariable int temps,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance4(type,cal,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance41(type,cal,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance5(type,cal,temps);
			}
			
		} 
		
		//type cal temps 
		@GetMapping(value = "recette/avance5/{type}/{cal}/{temps}")
		public Iterable<Recette> findRecetteAvance5(@PathVariable TypeRecette type, @PathVariable float cal,@PathVariable int temps){
			return recetteRepo.findRecetteAvance5(type,cal,temps);
		} 
		
		//cal temps diff
		@GetMapping(value = "recette/avance6/{cal}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance6(@PathVariable float cal, @PathVariable int temps,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance6(cal,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance61(cal,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance7(cal,temps);
			}
			
		} 
		
		//cal temps
		@GetMapping(value = "recette/avance7/{cal}/{temps}")
		public Iterable<Recette> findRecetteAvance7(@PathVariable float cal, @PathVariable int temps){
			return recetteRepo.findRecetteAvance7(cal,temps);
		}
		
		//diff temps
		@GetMapping(value = "recette/avance8/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance8(@PathVariable DifficulteRecette diff, @PathVariable int temps){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance8(temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance81(temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findBytempsTotal(temps);
			}
		}
		
		//type cal
		@GetMapping(value = "recette/avance9/{type}/{cal}")
		public Iterable<Recette> findRecetteAvance9(@PathVariable TypeRecette type, @PathVariable float cal){
			return recetteRepo.findRecetteAvance9(type,cal);
		}
		
		//type temps
		@GetMapping(value = "recette/avance10/{type}/{temps}")
		public Iterable<Recette> findRecetteAvance10(@PathVariable TypeRecette type, @PathVariable int temps){
			return recetteRepo.findRecetteAvance10(type,temps);
		}
		
		//type diff
		@GetMapping(value = "recette/avance11/{type}/{diff}")
		public Iterable<Recette> findRecetteAvance11(@PathVariable TypeRecette type,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance11(type,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance111(type,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findByTypeRecette(type);
			}
		}
		
		// type cal diff
		@GetMapping(value = "recette/avance12/{type}/{cal}/{diff}")
		public Iterable<Recette> findRecetteAvance12(@PathVariable TypeRecette type,@PathVariable float cal ,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance12(type,cal,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance121(type,cal,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance9(type,cal);
			}
		}
		
		
		//type temps diff
		@GetMapping(value = "recette/avance13/{type}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance13(@PathVariable TypeRecette type,@PathVariable int temps ,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance13(type,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance131(type,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance10(type,temps);
			}
		}
		
		
		//nom cal
		@GetMapping(value = "recette/avance14/{nom}/{cal}")
		public Iterable<Recette> findRecetteAvance14(@PathVariable String nom, @PathVariable float cal){
			return recetteRepo.findRecetteAvance14(nom,cal);
		}
		
		//nom temps
		@GetMapping(value = "recette/avance15/{nom}/{temps}")
		public Iterable<Recette> findRecetteAvance15(@PathVariable String nom, @PathVariable int temps){
			return recetteRepo.findRecetteAvance15(nom,temps);
		}
		
		//nom diff
		@GetMapping(value = "recette/avance16/{nom}/{diff}")
		public Iterable<Recette> findRecetteAvance16(@PathVariable String nom,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance16(nom,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance161(nom,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findByNomRecette(nom);
			}
		}
		
		//nom diff cal
		@GetMapping(value = "recette/avance17/{nom}/{cal}/{diff}")
		public Iterable<Recette> findRecetteAvance17(@PathVariable String nom,@PathVariable float cal,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance17(nom,cal,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance171(nom,cal,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance14(nom,cal);
			}
		}
		
		//nom diff temps
		@GetMapping(value = "recette/avance18/{nom}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance18(@PathVariable String nom,@PathVariable int temps,@PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance18(nom,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance181(nom,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance15(nom,temps);
			}
		}
		
		//nom type
		@GetMapping(value = "recette/avance19/{nom}/{type}")
		public Iterable<Recette> findRecetteAvance19(@PathVariable String nom,@PathVariable TypeRecette type){
			return recetteRepo.findRecetteAvance19(nom,type);
		}
		
		///nom type cal
		@GetMapping(value = "recette/avance20/{nom}/{type}/{cal}")
		public Iterable<Recette> findRecetteAvance20 (@PathVariable TypeRecette type,@PathVariable String nom, @PathVariable float cal){
	
			return recetteRepo.findRecetteAvance20(nom,type,cal);
		} 
		
		///nom type temps
		@GetMapping(value = "recette/avance21/{nom}/{type}/{temps}")
		public Iterable<Recette> findRecetteAvance21 (@PathVariable TypeRecette type,@PathVariable String nom, @PathVariable int temps){
			return recetteRepo.findRecetteAvance21(nom,type,temps);
		} 
		
		//nom type diff
		@GetMapping(value = "recette/avance22/{nom}/{type}/{diff}")
		public Iterable<Recette> findRecetteAvance22 (@PathVariable TypeRecette type,@PathVariable String nom, @PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance22(nom,type,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance221(nom,type,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance19(nom,type);
			}	
		}
		
		//nom type diff cal
		@GetMapping(value = "recette/avance23/{nom}/{type}/{cal}/{diff}")
		public Iterable<Recette> findRecetteAvance23 (@PathVariable TypeRecette type,@PathVariable String nom,@PathVariable float cal, @PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance23(nom,type,cal,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance231(nom,type,cal,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance20(nom,type,cal);
			}	
		}
		
		//nom type diff temps
		@GetMapping(value = "recette/avance24/{nom}/{type}/{temps}/{diff}")
		public Iterable<Recette> findRecetteAvance24 (@PathVariable TypeRecette type,@PathVariable String nom,@PathVariable int temps, @PathVariable DifficulteRecette diff){
			if(diff == DifficulteRecette.Facile) {
				return recetteRepo.findRecetteAvance24(nom,type,temps,diff);
			} else if(diff == DifficulteRecette.Moyenne){
				return recetteRepo.findRecetteAvance241(nom,type,temps,DifficulteRecette.Facile,diff);
			} else {
				return recetteRepo.findRecetteAvance21(nom,type,temps);
			}	
		}
		
		
		
		//Recherche en fonction de son nom (contient)
		@GetMapping(value = "/recette/nom/{nom}")
		public Iterable<Recette> findRecetteByNom (@PathVariable String nom){
			return recetteRepo.findByNomRecette(nom);
		}  
		
		//Recherche en fonction de son type de recette (entrée/plats/etc.)
		@GetMapping(value = "/recette/type/{type}")
		public Iterable<Recette> findRecetteByType (@PathVariable TypeRecette type){
			return recetteRepo.findByTypeRecette(type);
		} 
		
		//Recherche en fonction du niveau de difficulté max
		@GetMapping(value = "/recette/difficulte/{niveau}")
		public Iterable<Recette> findRecetteByDifficulte(@PathVariable DifficulteRecette niveau){
			if(niveau == DifficulteRecette.Facile) {
				return recetteRepo.findByDiffRecetteFacile(niveau);
			} else if(niveau == DifficulteRecette.Moyenne){
				return recetteRepo.findByDiffRecetteMoyenne(DifficulteRecette.Facile,niveau);
			} else {
				return recetteRepo.findAll();
			}
		}
		
		// Avoir une recette en fonction de ses Cal Max/part
		@GetMapping(value = "/recette/calMax/{calMax}")
		public Iterable<Recette> findRecetteByCalMax(@PathVariable float calMax){
			return recetteRepo.findByCalMax(calMax);
		}
		
		// Avoir une recette en fonction du temps total 
		@GetMapping(value = "/recette/temps/{temps}")
		public Iterable<Recette> findRecetteByTempsTotal(@PathVariable int temps){
			return recetteRepo.findBytempsTotal(temps);
		}
	
			
	
	
	
	
}
