package com.github.Test;

import org.testng.annotations.Test;

import com.Github.GenericLib.BaseClass;
import com.Github.GenericLib.IEndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GetAllRepo extends BaseClass{
	@Test
	public void repoList() {
		Response res = given()
			.contentType(ContentType.JSON)
			.auth()
			.basic("NitheshHS", "nithesh@1998")
			.pathParam("username", "NitheshHS")
		.when()
			.get(IEndPoint.getAllRepo);
			
		
		System.out.println(res.getStatusCode());
		System.out.println(res.timeIn(TimeUnit.MILLISECONDS));
		ArrayList<Object> userrepo=res.jsonPath().get("full_name");
		res.then()
			.assertThat().statusCode(200);
		for(Object user:userrepo) {
		System.out.println(user);
		}
		
	}

}
