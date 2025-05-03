package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;
import io.restassured.response.Response;

public class GetAndPostMethod {
//	@Test
	public void gettest(){
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel"));
		
	}
	@Test
	public void posttest() {
	    Map<String, Object> map = new HashMap<>();
	    map.put("name", "praveen");
	    map.put("job", "softwareDeveloper");

	    JSONObject request = new JSONObject(map);
	    System.out.println(request.toJSONString());

	    baseURI = "https://reqres.in/api";
	    Response apiresponse =  given()
	        .header("Content-Type", "application/json")
	        .header("x-api-key", "reqres-free-v1")
	        .contentType(ContentType.JSON).accept(ContentType.JSON)
	        .body(request.toJSONString())
	    .when()
	        .post("/users")
	    .then()
	        .statusCode(201)
	        .log().all()
	        .body("createdAt", notNullValue())
	        .extract().response();
	    
	    String id =apiresponse.path("id");
	    String job = apiresponse.path("job");
	  System.out.println("User_id :"+id);
	  System.out.println("Job_Name:"+job);
	}
	
	@Test
	public void secondtest() {
		
	}

}
