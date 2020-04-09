package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import static io.restassured.RestAssured.*;



public class GetEmployeeStepDef
{
	Response response;
	RequestSpecification request;
	ValidatableResponse json;


	@Given("^An employee exists$")
	public void an_employee_exists() throws Throwable {
		request=given().contentType(ContentType.JSON);
		response=request.get("http://reqres.in/api/users/10");
		System.out.println("response:"+response.prettyPrint());    
		
	}

	
	@Then("^I should see first name as \"([^\"]*)\"$")
	public void i_should_see_first_name_as(String arg1) throws Throwable {
		String firstName = given()
		        .spec(request)
		        .when()
		          .get("http://reqres.in/api/users/10")
		        .then()
		        .extract()
		          .path("data.first_name");
		
		System.out.println(firstName);
		Assert.assertEquals(firstName, arg1);
	}
	

	@Then("^Status code should be (\\d+)$")
	public void status_code_should_be(int arg1) throws Throwable {
		Assert.assertEquals(response.getStatusCode(), arg1);
	}

	

}



