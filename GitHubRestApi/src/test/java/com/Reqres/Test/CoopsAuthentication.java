package com.Reqres.Test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CoopsAuthentication {
	@Test
	public void coopTest() {
		Response res = given()
			.formParam("client_id", "GetTocken")
			.formParam("client_secret", "f0f5b5bc67b0a482f405b34a84ee8a4b")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		res.then()
			.log().all();
		
		String token = res.jsonPath().get("access_token");
			
		given()
			.auth()
				.oauth2(token)
				.pathParam("USER_ID", "1301")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
			.log().all();
	
	}

}
