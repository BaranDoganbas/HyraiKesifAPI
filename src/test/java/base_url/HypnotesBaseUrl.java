package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationHypnotes.generateCookie;

public class HypnotesBaseUrl {

    public static RequestSpecification spec;

    public static void hypnotesSetUp() {

        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Cookie", generateCookie()).
                setBaseUri("https://test.hypnotes.net/").
                build();

    }

}
