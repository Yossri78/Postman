package Package.RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.Assert;
public class MyFirstRestAssuredClass {
	
	public static void getAllPost() throws Exception{
				   
				   String responseString = RestAssured.get("https://jsonplaceholder.typicode.com/posts" ).then()
						   .assertThat()
						   .statusCode(HttpStatus.SC_OK)
						   .extract()
						   .asString();

					Assert.assertEquals(responseString.contains("userId") , true);
					Assert.assertEquals(responseString.contains("id") , true);
					Assert.assertEquals(responseString.contains("title") , true);
					Assert.assertEquals(responseString.contains("body") , true);
					System.out.println(responseString);			

	}	
	
	
	public static void getPost() throws Exception{
		   
		   String responseString = RestAssured.post("https://jsonplaceholder.typicode.com/posts/1").then()
				   .assertThat()
				   .statusCode(HttpStatus.SC_OK)
				   .extract()
				   .asString();
		   
			Assert.assertEquals(responseString.contains("userId") , true);
			Assert.assertEquals(responseString.contains("1") , true);
			Assert.assertEquals(responseString.contains("id") , true);
			Assert.assertEquals(responseString.contains("title") , true);
			Assert.assertEquals(responseString.contains("body") , true);
			System.out.println(responseString);
			
}	
	
	public static void createPost()
	{		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com/posts";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "foo"); 
		requestParams.put("body", "bar");
		requestParams.put("userId", 1);

		request.body(requestParams.toJSONString());
		Response response = request.post(RestAssured.baseURI);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
}