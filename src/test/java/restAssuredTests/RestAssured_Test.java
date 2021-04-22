package restAssuredTests;
import org.junit.Test;
import Package.RestAssured.MyFirstRestAssuredClass;
public class RestAssured_Test {

	
	@Test
	public void getAllPost() throws Exception {
		
		MyFirstRestAssuredClass.getAllPost();
		
}
	@Test
	public void getPost() throws Exception {
		
		MyFirstRestAssuredClass.getPost();

}
	
	@Test
	public void createPost() throws Exception {
		
		MyFirstRestAssuredClass.createPost();

}
	

}