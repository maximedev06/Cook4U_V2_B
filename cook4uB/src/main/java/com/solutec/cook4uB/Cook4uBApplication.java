package com.solutec.cook4uB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutec.cook4uB.enums.DifficulteRecette;
import com.solutec.cook4uB.enums.TypeRecette;
import com.solutec.cook4uB.model.Etape;
import com.solutec.cook4uB.model.Recette;
import com.solutec.cook4uB.repository.EtapeRepository;
import com.solutec.cook4uB.repository.RecetteRepository;

@SpringBootApplication
public class Cook4uBApplication implements CommandLineRunner {
	
	/* Lors du lancement du projet, dans mySQL Workbench passer :
	 * - texteEtape, texteRecette en medium txt
	 * - Modifer les paramètres de la clef étrangère (Etape et IngrédientRecette) afin d'avoir on Delete : Cascade
	 * */
	
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
		
		// Ajout de 10 recettes
		
		Recette r1 = new Recette(null,"pate carbonara",8,TypeRecette.Plats,DifficulteRecette.Facile,2,250,"","Une recette traditionnelle avec beaucoup de variante");
		Recette r2 = new Recette(null,"Hamburger",20,TypeRecette.Plats,DifficulteRecette.Facile,4,400,"","Une recette de hamburger traditionnelle, à varier selon vos goûts et les saisons !");
		Recette r3 = new Recette(null,"Moussaka",55,TypeRecette.Plats,DifficulteRecette.Facile,4,300,"","a moussaka, délicieuse et réconfortante...");
		Recette r4 = new Recette(null,"Salade de concombre",10,TypeRecette.Entrees,DifficulteRecette.Facile,4,250,"","une recette de salade de concombre");
		Recette r5 = new Recette(null,"Steak de poulet",15,TypeRecette.Plats,DifficulteRecette.Difficile,2,150,"","Une recette d'un steak de poulet");
		Recette r6 = new Recette(null,"Cookies",40,TypeRecette.Desserts, DifficulteRecette.Facile,4,260,"","Une recette de cookie extra pépite de chocolat");
		Recette r7 = new Recette(null,"Sauce Tomate",30,TypeRecette.Sauces, DifficulteRecette.Facile,4,150,"","Une recette pour faire sa sauce tomate maison très simplement");
		Recette r8 = new Recette(null,"Houmous d'avocat",15,TypeRecette.Aperitifs,DifficulteRecette.Moyenne,4,120,"","Recette de houmous traditionnelle");
		Recette r9 = new Recette(null,"Café Mocha",5,TypeRecette.Boissons,DifficulteRecette.Facile,1,80,"","Un petit café Mocha pour vos pauses bien méritées");
		Recette r10 = new Recette(null,"Flan patissier",25,TypeRecette.Desserts,DifficulteRecette.Facile,4,150,"","Pour réaliser un flan patissier fait maison !");
		
		
		recetteRepo.save(r1);
		recetteRepo.save(r2);
		recetteRepo.save(r3);
		recetteRepo.save(r4);
		recetteRepo.save(r5);
		recetteRepo.save(r6);
		recetteRepo.save(r7);
		recetteRepo.save(r8);
		recetteRepo.save(r9);
		recetteRepo.save(r10);
			
		
		
		// Ajout des étapes 
			
			//Pour la première recette : pate carbonara
		
		Etape e1 = new Etape(null,1,"Épluchez et émincez l’oignon. Mettez les lardons, l’oignon, puis démarrez le mode dorer. Laissez revenir pendant 2 minutes en remuant de temps en temps.",r1);
		Etape e2 = new Etape(null,2,"Ajoutez les pâtes, l’eau, salez.",r2);
		Etape e3 = new Etape(null,3,"Dans un récipient, mélangez la crème fraîche avec l’œuf et le parmesan. Ajoutez cette préparation et laissez reposer 2 minutes puis servez immédiatement.",r3);
		
		etapeRepo.save(e1);
		etapeRepo.save(e2);
		etapeRepo.save(e3);
		
		
			//Pour la seconde recette : Hamburger
		Etape e4 = new Etape(null,1,"Préchauffez votre four à th.6 (180°C).",r2);
		Etape e5 = new Etape(null,2,"Dans une poêle chaude, faites cuire les steaks hachés et les tranches de bacon 2 min sur chaque face.",r2);
		Etape e6 = new Etape(null,3,"Coupez vos pains à hamburger en deux.",r2);
		Etape e7 = new Etape(null,4,"Sur la partie supérieure de vos pains à hamburger, déposez une tranche de cheddar puis passez le tout 2 min dans votre four en position grill.",r2);
		Etape e8 = new Etape(null,5,"Pendant ce temps, lavez et essorez les feuilles de salade. Lavez et coupez la tomate en fines rondelles. Coupez également le cornichon en fines rondelles.",r2);
		Etape e9 = new Etape(null,6,"Tartinez la partie inférieure de vos pains à hamburger de la sauce de votre choix.",r2);
		Etape e10 = new Etape(null,7,"Déposez ensuite 1 ou 2 feuilles de salade verte, 1 ou 2 rondelles de tomates, 1 ou 2 rondelles de cornichons, 2 tranches de bacon, un steak haché.",r2);
		Etape e11 = new Etape(null,8,"Fermez ensuite votre hamburger avec le chapeau de votre pain avec le cheddar.",r2);
		Etape e12 = new Etape(null,9,"Renouvelez l’opération pour tous les hamburgers.",r2);
		Etape e13 = new Etape(null,10,"Servez aussitôt et dégustez vos hamburgers maison bien chauds.",r2);
		
		etapeRepo.save(e4);
		etapeRepo.save(e5);
		etapeRepo.save(e6);
		etapeRepo.save(e7);
		etapeRepo.save(e8);
		etapeRepo.save(e9);
		etapeRepo.save(e10);
		etapeRepo.save(e11);
		etapeRepo.save(e12);
		etapeRepo.save(e13);
						
		
		
		
		
		
	}
}