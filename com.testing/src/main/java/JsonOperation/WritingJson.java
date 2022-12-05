package JsonOperation;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WritingJson {

	public static void main(String[] args) throws IOException {

		JSONObject object = new JSONObject();
		object.put("Name", "Test");
		object.put("Age", 1);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add("TestOne");
		jsonArray.add("TestTwo");
		
		object.put( "testArr", jsonArray);
		
		FileWriter writer= new FileWriter("TEst.json");
		
		writer.write(object.toJSONString());
		writer.close();
		
		System.out.println();
		
	}
}
