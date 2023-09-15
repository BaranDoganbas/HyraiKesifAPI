package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHyrai {
    public static String cookie;

    public static String generateCookie() {
        Map<String, Object> body = new HashMap<>();
        body.put("email", "demo_corp@hyrai.com");
        body.put("password", "123123");
        body.put("state", "company");

        Response response = given().contentType(ContentType.JSON).body(body).post("https://hyrai.com/api/login");

        Map<String, String> cookieAsMap = new HashMap<>(response.getCookies());
        for (Map.Entry<String, String> entry : cookieAsMap.entrySet()) {
            cookie = entry.getKey() + "=" + entry.getValue();
        }
        return cookie;
    }

}
