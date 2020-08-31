package com.Github.GenericLib;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		baseURI="https://api.github.com";
	}
	

}
