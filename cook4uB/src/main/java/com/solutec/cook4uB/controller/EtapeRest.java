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

import com.solutec.cook4uB.model.Etape;
import com.solutec.cook4uB.repository.EtapeRepository;


@RestController
@CrossOrigin("*")
public class EtapeRest {

	@Autowired
	private EtapeRepository etapeRepo;
	
	@GetMapping(value = "/etape")
	public Iterable<Etape> findAllEtape(){
		return etapeRepo.findAll();
	}
	
	@GetMapping(value = "/etape/{id}")
	public Optional<Etape> findEtapeById(@PathVariable Long id){
		return etapeRepo.findById(id);
	}
	
	@PostMapping(value = "/etape")
	public Etape addEtape(@RequestBody Etape e) {
		return etapeRepo.save(e);
	}
	
	@PutMapping(value = "/etape/{id}")
	public Etape modifierEtape(@PathVariable Long id, @RequestBody Etape e) {
		Optional<Etape> r = etapeRepo.findById(id);
		if(r.isPresent()) {
			e.setIdEtape(id);
			return etapeRepo.save(e);
		} else {
			return null;
		}
	}
	
	@PatchMapping(value = "/etape/txt/{id}/{txt}")
	public Optional<Etape> updateTexteEtape(@PathVariable Long id, @PathVariable String txt){
		Optional<Etape> e = etapeRepo.findById(id);
		if (e.isPresent() && txt.length() > 5) {
			Etape etape = etapeRepo.findById(id).get();
			etape.setTexteEtape(txt);
			etapeRepo.save(etape);
			return etapeRepo.findById(id);
			
		} else {
			return null;
		}
	}
	
	@PatchMapping(value = "/etape/num/{id}/{num}")
	public Optional<Etape> updateTexteEtape(@PathVariable Long id, @PathVariable int num){
		Optional<Etape> e = etapeRepo.findById(id);
		if (e.isPresent() && num > 0) {
			Etape etape = etapeRepo.findById(id).get();
			etape.setNumEtape(num);
			etapeRepo.save(etape);
			return etapeRepo.findById(id);
			
		} else {
			return null;
		}
	}
	
	@DeleteMapping(value = "/etape/{id}")
	public boolean deleteEtape(@PathVariable Long id) {
		Optional<Etape> e = etapeRepo.findById(id);
		if(e.isPresent()) {
			etapeRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}




}
