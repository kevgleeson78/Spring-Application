package com.ships.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;


@Repository
public interface ShipRepository extends CrudRepository<Ship,Integer>{
	@Query(value = "SELECT * FROM ship where scid is null ",
	   		nativeQuery = true)
	List<Ship> findSpecificShip();

}
