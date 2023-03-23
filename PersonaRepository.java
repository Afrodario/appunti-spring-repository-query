package it.softwareInside.AnagraficaAppLezione23.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String> {
	@Query(value="SELECT * FROM Persona p WHERE p.eta >= 25", nativeQuery = true)
	Collection<Persona> getAllMax25Persona();
	
	@Query(value="SELECT SUM(eta) FROM PERSONA", nativeQuery = true)
	int sommaEta();
	
	//Sintassi ?1 per passare dei parametri nella query SQL
	@Query(value="SELECT * FROM Persona p WHERE p.eta >= ?1", nativeQuery = true)
	Collection<Persona> getEtaMaggiore(int etaPersona);
}
