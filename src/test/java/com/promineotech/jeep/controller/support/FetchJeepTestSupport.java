package com.promineotech.jeep.controller.support;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class FetchJeepTestSupport extends BaseTest{
	@Test
	void test() {
		System.out.println(getBaseUri());
	}
}
