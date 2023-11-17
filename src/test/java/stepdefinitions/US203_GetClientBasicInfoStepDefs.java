package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.hypnotes.*;

import java.util.ArrayList;

import static base_url.HypnotesBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class US203_GetClientBasicInfoStepDefs {

    Response response;
    RootPojo expectedData;
    Created created;
    Updated updated;
    NearestMeeting nearestMeeting;
    ClientInfo clientInfo;
    Datetime datetime;
    JsonPath jsonPath;

    @Given("user sends a Post request to get client basic info")
    public void user_sends_a_post_request_to_get_client_basic_info() {
//        Set the URL
        spec.pathParams("first", "api", "second", "dashboard", "third", "getClientBasicInfo");

//        Set the expected data
        ArrayList<Object> majorConcerns = new ArrayList<>();
        ArrayList<Object> clientSignedDocuments = new ArrayList<>();
        created = new Created("2023-11-14 21:50:40.000000", 3, "UTC");
        updated = new Updated("2023-11-14 21:50:40.000000", 3, "UTC");
        datetime = new Datetime("2023-11-19 21:00:00.000000", 3, "UTC");
        nearestMeeting = new NearestMeeting(9118, datetime, "https://test.hypnotes.net/telehealth/e20db113-9140-45a7-b0a5-bfd697a26c05", null, null, majorConcerns, null, null, false, "{\"dontNotifyClient\":true,\"sendConfirmationEmail\":true,\"therapistTimezone\":\"Europe\\/Istanbul\",\"clientTimezone\":null}", created, updated, true, "Online", null, 0, null, null, false, null, "", false, null);
        clientInfo = new ClientInfo(false, 2835, "Eddie", "Gordo", "bullsclient@yopmail.com", null, "Europe/Istanbul", 1474, null, clientSignedDocuments, nearestMeeting);
        expectedData = new RootPojo(true, clientInfo);

//        Send the request and get the response
        response = given(spec).post("{first}/{second}/{third}");
        response.prettyPrint();

        jsonPath = response.jsonPath();
    }

    @Then("user validates response")
    public void user_validates_response() {
//        Do Assertions
//        Path I
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.success, jsonPath.getBoolean("success"));
        assertEquals(expectedData.getClientInfo().clientId, jsonPath.getList("ClientInfo.clientId").get(0));
        assertEquals(expectedData.getClientInfo().clientInfosName, jsonPath.getList("ClientInfo.clientInfosName").get(0));
        assertEquals(expectedData.getClientInfo().clientInfosSurname, jsonPath.getList("ClientInfo.clientInfosSurname").get(0));
        assertEquals(expectedData.getClientInfo().clientInfosEmail, jsonPath.getList("ClientInfo.clientInfosEmail").get(0));

//        Path II
        response.then().
                statusCode(200).
                body("success", equalTo(true)).
                body("ClientInfo.clientInfosName", hasItem("Eddie"));

        //    Path III
        RootPojo actualData = convertJsonToJava(response.asString(), RootPojo.class);
        assertEquals(expectedData.success, actualData.success);
        assertEquals(expectedData.getClientInfo().clientInfosName, actualData.getClientInfo().clientInfosImage);

    }


}
