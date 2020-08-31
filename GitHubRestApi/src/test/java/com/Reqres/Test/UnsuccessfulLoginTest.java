package com.Reqres.Test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UnsuccessfulLoginTest {
	@Test
	public void unsucessfulLogin() {
		JSONObject job=new JSONObject();
		job.put("email", "eve.holt@reqres.in");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.body(job)
		.when()
			.post("https://reqres.in/api/register");
		res.then()
			.assertThat().statusCode(400)
		.and()
			.log().all();
		
		Object msg = res.jsonPath().get("error");
		System.out.println(msg);
		
	}

}
