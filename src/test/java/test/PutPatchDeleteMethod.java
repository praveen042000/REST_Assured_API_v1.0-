package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;
import io.restassured.response.Response;

public class PutPatchDeleteMethod {
	@Test
	
	public void postmethod() {
		JSONObject request = new JSONObject();
		request.put("name", "Ram");
		request.put("job", "DevopsEngineer");
		System.out.println(request.toJSONString());
		baseURI ="https://reqres.in/api";
		given().header("content-type","application/json")
		  .header("x-api-key", "reqres-free-v1")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when().
		put("/users/2")
		.then().statusCode(200).log().all();
		}
	
	@Test
	public void postMethodCreateObject() {
	    JSONObject data = new JSONObject();
	    data.put("year", 2022);
	    data.put("price", 1300);
	    data.put("CPU model", "Intel i5");
	    data.put("Hard disk size", "512 GB");

	    JSONObject request = new JSONObject();
	    request.put("name", "Dell XPS 13");
	    request.put("data", data);

	    baseURI = "https://api.restful-api.dev";

	    Response response = given()
	        .contentType(ContentType.JSON)
	        .body(request.toJSONString())
	    .when()
	        .post("/objects")
	    .then()
	        .statusCode(200).log().all()
	        .extract().response();

	    String id = response.jsonPath().getString("id");
	    System.out.println("New object ID: " + id);
	}


}
