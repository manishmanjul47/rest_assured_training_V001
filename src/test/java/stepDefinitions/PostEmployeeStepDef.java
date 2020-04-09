package stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class PostEmployeeStepDef {

	RequestSpecification request;
	Response response;

public static	HashMap map=new HashMap();
	
@Given("^new data being added$")
public void new_data_being_added() throws Throwable {
    
	
//	JsonObject obj=new JsonObject();
//	obj.addProperty("id", "20");
//	obj.addProperty("email", "hello@gmail.com");
//	obj.addProperty("first_name", "mark");
//	obj.addProperty("last_name", "james");
//	obj.addProperty("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg");
//	request.header("Content-Type","application/json");
//	request.body(obj.toString());
	map.put("id", "20");
	map.put("email", "hello@gmail.com");
	map.put("first_name", "mark");
	map.put("last_name", "james");
	map.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg");
	RestAssured.baseURI="https://reqres.in/api/users";
	 

	

}

@When("^Data is added$")
public void data_is_added() throws Throwable {
	response =given().contentType("application/json").body(map).when().post("https://reqres.in/api/users");
	String rbody=response.getBody().asString();
	System.out.println(rbody);
}

@Then("^We can verify values$")
public void we_can_verify_values() throws Throwable {
	Assert.assertEquals(response.getStatusCode(), 201);
}

		
	}

