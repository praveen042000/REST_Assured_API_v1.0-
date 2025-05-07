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
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when().put("/users/2")
		.then().statusCode(200).log().all();
		}

}
