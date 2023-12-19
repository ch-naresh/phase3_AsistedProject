
package restassuredscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script02GetMethod {

    @Test
    public void httpGetMethod() {
        Response res = RestAssured.get("https://reqres.in/api/users/3");
        

        System.out.println(res.getStatusCode());
        System.out.println(res.getBody().asPrettyString());
        System.out.println(res.getTime());
        System.out.println(res.getHeader("Content-Type"));

        int expectedStatusCode = 200;
        int actualStatusCode = res.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}