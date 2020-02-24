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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Cliente de servicio web
 * @author josemolina
 *
 */

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {
	
	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = {
							@ApiResponse(code = 201, message = "Cliente creado correctamente"),
							@ApiResponse(code = 400, message = "Solicitud Inválida")
						 })
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
	@ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = {
							@ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
							@ApiResponse(code = 404, message = "Cliente no encontrado")
						 })
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
	@PutMapping("/{identification}")
	@ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = {
							@ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
							@ApiResponse(code = 404, message = "Cliente no encontrado")
						 })
	public void deleteClient(@PathVariable("identificaion") String identification) {
		Client client = this.clientService.findByIdentification(identification);
		if(client!=null)
		{
			this.clientService.delete(client);			
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses( value = {
							@ApiResponse(code = 201, message = "Clientes encontrados"),
							@ApiResponse(code = 404, message = "Clientes no encontrados")
						})
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}

}
