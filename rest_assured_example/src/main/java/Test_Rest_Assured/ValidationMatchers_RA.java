package Test_Rest_Assured;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidationMatchers_RA {
	
	@Test
	public void validationID() {
		baseURI = "https://reqres.in/api/users/2";

		RestAssured.get(baseURI).then().body("data.id", equalTo(2));
	}

	@Test
	public void validationName() {
		baseURI = "https://reqres.in/api/users/2";

		RestAssured.get(baseURI).then().body("data.last_name", equalTo("Weaver"));
	}

	@Test
	public void validationTime() {
		baseURI = "https://apingweb.com/api/user/100";

		RestAssured.get(baseURI).then().time(lessThan(2L), TimeUnit.SECONDS);
	}
	
	@Test
	public void checkEntries() {
		baseURI = "https://apingweb.com/api/user/100";
		
		RestAssured.get(baseURI).then().body("data", hasSize(1)); //empty if u want check  array is empty
	}
	
	@Test
	public void checkAge() {
		baseURI= "https://apingweb.com/api/user/100";
		
		RestAssured.get(baseURI).then().body("data.age",hasItem("36"));
	}
	
}
