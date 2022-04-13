package com.solutec.cook4uB.repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.solutec.cook4uB.enums.DifficulteRecette;
import com.solutec.cook4uB.enums.TypeRecette;
import com.solutec.cook4uB.model.Recette;

public interface RecetteRepository extends CrudRepository<Recette, Long> {

	//trouver une recette en fonction de son nom complet
	@Query(value = "SELECT r FROM Recette r WHERE r.nomRecette=?1")
	public Optional<Recette> findNomRecette(String nom);  

	//trouver une recette en fonction de son nom, mais en recherche contient (/LIKE)
	@Query(value = "SELECT r FROM Recette r WHERE r.nomRecette LIKE %?1%")
	public Iterable<Recette> findByNomRecette(String nom);

	//trouver une recette en fonction de son type de recette (dessert/entrée/plat/etc.)
	@Query(value = "SELECT r FROM Recette r WHERE r.type LIKE ?1")
	public Iterable<Recette> findByTypeRecette(TypeRecette type);

	//Recherche en fonction du niveau de difficulté max
		//niveau = Facile
		@Query(value = "SELECT r FROM Recette r WHERE r.difficulte LIKE ?1 ")
		public Iterable<Recette> findByDiffRecetteFacile(DifficulteRecette niveau);
		//niveau = Moyenne	
		@Query(value = "SELECT r FROM Recette r WHERE r.difficulte LIKE ?1 OR r.difficulte LIKE ?2")
		public Iterable<Recette> findByDiffRecetteMoyenne(DifficulteRecette facile, DifficulteRecette niveau);

	//avoir les 9 dernieres recettes
	@Query(value = "SELECT r FROM Recette r ORDER BY r.idRecette DESC")
	public Iterable<Recette> findLastRecette(PageRequest pageRequest);
	
	//Avoir la derniere recette
	@Query(value = "SELECT r FROM Recette r ORDER BY r.idRecette DESC")
	public Optional<Recette> lastRecette(PageRequest pageRequest);

	//recherche avancée par nom - type - calorie max - temps max et difficulté max de la recette
		//tout
			//difficulté facile
			@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.nomRecette LIKE %?2% AND r.calorie<=?3 AND r.temps<=?4 AND r.difficulte =?5")
			public Iterable<Recette> findRecetteAvance0(TypeRecette type, String nom, float cal, int temps,DifficulteRecette diff);
			//diff moyenne
			@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.nomRecette LIKE %?2% AND r.calorie<=?3 AND r.temps<=?4 AND r.difficulte =?5 OR "
					+ "r.type=?1 AND r.nomRecette LIKE %?2% AND r.calorie<=?3 AND r.temps<=?4 AND r.difficulte =?6")
			public Iterable<Recette> findRecetteAvance01(TypeRecette type, String nom, float cal, int temps,DifficulteRecette facile, DifficulteRecette diff);
			
		//nom, type cal temps
		@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.nomRecette LIKE %?2% AND r.calorie<=?3 AND r.temps<=?4")
		public Iterable<Recette> findRecetteAvance1(TypeRecette type, String nom, float cal, int temps);
		
		//nom cal temps diff
			//difficulté facile
			@Query(value = "SELECT r FROM Recette r WHERE r.nomRecette LIKE %?1% AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?4")
			public Iterable<Recette> findRecetteAvance2(String nom, float cal, int temps,DifficulteRecette diff);
			//diff moyenne
			@Query(value = "SELECT r FROM Recette r WHERE r.nomRecette LIKE %?1% AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?4 OR "
					+ "r.nomRecette LIKE %?1% AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?5")
			public Iterable<Recette> findRecetteAvance21(String nom, float cal, int temps,DifficulteRecette diff, DifficulteRecette diff2);
			
		//nom cal temps
		@Query(value = "SELECT r FROM Recette r WHERE r.nomRecette LIKE %?1% AND r.calorie<=?2 AND r.temps<=?3")
		public Iterable<Recette> findRecetteAvance3(String nom, float cal, int temps);
		//type cal temps diff
			//Difficulté facile
			@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?4")
			public Iterable<Recette> findRecetteAvance4(TypeRecette type, float cal, int temps,DifficulteRecette diff);
			//diff moyenne
			@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?4 OR "
					+ "r.type=?1 AND r.calorie<=?2 AND r.temps<=?3 AND r.difficulte =?5")
			public Iterable<Recette> findRecetteAvance41(TypeRecette type, float cal, int temps, DifficulteRecette facile,DifficulteRecette diff);
			
		//type cal temps
		@Query(value = "SELECT r FROM Recette r WHERE r.type=?1 AND r.calorie<=?2 AND r.temps<=?3")
		public Iterable<Recette> findRecetteAvance5(TypeRecette type, float cal, int temps);
		//cal temps diff
			//difficulté facile
			@Query(value = "SELECT r FROM Recette r WHERE r.calorie<=?1 AND r.temps<=?2 AND r.difficulte =?3")
			public Iterable<Recette> findRecetteAvance6(float cal, int temps, DifficulteRecette diff);
			//difficulté moyenne
			@Query(value = "SELECT r FROM Recette r WHERE r.calorie<=?1 AND r.temps<=?2 AND r.difficulte =?3 OR "
					+ "r.calorie<=?1 AND r.temps<=?2 AND r.difficulte =?4")
			public Iterable<Recette> findRecetteAvance61(float cal, int temps, DifficulteRecette facile,DifficulteRecette diff);
			
		//cal temps
		@Query(value = "SELECT r FROM Recette r WHERE r.calorie<=?1 AND r.temps<=?2")
		public Iterable<Recette> findRecetteAvance7(float cal, int temps);

		//calorie maxi
		@Query(value = "SELECT r FROM Recette r WHERE r.temps<=?1")
		public Iterable<Recette> findBytempsTotal(int temps);
		//temps maxi
		@Query(value = "SELECT r FROM Recette r WHERE r.calorie<=?1")
		public Iterable<Recette> findByCalMax(float calMax);

	

	

						
	
	
	
	
		
}
