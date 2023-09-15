package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationHyrai.generateCookie;

public class HyraiBaseUrl {

    public static RequestSpecification specHyrai;

    public static void hyraiSetUp() {
        specHyrai = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://hyrai.com/").
                build();
    }
}
