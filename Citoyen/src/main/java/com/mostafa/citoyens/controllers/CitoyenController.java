package com.mostafa.citoyens.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mostafa.citoyens.entities.Citoyen;
import com.mostafa.citoyens.service.CitoyenService;

@Controller
public class CitoyenController {
	
	
	@Autowired
	CitoyenService citoyenService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createCitoyen";
	}
	
	@RequestMapping("/saveCitoyen")
	public String saveCitoyen(@ModelAttribute("citoyen") Citoyen citoyen,
							  @RequestParam("date") String date,
	                          ModelMap modelMap) throws 	ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateNaiss = dateformat.parse(String.valueOf(date));
	citoyen.setDateNaiss(dateNaiss);
	
	Citoyen saveCitoyen = citoyenService.saveCitoyen(citoyen);
	String msg ="citoyen enregistré avec Id "+saveCitoyen.getIdCitoyen();
	modelMap.addAttribute("msg", msg);
	return "createCitoyen";
	}
	
	@RequestMapping("/ListeCitoyens")
	public String listeCitoyens(ModelMap modelMap)
	{
		List<Citoyen> prods = citoyenService.getAllCitoyens();
		modelMap.addAttribute("citoyens", prods);
		return "listeCitoyens";
	}
	
	@RequestMapping("/supprimerCitoyen")
	public String supprimerCitoyen(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
		citoyenService.deleteCitoyenById(id);
		List<Citoyen> prods = citoyenService.getAllCitoyens();
		modelMap.addAttribute("citoyens", prods);
	return "listeCitoyens";
	}
	
	@RequestMapping("/modifierCitoyen")
	public String editerCitoyen(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Citoyen p= citoyenService.getCitoyen(id);
	modelMap.addAttribute("citoyen", p);
	return "editerCitoyen";
	}
	
	@RequestMapping("/updateCitoyen")
	public String updateCitoyen(@ModelAttribute("citoyen") Citoyen citoyen,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateNaiss = dateformat.parse(String.valueOf(date));
	citoyen.setDateNaiss(dateNaiss);
	citoyenService.updateCitoyen(citoyen);
	List<Citoyen> prods = citoyenService.getAllCitoyens();
	modelMap.addAttribute("citoyens", prods);
	return "listeCitoyens";
	}
	


}
