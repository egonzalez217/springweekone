package com.promineotech.jeep.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.Tire;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultJeepSalesService implements JeepSalesService {

	@Autowired
	private JeepSalesDao jeepSalesDao;
	
	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.info("fetchJeeps method was called with model={} and trim={}", model, trim);
		
		return jeepSalesDao.fetchJeeps(model, trim);
	}

	@Override
	public Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price,
			List<Option> options) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
