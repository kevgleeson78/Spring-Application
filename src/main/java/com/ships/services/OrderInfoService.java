package com.ships.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInfoRepository;

@Service
public class OrderInfoService {
	@Autowired
	OrderInfoRepository orderInfoRepository;

	public Iterable<OrderInfo> FindAll() {

		return orderInfoRepository.findAll();
	}

	public OrderInfo saveOrderInfo(OrderInfo o) {

		Ship ship = new Ship();
		ShippingCompany sc = new ShippingCompany();
		Date date = new Date();
		String newDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		o.setDate(newDate);
		sc = o.getShippingCompany();
		
		BigDecimal newBalance = o.getShippingCompany().getBalance().subtract(o.getShip().getCost());
		sc.setName(o.getShippingCompany().getName());
		sc.setHomePort(o.getShippingCompany().getHomePort());
		sc.setBalance(newBalance);

		ship = o.getShip();
		sc.setScid(o.getShippingCompany().getScid());
		o.setShip(ship);
		ship.setShippingCompany(sc);
		return orderInfoRepository.save(o);
	}

	public boolean checkbalance(OrderInfo o) {
		if (o.getShip().getCost().compareTo(o.getShippingCompany().getBalance()) > 0) {
			return true;
		}
		return false;
	}

}
