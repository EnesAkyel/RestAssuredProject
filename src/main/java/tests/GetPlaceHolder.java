package tests;

import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.parsing.Parser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPlaceHolder {
	@Test
	public String GetExample3() {
	    String url = "https://jsonplaceholder.typicode.com/todos/1";
	    RestAssured.defaultParser = Parser.JSON;
	    Response response = null;
	    String id = null;

	    try {
	 	   response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                   when().get(url).
                   then().contentType(ContentType.JSON).extract().response();
	    } catch(Exception e){
	 	   e.printStackTrace();
	    }

		if (response != null) {
			id = response.jsonPath().getString("id");
			System.out.println("Response: " + response.asString());
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println(id);
			Assert.assertEquals(200, response.getStatusCode());
		}
		else {
			System.out.println("Response returned null!");
		}
	    
	    return id;
	}
}