package com.github.Test;

import org.testng.annotations.Test;

import com.Github.GenericLib.BaseClass;
import com.Github.GenericLib.IEndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class DeleteRepository extends BaseClass{
	
	@Test
	public void deleteRepository() {
		Response res = given()
			.contentType(ContentType.JSON)
			.auth()
			.oauth2("e5fc06ecb9830692192090075c057b3a4683718d")
			.pathParam("username", "NitheshHS")
		.when()
			.get(IEndPoint.getAllRepo);
		
		ArrayList<Object> path = res.jsonPath().get("name");
		for(Object ob:path) {
		System.out.println(ob);
		}
		
		for(Object pa:path) {
			if(pa.equals("Rest"))
			{
				System.out.println(pa);
				Response response = given()
					.contentType(ContentType.JSON)
					.auth()
					.basic("NitheshHS", "nithesh@1998")
					.pathParam("owner", "NithesHS")
					.pathParam("repo", "Rest")
				.when()
					.delete(IEndPoint.deleteRepo);
				response.then()
					.assertThat().statusCode(404)
				.and()
					.log().all();
				System.out.println(response.getStatusCode());
			}
		}
		System.out.println(path);
}

}
