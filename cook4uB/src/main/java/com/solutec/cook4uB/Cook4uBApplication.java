package com.solutec.cook4uB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutec.cook4uB.enums.DifficulteRecette;
import com.solutec.cook4uB.enums.NutriScore;
import com.solutec.cook4uB.enums.TypeRecette;
import com.solutec.cook4uB.model.Etape;
import com.solutec.cook4uB.model.Ingredient;
import com.solutec.cook4uB.model.IngredientQuantite;
import com.solutec.cook4uB.model.Recette;
import com.solutec.cook4uB.repository.EtapeRepository;
import com.solutec.cook4uB.repository.IngredientQuantiteRepository;
import com.solutec.cook4uB.repository.IngredientRepository;
import com.solutec.cook4uB.repository.RecetteRepository;

@SpringBootApplication
public class Cook4uBApplication implements CommandLineRunner {
	
	/* Lors du lancement du projet, dans mySQL Workbench passer :
	 * - texteEtape, texteRecette en medium txt
	 * - Modifer les paramètres de la clef étrangère (Etape et IngredientQuantite) afin d'avoir on Delete : Cascade
	 * */
	
	@Autowired
	private RecetteRepository recetteRepo;
	@Autowired
	private EtapeRepository etapeRepo;
	@Autowired
	private IngredientRepository ingredientRepo;
	@Autowired
	private IngredientQuantiteRepository quantiteRepo;

