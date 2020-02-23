package com.platzi.ereservation.model;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Client table
 * @author josemolina
 *
 */
@Data
@Entity
@Table (name = "client")
public class Client {
	
	@Id
	@GeneratedValue(generator = "system.uuid")
	@GenericGenerator(name ="system.uuid", strategy = "uuid2" )
	private String cliId;	
	private String cliName;
	private String cliLastName;
	private String cliID;
	private String cliAddress;
	private String cliPhone;
	private String cliEmail;
	
	@OneToMany(mappedBy = "client")
	private Set<Reserve> reserves;
	public Client() {
		
	}

	

}
