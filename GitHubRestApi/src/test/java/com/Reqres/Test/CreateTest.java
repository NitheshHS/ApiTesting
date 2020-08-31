package com.Reqres.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateTest {
	
	
	@Test
	public void createTest() {
		JSONObject job=new JSONObject();
		job.put("name", "Nithesh");
		job.put("job", "Junior Engineer");
		Response res=given()
			.contentType(ContentType.JSON)
			.body(job.toJSONString())
		.when()
			.post("https://reqres.in/api/users");
		res.then()
			.assertThat().statusCode(201)
		.and()
			.log().all();
		System.out.println(res.timeIn(TimeUnit.MILLISECONDS)+"ms");
		System.out.println(res.header("Content-Type"));
		
	}

}
