package JenkinsAutomationProject.APITest;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API {
	
	
	public Response testFilePayload(String baseURI,Map<String,String> queryParams,String endpoint,String contentType,String payloadFileName) {
		Response response=null;
		try {
		if (!baseURI.isEmpty() || !baseURI.contains(null)) {
			RestAssured.baseURI = baseURI;
			System.out.println(baseURI);
		}
		System.out.println();
		
		String payloadPath = System.getProperty("user.dir")+"//"
				+ payloadFileName + ".json";
		System.out.println("payloadPath"+payloadPath);
		
		response=RestAssured.given().queryParams(queryParams)
				.contentType(contentType).body(new File(payloadPath)).log().all().post(endpoint).andReturn();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return response;
	}
	
	
	@Test
	public void testFilePost() {
		String baseURI="https://rahulshettyacademy.com";
		String endpoint="/maps/api/place/add/json";
		String contentType="application/json";
		
		HashMap<String,String> queryParams=new HashMap<>();
		queryParams.put("key", "qaclick123");
		
		String payloadFileName="testJson";
		
		Response res=testFilePayload(baseURI, queryParams, endpoint, contentType, payloadFileName);
		
		System.out.println("response of json file POST.................."+res.asString());
	}
}

