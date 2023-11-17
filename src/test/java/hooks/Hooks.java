package hooks;

import io.cucumber.java.Before;

import static base_url.HypnotesBaseUrl.hypnotesSetUp;
import static base_url.HyraiBaseUrl.hyraiSetUp;
import static utilities.Authentication.generateToken;

public class Hooks {

    @Before("@API")
    public void setUpApi() {
        hyraiSetUp();
        hypnotesSetUp();
    }
}
