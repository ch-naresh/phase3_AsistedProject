
package restassuredscripts;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Script007HamcrestValidateMethods {
	
	// Hamcrest dependency has been added to your POM file
	// This dependency provides us many validation methods that help us to validate the response code
	
	// equalTo() Hamcrest method
	
	@Test(priority='1')
	public void ValidateResponseBody() {
		
		String PMapikey="PMAK-6577e44b8e9db80037a1cb82-ba3eca52f4c4c25ab01a5955465c9d3f81";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		//fetch the resonse body and validate if response includes correct values or not
		
		.body("workspaces[0].id", equalTo("de8bf0a4-a2c8-4e60-8222-1436f3fc746b"),
				"workspaces[0].name", equalTo("My Workspace"),
				"workspaces[0].type", equalTo("personal"));
			  	
	}
	
	@Test(priority='2')
	public void ValidateResponseBody_equalTo() {
		
		
		given().baseUri("https://petstore.swagger.io")
		.basePath("/v2/user/raghu")
		.when().get()
		.then().statusCode(200)
		//fetch the response body and validate if response includes correct values or not
		
		.body("username", equalTo("raghu"),
			 ("firstName"),equalTo("chappidi"),
			 ("lastName"),equalTo("raghu"),
			 ("email"),equalTo("naresh@gmail.com"),
			 ("userStatus"),equalTo(1));
			 
			 		
	}
	@Test(priority='3')
	public void ValidateResponseBody_hasItems() {
		
	String PMapikey="PMAK-6577e44b8e9db80037a1cb82-ba3eca52f4c4c25ab01a5955465c9d3f81";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		// fetch the response body and validate if response includes correct values or not
		
		.body("workspaces.name", hasItems("Workspace-p", "My Workspace", "Workspace-1"),
			 "workspaces.type", hasItems("personal"));
		
		
	}
	
	

}