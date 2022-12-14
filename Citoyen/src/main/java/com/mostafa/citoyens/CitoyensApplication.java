package com.mostafa.citoyens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.mostafa.citoyens.entities.Citoyen;
import com.mostafa.citoyens.entities.Nationalite;

@SpringBootApplication
public class CitoyensApplication  implements CommandLineRunner{

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CitoyensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Citoyen.class,Nationalite.class);
		
		
	}

}
