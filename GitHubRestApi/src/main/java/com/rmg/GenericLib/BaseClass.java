package com.rmg.GenericLib;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecBuilder builder;
	public RequestSpecification request;
	@BeforeSuite
	public void congigBS() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:8084");
		builder.setContentType(ContentType.JSON);
		request=builder.build();
	}
	
	@AfterSuite
	public void configAS() {
		
	}

}
