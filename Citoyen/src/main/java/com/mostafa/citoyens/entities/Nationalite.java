package com.mostafa.citoyens.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nationalite {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idNat;
	
	private String nomNat;
	private String descriptionNat;
	
	
	@OneToMany (mappedBy = "nationalite")
	@JsonIgnore
	private List<Citoyen> citoyens;
	
	
}
