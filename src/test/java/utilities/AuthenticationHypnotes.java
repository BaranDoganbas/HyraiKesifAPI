package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHypnotes {

    public static String cookie;

    public static String generateCookie() {

        Map<String, String> payload = new HashMap<>();
        payload.put("username", "hypnotes2022tr2@gmail.com");
        payload.put("password", "Aydinlik123/");

        Response response = given().contentType(ContentType.JSON).body(payload).post("https://test.hypnotes.net/api/login");

        Map<String, String> cookieAsMap = new HashMap<>(response.getCookies());
        for (Map.Entry<String, String> entry : cookieAsMap.entrySet()) {
            if (entry.getKey().equals("PHPSESSID")) {
                cookie = entry.getKey() + "=" + entry.getValue();
            }
        }
        return cookie;
    }

}
