package testpackage;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJasonFile {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader Fr = new FileReader("./src/test/resources/cd.json");
		
		JSONParser parser= new JSONParser();
		
		Object obj= parser.parse(Fr);
		
		JSONObject jObj = (JSONObject) obj;
		
		String username = jObj.get("un").toString();
		String password = jObj.get("pwd").toString();
		String url=jObj.get("url").toString();
		String browser=jObj.get("bro").toString();
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(browser);
		
		
	}
}