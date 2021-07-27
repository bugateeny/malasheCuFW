package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewtoursHomePage extends BasePage{

    public NewtoursHomePage(WebDriver driver) {
        super(driver);
    }

//  collection of web elements  along with their locator values.


    @FindBy(linkText = "SING-ON") private WebElement signOnLinkElement;
    @FindBy(linkText = "REGISTER") private WebElement registerLinkElement;
    @FindBy(linkText = "SUPPORT") private WebElement supportLinkElement;
    @FindBy(linkText = "CONTACT") private WebElement contactLinkElement;
    @FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]") private  WebElement userNameInputElement;
    @FindBy(xpath = "//font[contains(text(),'Password:')]") private  WebElement passwordInputElement;
    @FindBy(xpath = "//input[@name='submit']") private  WebElement submitInputElement;


//Create a method to perform operations on each web element
    public void clickOnSigOnLink() {
        signOnLinkElement.click();
            }

    public void clickOnRegisterLink() {
        registerLinkElement.click();
    }

    public void clickOnSupportLink() {
        supportLinkElement.click();
    }

    public void clickOnContactLink() {
        supportLinkElement.click();
    }

    public void enterUsername (String text){
                userNameInputElement.sendKeys(text);
    }

    public void enterPassword (String text){
        passwordInputElement.sendKeys(text);
    }

    public void clickOnSubmitButton (String text){
        submitInputElement.click();
    }

}


