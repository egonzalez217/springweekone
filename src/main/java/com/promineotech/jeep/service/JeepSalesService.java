package com.promineotech.jeep.service;

import java.math.BigDecimal;
import java.util.List;

import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.Tire;

public interface JeepSalesService {

	/**
	 * 
	 * @param model
	 * @param trim
	 * @return
	 */
	List<Jeep> fetchJeeps(JeepModel model, String trim);
	
	Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, 
			BigDecimal price, List<Option> options);
}
