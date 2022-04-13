package com.solutec.cook4uB.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.solutec.cook4uB.model.Etape;

public interface EtapeRepository extends CrudRepository<Etape, Long> {

	//voir toutes les étapes d'une recette
	@Query(value = "SELECT e FROM Etape e WHERE e.recette.idRecette = ?1")
	public Iterable<Etape> findAllEtapeRecette(Long id);

	//Connaitre le nombre d'étape d'une recette
	@Query(value = "SELECT COUNT(e) FROM Etape e WHERE e.recette.idRecette =?1")
	public Iterable<Etape> findNbreEtapeRecette(Long id);

}
