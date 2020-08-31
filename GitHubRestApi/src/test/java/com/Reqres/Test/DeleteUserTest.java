package com.Reqres.Test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {
	@Test
	public void deleteUserTest() {
		when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.assertThat().statusCode(204)
		.and()
			.log().all();
			
	}

}
