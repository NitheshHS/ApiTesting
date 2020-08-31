package com.Reqres.Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ListOfUser {
	@Test
	public void getAllUser() {
		
		RequestSpecification request;
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://reqres.in/");
		builder.setContentType(ContentType.JSON);
		request=builder.build();
		
		ResponseSpecification response;
		ResponseSpecBuilder builder1=new ResponseSpecBuilder();
		builder1.expectStatusCode(200);
		builder1.expectContentType(ContentType.JSON);
		response=builder1.build();
		
		Response res = given()
			.spec(request)
			.queryParam("page", 2)
			.get("/api/users");
		
		res.then()
		.assertThat()
		.spec(response);
		
		ArrayList<String> path=res.jsonPath().get("data.first_name");
		for(String p:path) {
			System.out.println(p);
		}
	}

}
