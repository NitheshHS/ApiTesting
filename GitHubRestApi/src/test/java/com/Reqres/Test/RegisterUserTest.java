package com.Reqres.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RegisterUserTest {
	@Test
	public void registerTest() {
		JSONObject job=new JSONObject();
		job.put("email", "eve.holt@reqres.in");
		job.put("password", "pistol");
		given()
			.contentType(ContentType.JSON)
			.body(job)
		.when()
			.post("https://reqres.in/api/register")
		.then()
			.assertThat().statusCode(200)
		.and()
			.log().all();
		
	}

}
