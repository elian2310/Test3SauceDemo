package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")
    WebElement facebookButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }

    public void clickOnMenuButton() { menuButton.click(); }

    public void clickOnLogoutButton() { logoutButton.click(); }

    public void clickOnFacebookButton() { facebookButton.click(); }

}
