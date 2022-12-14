package com.mostafa.citoyens.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mostafa.citoyens.entities.Nationalite;
import com.mostafa.citoyens.repos.NationaliteRepository;


@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class NationaliteRESTController {

	@Autowired
	NationaliteRepository nationaliteRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Nationalite> getAllNationalites()
	{
	return nationaliteRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Nationalite getNationaliteById(@PathVariable("id") Long id) {
	return nationaliteRepository.findById(id).get();
	}

	
}
