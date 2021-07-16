package com.demoblaze.step_definitions;

import com.demoblaze.pages.AdidasPage;
import com.demoblaze.utilities.utilities.BrowserUtils;
import com.demoblaze.utilities.utilities.ConfigurationReader;
import com.demoblaze.utilities.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseStepDefs {

    AdidasPage adidasPage=new AdidasPage();
    int expectedPurchaseAmount=0;

    String orderID;
    int purchaseAmount;




    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @When("user adds {string} from {string}")
    public void user_adds_from(String product, String category) {
       expectedPurchaseAmount+= adidasPage.productAdder(category,product);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }



    @When("user removes {string} from the cart")
    public void user_removes_from_the_cart(String product) {
expectedPurchaseAmount-=adidasPage.productRemover(product);
    }



    @When("user places order and captures logs purchase ID and Amount")
    public void user_places_order_and_captures_logs_purchase_id_and_amount() {
adidasPage.cart.click();
adidasPage.placeOrderButton.click();
adidasPage.fillForm();
adidasPage.purchaseButton.click();

        String confirmation = adidasPage.confirmation.getText();
        System.out.println("confirmation = " + confirmation);

        String[] confirmationArray = confirmation.split("\n");
        orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        purchaseAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
    }



    @Then("user verifies purchase amount eqauls expected")
    public void user_verifies_purchase_amount_eqauls_expected() {
        int actualAmount = purchaseAmount;
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("expectedOrderAmmount = " + expectedPurchaseAmount);
        Assert.assertEquals(expectedPurchaseAmount,actualAmount);
        BrowserUtils.sleep(1);
        adidasPage.OK.click();
        BrowserUtils.sleep(1);
        Driver.closeDriver();

    }
}
