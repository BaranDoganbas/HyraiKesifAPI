package hooks;

import io.cucumber.java.Before;

import static base_url.HyraiBaseUrl.hyraiSetUp;
import static base_url.KesifBaseUrl.kesifPlusSetUp;
import static utilities.Authentication.generateToken;

public class Hooks {

    @Before("@API")
    public void setUpApi() {
        kesifPlusSetUp();
        generateToken();
        hyraiSetUp();
    }
}
