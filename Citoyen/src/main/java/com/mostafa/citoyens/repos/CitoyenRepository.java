package com.mostafa.citoyens.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.mostafa.citoyens.entities.Nationalite;
import com.mostafa.citoyens.entities.Citoyen;

@RepositoryRestResource(path = "rest")
public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {
	
	List<Citoyen> findByNomCitoyen(String nom);
	List<Citoyen> findByNomCitoyenContains(String nom);
	
	/*@Query("select p from Citoyen p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, int cin);*/
	
	@Query("select p from Citoyen p where p.nomCitoyen like %:nom and p.Cin > :cin")
	List<Citoyen> findByNomCin (@Param("nom") String nom,@Param("cin") int cin);

	@Query("select p from Citoyen p where p.nationalite = ?1")
	List<Citoyen> findByNationalite (Nationalite nationalite);
	
	List<Citoyen> findByNationaliteIdNat(Long id);
	
	List<Citoyen> findByOrderByNomCitoyenAsc();
	
	@Query("select p from Citoyen p order by p.nomCitoyen ASC, p.Cin DESC")
	List<Citoyen> trierCitoyensNomsCin ();

}
