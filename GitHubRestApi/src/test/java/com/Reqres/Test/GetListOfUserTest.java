package com.Reqres.Test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class GetListOfUserTest {
	
	@Test
	public void getlistOfUserTest() {
		Response res = given()
			.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/users");
		res.then()
			.assertThat().statusCode(200)
		.and()
			.log().all();
		ArrayList<String> lst=res.jsonPath().get("data.first_name");
		for(int i=0;i<lst.size();i++) {
			System.out.println(lst.get(i));
		}
				
	}

}
