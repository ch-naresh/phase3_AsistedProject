
package restassuredscripts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Script010_LoggingMethods {
	
	
	@Test
	public void LoggingRestAssured() {
		
		String PMapikey = "PMAK-6577e44b8e9db80037a1cb82-ba3eca52f4c4c25ab01a5955465c9d3f81";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().log().all();
		//.then().log().headers();
		//.then().log().ifError();
		//.then().statusCode(200).log().cookies();
		
		
	}

}