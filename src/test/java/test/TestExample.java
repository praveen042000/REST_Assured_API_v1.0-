package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class TestExample {
    
    @Test
    public void apiTest() {
        Response re = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(re.getStatusCode());
        System.out.println(re.getTime());
        System.out.println(re.getBody().asString());
        System.out.println(re.getStatusLine());
        System.out.println(re.getHeader("content-type"));
        
        int er = re.getStatusCode();
        Assert.assertEquals(er, 200);
    }
    
    @Test
    public void test1() { 
    	baseURI="https://reqres.in/api";
    	given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8))
    	.log().all();
    }
    
    @Test
    public void test2() {
    	baseURI="https://jsonplaceholder.typicode.com";
    	given().get("/posts").then().statusCode(200)
    	.body("[1].id",equalTo(2))
    	.log().all();
    }
}
