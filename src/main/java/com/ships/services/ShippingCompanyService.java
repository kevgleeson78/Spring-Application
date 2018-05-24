package com.ships.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;

@Service

public class ShippingCompanyService {
	@Autowired
	private ShippingCompanyRepository srp;
	public Iterable<ShippingCompany> FindAllCompany() {

		return srp.findAll();
	}
public ShippingCompany saveShippingCompany(ShippingCompany s) {
	
	String name = s.getName();
	String homePort =s.getHomePort();
	BigDecimal balance =s.getBalance();
	
	s.setName(name);
	s.setHomePort(homePort);
	s.setBalance(balance);
		return srp.save(s);
	}
}
