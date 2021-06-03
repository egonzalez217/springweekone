package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.Tire;

public interface JeepOrderDao {
  
	
  List<@NotNull @Length(max = 30) @Pattern(regexp = "[A-Z0-9_]*") Option> fetchOptions(List<String> optionIds);
  
  Optional<Customer> fetchCustomer(String customerId);
  
  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);

  Optional<Color> fetchColor(String colorId);
  
  Optional<Engine> fetchEngine(String engineId);
  
  Optional<Tire> fetchTire(String tireId);
  
  
  
  Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price, List<Option> options);

Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price);
}
