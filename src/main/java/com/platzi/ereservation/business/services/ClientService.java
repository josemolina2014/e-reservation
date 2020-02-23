package com.platzi.ereservation.business.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.model.Client;

/**
 * clase para definir los servicios del cliente
 * @author josemolina
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {		
		this.clientRepository = clientRepository;
	}
	
	/**
	 * Creación de cliente en la base de datos
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);				
	}
	/**
	 * actualizar cliente
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}
	/**
	 * Eliminar un cliente
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
		
	}
	/**
	 * busqueda por identificacion
	 * @param cliIdentification
	 * @return
	 */
	public Client findByIdentification(String cliIdentification) {
		return this.clientRepository.findByIdentification(cliIdentification);
	}
	/**
	 * Busqueda por apellido
	 * @param cliLastName
	 * @return
	 */
	public List<Client> findByLastName(String cliLastName){
		return this.clientRepository.findByCliLastName(cliLastName);
	}
}
