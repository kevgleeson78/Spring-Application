package com.ships.services;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	@Autowired
	ShipRepository shipRepository;
	public Iterable<Ship> FindAll() {

		return shipRepository.findAll();
	}
public Ship saveShip(Ship s) {
	String name = s.getName();
	int passengers = s.getPassengers();
	BigDecimal cost = s.getCost();
	double metres = s.getMetres();
	s.setName(name);
	s.setPassengers(passengers);
	s.setCost(cost);
	s.setMetres(metres);
	return shipRepository.save(s);
	}
public Iterable<Ship> FindNull(){
	return shipRepository.findSpecificShip();
}
public Ship FindOne(int sid) {
	return shipRepository.findOne(sid);
}

}
