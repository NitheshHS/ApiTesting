package com.coopApi.Test;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetToken {
	
	@Test
	public void getTokenTest() {

		Response res = given()
			.formParam("client_id", "GetTocken")
			.formParam("client_secret", "f0f5b5bc67b0a482f405b34a84ee8a4b")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		//res.then().log().all();
		
		Response res1 = given()
			.pathParam("USER_ID", "1301")
			.auth()
				.oauth2(token)
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect");
		
		System.out.println(res1.jsonPath().get("message"));
	}
	

}
