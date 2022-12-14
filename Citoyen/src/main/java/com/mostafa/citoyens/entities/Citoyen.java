package com.mostafa.citoyens.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Citoyen {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCitoyen;
	private String nomCitoyen;
	private int Cin;
	private Date dateNaiss;
	
	@ManyToOne
	private Nationalite nationalite;
	
	
	

	public Citoyen() {
		super();
	}








	public Citoyen(String nomCitoyen, int Cin, Date dateNaiss) {
		super();
		this.nomCitoyen = nomCitoyen;
		this.Cin = Cin;
		this.dateNaiss = dateNaiss;
	}








	public String getNomCitoyen() {
		return nomCitoyen;
	}







	public void setNomCitoyen(String nomCitoyen) {
		this.nomCitoyen = nomCitoyen;
	}







	public int getCin() {
		return Cin;
	}







	public void setCin(int cin) {
		Cin = cin;
	}







	public Date getDateNaiss() {
		return dateNaiss;
	}







	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}







	public Nationalite getNationalite() {
		return nationalite;
	}


	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}








	public Long getIdCitoyen() {
		return idCitoyen;
	}








	public void setIdCitoyen(Long idCitoyen) {
		this.idCitoyen = idCitoyen;
	}








	
	

}
