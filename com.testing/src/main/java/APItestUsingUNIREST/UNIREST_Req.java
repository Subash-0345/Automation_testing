package APItestUsingUNIREST;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UNIREST_Req {

//	public static void Get_Unirest() throws UnirestException {
//
//		HttpResponse<JsonNode> response = Unirest.get("https://dummy.restapiexample.com/api/v1/employees").asJson();
//		System.out.println("Response Sts: " + response.getStatus());
//		System.out.println("Response msg: " + response.getStatusText());
//		System.out.println("Response Sts: " + response.getBody());
//
//	}
	
//	public void GetReq() throws UnirestException {
//	HttpResponse<JsonNode>	response = Unirest.get("https://apingweb.com/api/users").asJson();
//		System.out.println("Response :"+response.getStatus()+"-----" +response.getStatusText()+"-----"+response.getBody());
//	}

	public static void Post_Unirest() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.post("https://apingweb.com/api/user/create")
				.body("	{\r\n"
						+ "    \"email\": \"batman@yahoo.com\",\r\n"
						+ "    \"name\": \"bruce wayne\",\r\n"
						+ "    \"age\": \"36\",\r\n"
						+ "    \"image\":\"https://example.com/batman.png\"\r\n"
						+ "}").asJson();
		
		System.out.println("Response Sts: " + response.getStatus());
		System.out.println("Response msg: " + response.getStatusText());
		System.out.println("Response Sts: " + response.getBody());

	}
//
//	public static void Put_Unirest() throws UnirestException {
//		HttpResponse<JsonNode> response = Unirest.put("https://dummy.restapiexample.com/public/api/v1/update/21")
//				.body("	{\"name\":\"test\",\"salary\":\"123\",\"age\":\"24\"}").asJson();
//		System.out.println("Response Sts: " + response.getStatus());
//		System.out.println("Response msg: " + response.getStatusText());
//		System.out.println("Response Sts: " + response.getBody());
//	}
//
//	public static void delete_unirest() throws UnirestException {
//		HttpResponse<JsonNode> response = Unirest.delete("https://dummy.restapiexample.com/public/api/v1/delete/2")
//				.asJson();
//		System.out.println("Response Sts: " + response.getStatus());
//		System.out.println("Response msg: " + response.getStatusText());
//		System.out.println("Response Sts: " + response.getBody());
//	}

	public static void main(String[] args) throws UnirestException {
		UNIREST_Req req = new UNIREST_Req();
//			req.Get_Unirest();
//			req.GetReq();
			req.Post_Unirest();
//			req.Put_Unirest();
//			req.delete_unirest();
	}
}
