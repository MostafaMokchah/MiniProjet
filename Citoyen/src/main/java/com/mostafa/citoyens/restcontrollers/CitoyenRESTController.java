package com.mostafa.citoyens.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mostafa.citoyens.entities.Citoyen;
import com.mostafa.citoyens.service.CitoyenService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CitoyenRESTController {
	
	@Autowired
	CitoyenService produitService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Citoyen> getAllCitoyens()
	{
		return produitService.getAllCitoyens();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Citoyen getCitoyenById(@PathVariable("id") Long id) {
		return produitService.getCitoyen(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Citoyen createCitoyen(@RequestBody Citoyen produit) {
			return produitService.saveCitoyen(produit);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Citoyen updateCitoyen(@RequestBody Citoyen produit) {
		return produitService.updateCitoyen(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCitoyen(@PathVariable("id") Long id)
	{
			produitService.deleteCitoyenById(id);
	}
	
	@RequestMapping(value="/prodscat/{idNat}",method = RequestMethod.GET)
	public List<Citoyen> getProduitsByCatId(@PathVariable("idNat") Long idCat) {
		return produitService.findByNationaliteIdNat(idCat);
	}
	
		@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
		public List<Citoyen> findByNomCitoyenContains(@PathVariable("nom") String nom) {
		return produitService.findByNomCitoyenContains(nom);
		}

		
	}

	
	
	



