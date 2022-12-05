package Test_Rest_Assured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PUT_PATCH_DELETE_RA {

	@Test
	public void putReqRA() {
		baseURI = "https://reqres.in/";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "User");
		jsonObject.put("job", "CEO");

	
		given()
		.when()
		.body(jsonObject.toJSONString())
		.put("api/user/2") // patch("api/user/2") if want use
		// patch just change the method
		.then().statusCode(201);
	}

	public void deleteReqRA() {

		baseURI = "https://reqres.in/";

		given()
		.header("", "")
		.when()
		.delete("api/users/2")
		.then()
		.statusCode(204);

	}

}
