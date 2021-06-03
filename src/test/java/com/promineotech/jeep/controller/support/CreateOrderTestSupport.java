package com.promineotech.jeep.controller.support;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:Files/src/test/resources/flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:Files/src/test/resources/flyway/migrations/V1.1__Jeep_data.sql"},
		config = @SqlConfig(encoding = "utf-8"))
public class CreateOrderTestSupport extends BaseTest{
	
	

	protected String createOrderBody() {
		//@formatter:off
		return  "{\n"
				+ "		\"customer\"\"MORRISON_LINA\",\n"
				+ "		\"model\":\"WRANGLER\",\n"
				+ "		\"trim\":\"Sport Altitude\"\n"
				+ "		\"doors\":4,\n"
				+ "		\"color\":\"EXT_NACHO\",\n"
				+ "		\"engine\":\2__0_TURBO\",\n"
				+ "		\"tire\":\"35_TOYO\",\n"
				+ "		\"options\":[\n"
				+ "  		\"DOOR_QUAD_4\",\n"
				+ "  		\"EXT_WARN_LIFT\",\n"
				+ "  		\"EXT_WARN_WINCH\",\n"
				+ "  		\"EXT_WARN_BUMPER_FRONT\",\n"
				+ "  		\"EXT_WARN_BUMPER_REAR\",\n"
				+ "  		\"EXT_ARB_COMPRESSOR\",\n"
				+ "	]\n"
				+ "}";
		//@formatter:on		
	}
}
