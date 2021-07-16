package com.demoblaze.step_definitions;

import com.demoblaze.utilities.utilities.ConfigurationReader;
import com.demoblaze.utilities.utilities.Driver;
import io.cucumber.java.en.Given;

public class PurchaseStepDefs {
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
}
