package com.mostafa.citoyens;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mostafa.citoyens.entities.Nationalite;
import com.mostafa.citoyens.entities.Citoyen;
import com.mostafa.citoyens.repos.CitoyenRepository;


@SpringBootTest
class CitoyensApplicationTests {

	@Autowired
	private CitoyenRepository citoyenRepository;
	
	@Test
	public void testCreateCitoyen() {
	Citoyen prod = new Citoyen("Mostafaaa",980699,new Date());
	citoyenRepository.save(prod);
	}
	
	@Test
	public void testFindCitoyen()
	{
	Citoyen p = citoyenRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateCitoyen()
	{
	Citoyen p = citoyenRepository.findById(1L).get();
	p.setCin(9898400);
	citoyenRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteCitoyen()
	{
		citoyenRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllCitoyens()
	{
		List<Citoyen> prods = citoyenRepository.findAll();
		
		for (Citoyen p:prods)
			 System.out.println(p);
		
	}
	
	
	@Test
	public void testFindCitoyenByNom()
	{
	List<Citoyen> prods = citoyenRepository.findByNomCitoyen("Mostafa");
	
	for (Citoyen p:prods)
		 System.out.println(p);
	
	}
	
	@Test
	public void testFindCitoyenByNomContains()
	{
	List<Citoyen> prods = citoyenRepository.findByNomCitoyenContains("M");
	
	for (Citoyen p:prods)
		 System.out.println(p);
	
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Citoyen> prods = citoyenRepository.findByNomCin("Mostafa", 9894068);
		for (Citoyen p : prods)
			{
				System.out.println(p);
			}
	}
	
	
	@Test
	public void testfindByNationalite()
	{
	Nationalite cat = new Nationalite();
	cat.setIdNat(1L);
	
	List<Citoyen> prods = citoyenRepository.findByNationalite(cat);
	for (Citoyen p : prods)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void findByNationaliteIdNat()
	{
	List<Citoyen> prods = citoyenRepository.findByNationaliteIdNat(1L);
	for (Citoyen p : prods)
	{
		System.out.println(p);
	}
	}
	
	
	@Test
	public void testfindByOrderByNomCitoyenAsc()
	{
	List<Citoyen> prods =  citoyenRepository.findByOrderByNomCitoyenAsc();
	for (Citoyen p : prods)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierCitoyensNomsCin()
	{
	List<Citoyen> prods = citoyenRepository.trierCitoyensNomsCin();
	for (Citoyen p : prods)
	{
	System.out.println(p);
	}
	}
	
	
}
