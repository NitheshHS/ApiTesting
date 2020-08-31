package com.Reqres.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LoginApiTest {
	@Test
	public void logiApiTest() {
		JSONObject job=new JSONObject();
		job.put("email", "eve.holt@reqres.in");
		job.put("password", "cityslicka");
		Response res = given()
			.contentType(ContentType.JSON)
			.body(job,ObjectMapperType.JACKSON_1)
		.when()
			.post("https://reqres.in/api/login");
		res.then()
			.assertThat()
				.statusCode(200)
		.and()
			.log().all();
		Object token = res.jsonPath().get("token");
		System.out.println(token);
	}

}
