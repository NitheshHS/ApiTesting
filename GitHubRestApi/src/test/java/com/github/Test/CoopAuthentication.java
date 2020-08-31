package com.github.Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CoopAuthentication {
	@Test
	public void getToken() {
		Response res = given()
			.formParam("client_id", "GetTocken")
			.formParam("client_secret", "f0f5b5bc67b0a482f405b34a84ee8a4b")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
			.auth()
				.oauth2(token)
		.when()	
			.post("http://coop.apps.symfonycasts.com/api/1301/eggs-count")
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("message", Matchers.equalTo("You have collected a total of 0 eggs today"))
			.log().all();
		
	}

}
