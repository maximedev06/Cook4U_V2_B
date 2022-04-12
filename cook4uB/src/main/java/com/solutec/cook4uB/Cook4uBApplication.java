package com.solutec.cook4uB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutec.cook4uB.enums.TypeRecette;
import com.solutec.cook4uB.model.Etape;
import com.solutec.cook4uB.model.Recette;
import com.solutec.cook4uB.repository.EtapeRepository;
import com.solutec.cook4uB.repository.RecetteRepository;

@SpringBootApplication
public class Cook4uBApplication implements CommandLineRunner {
	
	@Autowired
	private RecetteRepository recetteRepo;
	
	@Autowired
	private EtapeRepository etapeRepo;

	public static void main(String[] args) {
		SpringApplication.run(Cook4uBApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception{
		System.out.println("Lancement de l'application");
		
		// Ajout de recette
		
		Recette r1 = new Recette(null,"pate carbo",8,TypeRecette.Plats);
		Recette r2 = new Recette(null,"cookies",15,TypeRecette.Desserts);
		Recette r3 = new Recette(null,"café",5,TypeRecette.Boissons);
		Recette r4 = new Recette(null,"hamburger",20,TypeRecette.Plats);
		Recette r5 = new Recette(null,"patate sautée",38,TypeRecette.Plats);
		
		recetteRepo.save(r1);
		recetteRepo.save(r2);
		recetteRepo.save(r3);
		recetteRepo.save(r4);
		recetteRepo.save(r5);
		
		
		// Ajout des étapes
		
		Etape e1 = new Etape(null,1,"recette 1 etape 1",r1);
		Etape e2 = new Etape(null,1,"recette 1 etape 2",r1);
		Etape e3 = new Etape(null,1,"recette 1 etape 3",r1);
		Etape e4 = new Etape(null,1,"recette 2 etape 1",r2);
		Etape e5 = new Etape(null,1,"recette 2 etape 2",r2);
		
		etapeRepo.save(e1);
		etapeRepo.save(e2);
		etapeRepo.save(e3);
		etapeRepo.save(e4);
		etapeRepo.save(e5);
		
		
		
		
		
		
	}
}