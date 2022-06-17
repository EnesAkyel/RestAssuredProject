package tests;

import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class GetF1Seasons {
	@Test
	public void GetExample1() {
		RestAssured.baseURI = "http://ergast.com/api/f1/seasons";
		Response response = null;

		try {
			response = RestAssured.given()
					.when()
					.get();
		} catch(Exception e){
			e.printStackTrace();
		}

		if (response != null) {
			System.out.println("Response: " + response.asString());
			System.out.println("Status Code: " + response.getStatusCode());
			Assert.assertEquals(200, response.getStatusCode());
		}
		else {
			System.out.println("Response returned null!");
		}
	}
}