package JsonOperation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader("TEst.json");

		Object parsedObject = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) parsedObject;

		String nameString = (String) jsonObject.get("Name");

		long ageString = (long) jsonObject.get("Age");

		JSONArray jsonArray = (JSONArray) jsonObject.get("testArr");

		Iterator iterator = jsonArray.iterator();

		System.out.println(nameString);
		System.out.println(ageString);
		
		while (iterator.hasNext()) {

			System.out.println(iterator.next());

		}
	}

}
