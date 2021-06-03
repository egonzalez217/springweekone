package com.promineotech.jeep.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

public class FetchJeepTestSupport extends BaseTest{
	
	
	@Test
	void test() {
		System.out.println(getBaseUriForJeeps());
	}
	
	protected List<Jeep> buildExpected() {
		List<Jeep> list = new LinkedList<>();
		
		// @Formatter:off
		list.add(
				Jeep.builder()
				.modelId(JeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(2)
				.wheelSize(17)
				.basePrice(new BigDecimal("28475.00"))
				.build());
		
		list.add(
				Jeep.builder()
				.modelId(JeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(4)
				.wheelSize(17)
				.basePrice(new BigDecimal("31975.00"))
				.build());
		//@Formatter:on
		return list;
	}
}
