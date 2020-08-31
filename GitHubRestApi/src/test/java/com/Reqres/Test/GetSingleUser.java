package com.Reqres.Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingleUser {
	@Test
	public void getSingleUser() {
		Response res=given()
			.get("https://reqres.in/api/users/2");
		res.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("data.id", Matchers.equalTo(2))
		.and()
			.assertThat().time(Matchers.lessThan(5L), TimeUnit.MILLISECONDS)
		.log().all();
		System.out.println(res.timeIn(TimeUnit.MILLISECONDS)+"ms");
	}

}
