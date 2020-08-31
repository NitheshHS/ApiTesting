package com.Reqres.Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class UpdateUser {
	@Test
	public void updateTest() {
		HashMap<String, Object> map=new HashMap<>();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		Response res = given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.put("https://reqres.in/api/users/2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		
		res.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("name", Matchers.equalTo("morpheus"))
		.log().all();
		
	}

}
