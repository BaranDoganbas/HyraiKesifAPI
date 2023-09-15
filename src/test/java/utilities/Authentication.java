package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String token;
    public static JsonPath jsonPath;

    public static String generateToken() {
        Map<String, Object> body = new HashMap<>();
        body.put( "email", "qatesting1@gmail.com");
        body.put("password", "123456789");

        Response response = given().when().contentType(ContentType.JSON).body(body).post("https://test.kesifplus.com/api/login");
        jsonPath = response.jsonPath();
        token = jsonPath.getString("token");
        return token;
    }

}
