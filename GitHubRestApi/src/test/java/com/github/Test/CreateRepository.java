package com.github.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Github.GenericLib.IEndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateRepository {
	
	@Test
	public void createRepo() {
		JSONObject job=new JSONObject();
		job.put("name", "Rest");
		job.put("description", "This repo created for rest assured ");
		job.put("homepage", "https://github.com");
		job.put("private", false);
		job.put("has_issues", true);
		job.put("has_projects", true);
		job.put("has_wiki", true);
		
		Response res = given()
			.auth()
				.oauth2("e5fc06ecb9830692192090075c057b3a4683718d")
				.contentType(ContentType.JSON)
				.body(job.toJSONString())
		.when()
			.post("https://api.github.com/user/repos");
		
		res.then()
		.assertThat().statusCode(201)
		.and()
		.log().all();
			
	}

}
