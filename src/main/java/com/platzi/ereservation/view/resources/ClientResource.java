package com.platzi.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.services.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.resources.vo.ClientVO;

/**
 * Cliente de servicio web
 * @author josemolina
 *
 */

@RestController
@RequestMapping("/api/client")
public class ClientResource {
	
	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO){
		Client client = new Client();
		
		client.setCliId(clientVO.getCliId());	
		client.setCliName(clientVO.getCliName());
		client.setCliLastName(clientVO.getCliLastName());	
		client.setCliAddress(clientVO.getCliAddress());
		client.setCliPhone(clientVO.getCliPhone());
		client.setCliEmail(clientVO.getCliEmail());
		client.setCliIdentification(clientVO.getCliIdentification());
		
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{identification}")
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification,  @RequestBody ClientVO clientVO){
		Client client = this.clientService.findByIdentification(identification);
		if(client==null)
		{
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		else {
			client.setCliId(clientVO.getCliId());	
			client.setCliName(clientVO.getCliName());
			client.setCliLastName(clientVO.getCliLastName());	
			client.setCliAddress(clientVO.getCliAddress());
			client.setCliPhone(clientVO.getCliPhone());
			client.setCliEmail(clientVO.getCliEmail());			
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{identificaion}")
	public void deleteClient(@PathVariable("identificaion") String identification) {
		Client client = this.clientService.findByIdentification(identification);
		if(client!=null)
		{
			this.clientService.delete(client);			
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}

}
