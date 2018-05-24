package com.ships.controllers;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderInfoService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class MainController {
	@Autowired
	private ShipService shipService;
	@Autowired
	private ShippingCompanyService scs;
	@Autowired
	private OrderInfoService ois;

	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String listPeople(Model model, HttpServletRequest h) {
		ArrayList<Ship> s = (ArrayList<Ship>) shipService.FindAll();

		model.addAttribute("ships", s);

		return "showShips";
	}

	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String addShip(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addShip";
	}

	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShipdb(@Valid @ModelAttribute("ship") Ship s, BindingResult result) {
		if (result.hasErrors()) {
			return "addShip";
		}

		shipService.saveShip(s);

		return "redirect:showShips";
	}

	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String showShippingCompanies(Model model, HttpServletRequest h) {
		ArrayList<ShippingCompany> c = (ArrayList<ShippingCompany>) scs.FindAllCompany();

		model.addAttribute("company", c);

		return "showShippingCompanies";
	}

	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String addShippingCompany(@ModelAttribute("shippingCompany") ShippingCompany shippingCompany,
			HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addShippingCompany";
	}

	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addShippingCompanydb(@Valid @ModelAttribute("shippingCompany") ShippingCompany s,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addShippingCompany";
		}

		scs.saveShippingCompany(s);
		return "redirect:showShippingCompanies";
	}

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrderInfo(Model model, HttpServletRequest h) {
		ArrayList<OrderInfo> o = (ArrayList<OrderInfo>) ois.FindAll();

		model.addAttribute("order", o);

		return "showOrders";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String addPerson(@ModelAttribute("oid") OrderInfo orderInfo, Model model) {
		ArrayList<Ship> ships = (ArrayList<Ship>) shipService.FindNull();
		ArrayList<ShippingCompany> shippingcompanies = (ArrayList<ShippingCompany>) scs.FindAllCompany();
		// Create countryList Map
		Map<Integer, String> shipList = new HashMap<Integer, String>();
		Map<Integer, String> shipcList = new HashMap<Integer, String>();
		model.addAttribute("shipList", shipList);
		model.addAttribute("shipcList", shipcList);
		// ShippingCompany sc = new ShippingCompany();

		// Add Countries to Map
		for (Ship c : ships) {
			shipList.put(c.getSid(), c.getName() + "; Cost = " + c.getCost());

		}
		for (ShippingCompany c : shippingcompanies) {
			shipcList.put(c.getScid(), c.getName() + "; Ballance = " + c.getBalance());

		}

		return "createOrder";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrder(@Valid @ModelAttribute("oid") OrderInfo o, BindingResult res, HttpServletRequest req) {
		if (res.hasErrors()) {
			return "emptyField";
		}
		if (ois.checkbalance(o) == true) {
			return "balance";
		}
		shipService.saveShip(o.getShip());
		ois.saveOrderInfo(o);
		scs.saveShippingCompany(o.getShippingCompany());

		return "redirect:showOrders";
	}

}
