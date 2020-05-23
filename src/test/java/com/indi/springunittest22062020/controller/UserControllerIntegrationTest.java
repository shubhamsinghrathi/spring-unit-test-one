package com.indi.springunittest22062020.controller;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.indi.springunittest22062020.prototype.UserPrototype;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Test
	public void findUserByUsernameIntegrationTest() {
		String url = "http://localhost:" + port + "/api/" + UserPrototype.testUser2().getUsername();
		HttpHeaders header = new HttpHeaders();
		List<MediaType> headSet = new ArrayList<MediaType>();
		headSet.add(MediaType.APPLICATION_JSON);
		header.setAccept(headSet);
		HttpEntity<String> entity = new HttpEntity<String>(null, header);

		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		try {
			JSONAssert.assertEquals(UserPrototype.expectedStrTwo(), response.getBody(), false);
		} catch (JSONException e) {
			fail("Error received in integratio testing when calling /api/{username} API");
		}
	}

}
