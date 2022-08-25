import Pages.*;
import Utilities.DriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutTests extends BaseTest {
    @Test
    public void verifyCheckoutAndPayment(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCart();
        CartPage cart = new CartPage(DriverManager.getDriver().driver);
        cart.clickOnCheckoutButton();
        CheckoutInfoPage checkoutInfo = new CheckoutInfoPage(DriverManager.getDriver().driver);
        checkoutInfo.setFirstNameField("Juan");
        checkoutInfo.setLastNameField("Quispe");
        checkoutInfo.setPostalCode("1234");
        checkoutInfo.clickOnContinue();
        CheckoutBriefPage brief = new CheckoutBriefPage(DriverManager.getDriver().driver);
        String expectedPrice = "Item total: " + brief.getFirstItemPrice();
        Assert.assertEquals(expectedPrice, brief.getTotalPrice());
        brief.clickOnFinishButton();
        CheckoutFinishPage finishPage = new CheckoutFinishPage(DriverManager.getDriver().driver);
        Assert.assertTrue(finishPage.isDisplayedThanksText());
    }
}
