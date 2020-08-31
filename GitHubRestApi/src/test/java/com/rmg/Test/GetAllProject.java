package com.rmg.Test;

import org.testng.annotations.Test;

import com.rmg.GenericLib.IEndPoint;

import io.restassured.response.Response;

import com.rmg.GenericLib.BaseClass;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class GetAllProject extends BaseClass {
	@Test
	public void getAllProject() {
		Response res = given()
						.spec(request)
						.when()
						.get(IEndPoint.getProject);
		//res.then().log().all();
		
		ArrayList<String> projList=res.jsonPath().get("projectName");
		
		for(String str:projList) {
			System.out.println(str);
		}
			
	}

}
