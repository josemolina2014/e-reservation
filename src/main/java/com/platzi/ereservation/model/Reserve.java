package com.platzi.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "reserve")
public class Reserve {

	@Id
	@GeneratedValue(generator = "system.uuid")
	@GenericGenerator(name ="system.uuid", strategy = "uuid2" )
	private String reseId;
	private Date reseGetIneDate;
	private Date reseGetOutDate;
	@ManyToOne
	@JoinColumn(name = "cliId")
	private Client client;
}
