package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredPostRequest {
    @Test
    public void SubmitForm() {
        RestAssured.baseURI = "https://ptsv2.com/t/rim63-1572034090";
        Response response = null;
        
        try {
	        response = RestAssured.given()
	        		.contentType(ContentType.JSON)
	        		.post("/post");
        } catch(Exception e) {
        	e.printStackTrace();
        }

        if (response != null) {
            System.out.println("Post Response " + response.asString());
        }
        else {
            System.out.println("Response returned null!");
        }
    }
}