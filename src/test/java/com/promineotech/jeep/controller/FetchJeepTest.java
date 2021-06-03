package com.promineotech.jeep.controller;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.net.http.HttpHeaders;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.http.HttpMethod;

import com.promineotech.jeep.JeepSales;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.controller.support.BaseTest;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@Nested
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:Files/src/test/resources/flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:Files/src/test/resources/flyway/migrations/V1.1__Jeep_data.sql"},
		config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest extends FetchJeepTestSupport
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() 
	{

		
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = 
				String.format("%s?model=%s&trim=%s", getBaseUriForJeeps(), model, trim);
		
		ResponseEntity<List<Jeep>> response = getRestTemplate().exchange(
				uri, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		List<Jeep> actual = response.getBody();
		List<Jeep> expected = buildExpected();
		
		System.out.println(expected);
		
		actual.forEach(jeep -> jeep.setModelPK(null));
		
		assertThat(actual).isEqualTo(expected);
	}
}

