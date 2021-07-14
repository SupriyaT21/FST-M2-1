package test.java.projects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GitHubProject {
	//Declare Request specification
	RequestSpecification requestSpec;
	int sshID;
	
	 @BeforeClass
	 public void setUp() {
	//Set request specification
	requestSpec = new RequestSpecBuilder()
	//Set content type
	.setContentType(ContentType.JSON)
	.addHeader("Authorization","token ")
	//Set Base URL
	.setBaseUri("https://api.github.com")
	//Build request specification
	.build();
}
	 
	 public void addNewKey() {
	        // Create JSON request
	        String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa ****"}";
	 
	        Response response = 
	            given().spec(requestSpec) // Set headers
	            .body(reqBody) // Add request body
	            .when().post("/user/keys"); // Send POST request
	        
	        sshID = response.then().extract().path("id");
	        
	        // Assertions
	        response.then().statusCode(201);
	        response.then().body("id", equalTo(sshID));
	 }
	 
	 @Test(priority=2)
	    public void getKeyInfo() {
	        Response response = 
	            given().spec(requestSpec) // Set headers
	            .when().get("/user/keys"); // Send GET request
	 
	        Reporter.log(response.body().asPrettyString());
	        // Assertion
	        response.then().statusCode(200);
	        response.then().body("[0].id", equalTo(sshID));
	    }
	 
	    @Test(priority=3)
	    public void deleteKey() {
	        Response response = 
	            given().spec(requestSpec) // Set headers
	            .when().pathParam("id", sshID) // Set path parameter
	            .delete("/user/keys/{id}"); // Send DELETE request
	        
	        Reporter.log(response.body().asPrettyString());
	        // Assertion
	        response.then().statusCode(204);
	    }
}