	public static void main(String[] args) {
		SpringApplication.run(Cook4uBApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception{
		System.out.println("Lancement de l'application");
		
		// Ajout de 10 recettes
		
		Recette r1 = new Recette(null,"pate carbonara",8,TypeRecette.Plats,DifficulteRecette.Facile,2,250,"assets/img/pate_carbonara.jpg","Une recette traditionnelle avec beaucoup de variante");
		Recette r2 = new Recette(null,"Hamburger",20,TypeRecette.Plats,DifficulteRecette.Moyenne,4,400,"assets/img/hamburger.png","Une recette de hamburger traditionnelle, à varier selon vos goûts et les saisons !");
		Recette r3 = new Recette(null,"Moussaka",55,TypeRecette.Plats,DifficulteRecette.Facile,4,300,"assets/img/moussaka.png","a moussaka, délicieuse et réconfortante...");
		Recette r4 = new Recette(null,"Salade de concombre",10,TypeRecette.Entrees,DifficulteRecette.Facile,4,250,"assets/img/salade.png","une recette de salade de concombre");
		Recette r5 = new Recette(null,"Steak de poulet r",15,TypeRecette.Plats,DifficulteRecette.Difficile,2,150,"assets/img/steak_poulet.png","Une recette d'un steak de poulet");
		Recette r6 = new Recette(null,"Cookies",40,TypeRecette.Desserts, DifficulteRecette.Facile,4,260,"assets/img/cookies.png","Une recette de cookie extra pépite de chocolat");
		Recette r7 = new Recette(null,"Sauce Tomate",30,TypeRecette.Sauces, DifficulteRecette.Facile,4,150,"assets/img/sauce_tomate.png","Une recette pour faire sa sauce tomate maison très simplement");
		Recette r8 = new Recette(null,"Houmous d'avocat",15,TypeRecette.Aperitifs,DifficulteRecette.Moyenne,4,120,"assets/img/houmous.png","Recette de houmous traditionnelle");
		Recette r9 = new Recette(null,"Café Mocha",5,TypeRecette.Boissons,DifficulteRecette.Facile,1,80,"assets/img/cafe_moka.png","Un petit café Mocha pour vos pauses bien méritées");
		Recette r10 = new Recette(null,"Flan patissier",25,TypeRecette.Desserts,DifficulteRecette.Facile,4,150,"assets/img/flan_vanille.png","Pour réaliser un flan patissier fait maison !");
		
		
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
		Etape e2 = new Etape(null,2,"Ajoutez les pâtes, l’eau, salez.",r1);
		Etape e3 = new Etape(null,3,"Dans un récipient, mélangez la crème fraîche avec l’œuf et le parmesan. Ajoutez cette préparation et laissez reposer 2 minutes puis servez immédiatement.",r1);
		
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
						
		//Ajout d'ingredient dans la base de donnée
		
		Ingredient i1 = new Ingredient(null,"Parmesan",NutriScore.D,"3",402,30,20,0,0,1.6);
		Ingredient i2 = new Ingredient(null,"Tagliatelle",NutriScore.A,"1",364,2,0.5,71.2,3.5,0.005);
		Ingredient i3 = new Ingredient(null,"Lardons fumés",NutriScore.E,"4",250,20,7.8,0.4,0.4,2.3);
		Ingredient i4 = new Ingredient(null,"Oeuf",NutriScore.A,"1",140,9.83,2.64,0.27,0.27,0.31);
		Ingredient i5 = new Ingredient(null,"jaune d'oeuf",NutriScore.D,"1",319,28,8.8,1.1,0.3,0.05);
		Ingredient i6 = new Ingredient(null,"Poivre",NutriScore.NaN,"1",0,0,0,0,0,0);
		Ingredient i7 = new Ingredient(null,"Sel",NutriScore.NaN,"1",0,0,0,0,0,0);
		Ingredient i8 = new Ingredient(null,"Eau Chaude",NutriScore.NaN,"1",0,0,0,0,0,0);
		Ingredient i9 = new Ingredient(null,"Oignon",NutriScore.NaN,"1",43,0,0,0,0,0);
		Ingredient i10 = new Ingredient(null,"Crème entière fluide",NutriScore.D,"4",292,30,21,3.2,3.2,0.08);		
		Ingredient i11 = new Ingredient(null,"steak haché",NutriScore.A,"1",129,5,2.3,0,0,0.23);
		Ingredient i12 = new Ingredient(null,"Cheddar",NutriScore.D,"4",413,35,25,0.5,0.5,1.8);
		Ingredient i13 = new Ingredient(null,"Tomate entiere",NutriScore.A,"3",23,0.5,0.1,3,3,0.1);
		Ingredient i14 = new Ingredient(null,"Pain à burger",NutriScore.A,"4",273,4.7,0.5,46,5.4,1);
		Ingredient i15 = new Ingredient(null,"bacon",NutriScore.D,"4",111,2.6,1,0.8,0.8,2.3);
		Ingredient i16 = new Ingredient(null,"salade verte",NutriScore.A,"1",27,0.5,0.5,2.6,0.6,0.1);
		Ingredient i17 = new Ingredient(null,"cornichon",NutriScore.C,"3",13,0.5,0.1,2,0.7,2);
		Ingredient i18 = new Ingredient(null,"sauce aux choix",NutriScore.NaN,"0",0,0,0,0,0,0);
	
		ingredientRepo.save(i1); 
		ingredientRepo.save(i2); 
		ingredientRepo.save(i3);
		ingredientRepo.save(i4);
		ingredientRepo.save(i5);
		ingredientRepo.save(i6);
		ingredientRepo.save(i7);
		ingredientRepo.save(i8);
		ingredientRepo.save(i9);
		ingredientRepo.save(i10);
		ingredientRepo.save(i11);
		ingredientRepo.save(i12);
		ingredientRepo.save(i13);
		ingredientRepo.save(i14);
		ingredientRepo.save(i15);
		ingredientRepo.save(i16);
		ingredientRepo.save(i17);
		ingredientRepo.save(i18);	
		
		
		//Ajout des quantités d'un ingredient dans une recette 
		
			//recette 1 (pate carbonara) 
			IngredientQuantite q1 = new IngredientQuantite(null,300,"g",r1,i2);
			IngredientQuantite q2 = new IngredientQuantite(null,50,"g",r1,i1);
			IngredientQuantite q3 = new IngredientQuantite(null,140,"g",r1,i3);
			IngredientQuantite q4 = new IngredientQuantite(null,1,"",r1,i5);
			IngredientQuantite q5 = new IngredientQuantite(null,400,"ml",r1,i8);
			IngredientQuantite q6 = new IngredientQuantite(null,1,"",r1,i9);
			IngredientQuantite q7 = new IngredientQuantite(null,1,"pincée",r1,i6);
			IngredientQuantite q8 = new IngredientQuantite(null,20,"cl",r1,i10);
			IngredientQuantite q9 = new IngredientQuantite(null,1,"pincée",r1,i7);		

			quantiteRepo.save(q1);
			quantiteRepo.save(q2);
			quantiteRepo.save(q3);
			quantiteRepo.save(q4);
			quantiteRepo.save(q5);
			quantiteRepo.save(q6);
			quantiteRepo.save(q7);
			quantiteRepo.save(q8);
			quantiteRepo.save(q9);

			
				//recette 3 (hamburger)
			
			IngredientQuantite q10 = new IngredientQuantite(null,4,"",r2,i11);
			IngredientQuantite q11 = new IngredientQuantite(null,4,"",r2,i12);
			IngredientQuantite q12 = new IngredientQuantite(null,1,"",r2,i13);
			IngredientQuantite q13 = new IngredientQuantite(null,4,"",r2,i14);
			IngredientQuantite q14 = new IngredientQuantite(null,8,"",r2,i15);
			IngredientQuantite q15 = new IngredientQuantite(null,3,"",r2,i16);
			IngredientQuantite q16 = new IngredientQuantite(null,1,"",r2,i17);
			IngredientQuantite q17 = new IngredientQuantite(null,1,"",r2,i18);
						
			quantiteRepo.save(q10);
			quantiteRepo.save(q11);
			quantiteRepo.save(q12);
			quantiteRepo.save(q13);
			quantiteRepo.save(q14);
			quantiteRepo.save(q15);
			quantiteRepo.save(q16);
			quantiteRepo.save(q17);
		
	}
}