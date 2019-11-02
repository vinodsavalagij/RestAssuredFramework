package restAssured.RestAssuredFramework;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.POJO;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class CreateEmployee {
	
	@Test
	public void createEmployee() throws IOException
	
	
	{
		POJO p = new POJO();
		
		p.setName("vino8884dxxx");
		p.setAge("371");
		p.setSalary("52888");
		
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream inStream = new FileInputStream(System.getProperty("user.dir")+"\\URLs.properties");
		
		Properties OR = new Properties();
		
		OR.load(inStream);
		
		RestAssured.baseURI=OR.getProperty("BaseURI");
		 Response res = given().
				contentType(ContentType.JSON).
		
		body(/*"{\"name\":\"testvinod\",\"salary\":\"123\",\"age\":\"23\"}"*/ p).
		
		when().contentType(ContentType.JSON).
		post().
		
		then().assertThat().statusCode(200).extract().response();
		
		System.out.println(res.asString());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+p.getAge());
		
		JsonPath js = new JsonPath(res.asString());
		
		//System.out.println("js.name");
		String name = js.getString("name");
		//Assert.assertEquals("vinodpojybyog47h5", name);
		
	}

}
