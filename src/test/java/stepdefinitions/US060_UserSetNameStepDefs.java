package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static base_url.KesifBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.token;

public class US060_UserSetNameStepDefs {

    Response response;
    String expectedMessage;
    String actualMessage;

    @When("user sends a Post request to set name")
    public void user_sends_a_post_request_to_set_name() {
//        Set the URL
        spec.pathParams("first", "api", "second", "user", "third", "setname");

//        Set the expected data
        expectedMessage = "namechanged";

        Map<String, Object> payload = new HashMap<>();
        payload.put("token", token);
        payload.put("name", "Ali");

//        Send the request and get the response
        response = given(spec).when().body(payload).post("{first}/{second}/{third}");
        response.prettyPrint();
        actualMessage = response.asString();

    }

    @Then("user validates response data")
    public void user_validates_response_data() {
//        Do Assertions
        assertEquals("Status code is not 200", 200, response.getStatusCode());
        assertEquals("Actual message is not same with expected message", expectedMessage, response.asString());

    }
}
