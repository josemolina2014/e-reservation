package com.platzi.ereservation.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Client;

/**
 * deinir las operaciones de bd relacionadas con el cliente
 * @author josemolina
 *
 */

public interface ClientRepository extends JpaRepository<Client, String> 
{
	/**
	 * defincion de metodo para buscar por apellido
	 * @param cliLastName
	 * @return
	 */
	public List<Client> findByLastName(String cliLastName);
	
	public Client findByIdentification(String cliIdentification);
	
	
	

}
