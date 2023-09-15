package stepdefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.LoginResponsePojo;
import pojos.Result;
import pojos.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.HyraiBaseUrl.specHyrai;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class CandidateLoginStepDefs {

    Response response;
    JsonPath jsonPath;
    Result resultPojo;
    UserInfo userInfoPojo;
    LoginResponsePojo expectedData;

    @When("user sends Post request to login as candidate")
    public void user_sends_post_request_to_login_as_candidate() {
//        Set the base url
        specHyrai.pathParams("first", "api", "second", "login");

//        Set the expected data
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");

        userInfoPojo = new UserInfo("Baran", "Doganbas", null, roles, 1325, null, "barandoganbas@hotmail.com");
        resultPojo = new Result(1325);

        List<Object> errors = new ArrayList<>();
        List<Object> notifications = new ArrayList<>();
        expectedData = new LoginResponsePojo(resultPojo, 0, userInfoPojo, null, null, errors, notifications, true);

        Map<String, String> body = new HashMap<>();
        body.put("email", "barandoganbas@hotmail.com");
        body.put("password", "123123");
        body.put("state", "candidate");
//        Send the request and get the response
        response = given(specHyrai).when().body(body).post("{first}/{second}");
        response.prettyPrint();

        jsonPath = response.jsonPath();

    }

    @Then("user validates login response data")
    public void user_validates_login_response_data() {
//        Do Assertions

//        1.Path
        assertEquals(200, response.getStatusCode());
        assertTrue(jsonPath.getBoolean("status"));
        assertEquals(expectedData.getResult().getUserId(), jsonPath.get("result.userId"));
        assertEquals(expectedData.getErrors(), jsonPath.get("errors"));
        assertEquals(expectedData.getErrorCode(), jsonPath.get("errorCode"));
        assertEquals(expectedData.getUserInfo().getId(), jsonPath.get("userInfo.id"));
        assertEquals(expectedData.getUserInfo().getEmail(), jsonPath.getString("userInfo.email"));
        assertEquals(expectedData.getUserInfo().getFirstName(), jsonPath.getString("userInfo.firstName"));
        assertEquals(expectedData.getUserInfo().getLastName(), jsonPath.getString("userInfo.lastName"));
        assertEquals(expectedData.getUserInfo().getRoles(), jsonPath.getList("userInfo.roles"));
        assertEquals(expectedData.getUserInfo().getTitle(), jsonPath.getList("userInfo.title"));
        assertEquals(expectedData.getUserInfo().getProfilePicture(), jsonPath.getList("userInfo.profilePicture"));
        assertEquals(expectedData.getNbNotOpenedNotifications(), jsonPath.get("nbNotOpenedNotifications"));
        assertEquals(expectedData.getNotifications(), jsonPath.getList("notifications"));
        assertEquals(expectedData.getCompanyInfo(), jsonPath.get("companyInfo"));

//        2.Path
        response.
                then().
                statusCode(200).
                body("status", equalTo(true)).
                body("errorCode", equalTo(null)).
                body("errors", hasSize(0)).
                body("userInfo.roles", hasItem("ROLE_USER"));

//        3.Path
        LoginResponsePojo actualData = response.as(LoginResponsePojo.class);
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getResult().getUserId(), actualData.getResult().getUserId());
        assertEquals(expectedData.getUserInfo().getEmail(), actualData.getUserInfo().getEmail());
        assertEquals(expectedData.getUserInfo().getFirstName(), actualData.getUserInfo().getFirstName());
        assertEquals(expectedData.getUserInfo().getLastName(), actualData.getUserInfo().getLastName());

//        4.Path
        LoginResponsePojo actualDataObjectMapper = convertJsonToJava(response.asString(), LoginResponsePojo.class);
        assertEquals(expectedData.getStatus(), actualDataObjectMapper.getStatus());
        assertEquals(expectedData.getResult().getUserId(), actualDataObjectMapper.getResult().getUserId());
        assertEquals(expectedData.getUserInfo().getEmail(), actualDataObjectMapper.getUserInfo().getEmail());
        assertEquals(expectedData.getUserInfo().getFirstName(), actualDataObjectMapper.getUserInfo().getFirstName());

//        5.Path
        LoginResponsePojo actualDataGson = new Gson().fromJson(response.asString(), LoginResponsePojo.class);
        assertEquals(expectedData.getStatus(), actualDataGson.getStatus());
        assertEquals(expectedData.getResult().getUserId(), actualDataGson.getResult().getUserId());
        assertEquals(expectedData.getUserInfo().getEmail(), actualDataGson.getUserInfo().getEmail());
        assertEquals(expectedData.getUserInfo().getFirstName(), actualDataGson.getUserInfo().getFirstName());

//        6.Path
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedData.getStatus(), actualDataMap.get("status"));
        assertEquals(expectedData.getResult().getUserId(), ((Map)actualDataMap.get("result")).get("userId"));
        assertEquals(expectedData.getUserInfo().getEmail(), ((Map)actualDataMap.get("userInfo")).get("email"));
        assertEquals(expectedData.getUserInfo().getFirstName(), ((Map)actualDataMap.get("userInfo")).get("firstName"));


    }

}
