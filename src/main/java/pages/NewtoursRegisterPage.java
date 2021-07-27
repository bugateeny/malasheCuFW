package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewtoursRegisterPage extends BasePage {
    public NewtoursRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement usernameInputElement;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputElement;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPasswordInputElement;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButtonElement;


    public void enterUsername(String text) {
//            usernameInputElement.sendKeys(text);
        sendKeys(usernameInputElement, text);
    }

    public void enterPassword(String text) {
        passwordInputElement.sendKeys(text);
    }

    public void enterConfirmPassword(String text) {
        confirmPasswordInputElement.sendKeys(text);
    }

    public void clickOnSubmitButton() {
        submitButtonElement.click();
    }
}


