package com.example.demo.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TestControllerTest {

	TestRestTemplate restTemplate;
	URL base;
	@LocalServerPort int port;

	@Before
	public void setUp() throws MalformedURLException{
		base = new URL("http://localhost:" + port + "/signup");
	}

	@Test
	public void whenLoggedUserRequestsHomePage_ThenSuccess()
			throws IllegalStateException, IOException{
		restTemplate = new TestRestTemplate("user", "password");
		ResponseEntity<String> response
				= restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}

	@Test
	public void whenUserWithWrongCredentials_thenUnauthorizedPage()
			throws Exception {

		restTemplate = new TestRestTemplate("user", "wrongpassword");
		ResponseEntity<String> response
				= restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertTrue(response.getStatusCode() == HttpStatus.UNAUTHORIZED);
	}
}