package com.RestAPITest;


import org.testng.annotations.Test;
import org.testng.Assert;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

public class TelecomAPITest {
	String tokenValue;
	  @Test
	  public void login()
	  {
		  
		  HashMap<String,Object> details = new HashMap<String,Object>();
		  details.put("email","preeti26@gmail.com" );
		  details.put("password","test123");
		  
		  Response res = given()
				  .header("Content-Type","application/json")
				  .header("Accept","application/json")
		  .body(details)
		  
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
		  
		  res.then().log().body();
		  
		  tokenValue=res.jsonPath().getString("token");
		  
		 System.out.println(tokenValue);

	  }
	  
	  @Test
	  public void addUser()
	  {
		  
		  HashMap<String,Object> details = new HashMap<String,Object>();
		  details.put("firstName","Preeti");
		  details.put("lastName","Verma" );
		  details.put("email","preeti26@gmail.com" );
		  details.put("password","test123");
		  
		  Response res = given()
				  .header("Content-Type","application/json")
				  .header("Accept","application/json")
		  .body(details)
		  
		  .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
		  
		  res.then().log().body();
		  
		  tokenValue=res.jsonPath().getString("token");
		  
		  int code = res.getStatusCode();
		  Assert.assertEquals(code,201);
		  System.out.println("Token generated is :" +tokenValue);  
		  System.out.println("Status verified :" +code);  

	  }
	}

