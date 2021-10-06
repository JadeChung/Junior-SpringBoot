package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.util.Assert;

import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql", "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
	 config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends FetchJeepTestSupport {
	@Test
	void testDB() {
		
	}
	
	@Disabled
	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied(){
		// Given a valid model or trim
		JeepModel model = JeepModel.WRANGLER; 
		String trim = "Sport";
		String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
		
		// connection is made to the uri
				System.out.println(getBaseUri());
				ResponseEntity<List<Jeep>> response = 
						getRestTemplate().exchange(uri, HttpMethod.GET, null,
								new ParameterizedTypeReference<>() {});
				
		// 200 status
				assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
				
		// and actual list is the same as expected list
		List<Jeep> actual = response.getBody();
		List<Jeep> expected = buildExpected();
		
		
		assertThat(response.getBody()).isEqualTo(expected);
	}

}
	

