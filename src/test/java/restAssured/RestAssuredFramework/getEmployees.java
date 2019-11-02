package restAssured.RestAssuredFramework;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.Iterator;
import java.util.List;

public class getEmployees
{
	@Test
	public void putValidation()
	{
		
		Response response = get("http://dummy.restapiexample.com/api/v1/employees").then().extract().response();
		
		
		String res = response.asString();
		
		JsonPath js = new JsonPath(res);
		
		System.out.println(res);
		System.out.println(js.getString("id[1]"));
		
		
		
		List<String> ids= js.getList("id");
		
		System.out.println("------------------------------------"+ids.size());
		
		Iterator it = ids.iterator();
		
		while(it.hasNext())
			
		{
			
			System.out.println(it.next());
			
		}
	}


}