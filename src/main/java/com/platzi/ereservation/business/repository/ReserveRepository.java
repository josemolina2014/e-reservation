package com.platzi.ereservation.business.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Reserve;

/**
 * interace para definir las operaciones de bd relacionadas con la reserva
 * @author josemolina
 *
 */

public interface ReserveRepository extends JpaRepository<Reserve, String> 
{

	@Query("select r from Reserve r where r.reseGetIneDate =:startDate and r.reseGetOutDate =:endDate")
	public List<Reserve> find(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
