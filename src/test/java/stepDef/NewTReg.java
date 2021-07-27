package stepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.NewToursConfirmationPage;
import pages.NewtoursHomePage;
import pages.NewtoursRegisterPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class NewTReg extends BaseUtil {

    private BaseUtil base;

    public NewTReg(BaseUtil base) {
        this.base = base;
    }



    @Given("User is on Newtours register landing page")
    public void userIsOnNewtoursRegisterLandingPage() {

        base.driver.manage().window().maximize();
        base.driver.navigate().to("http://demo.guru99.com/selenium/newtours/register.php");

    }

    @When("User clicks on the Register link")
    public void userClicksOnTheRegisterLink() {

//        base.driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

        NewtoursHomePage newtoursHomePage = new NewtoursHomePage(base.driver);
        newtoursHomePage.clickOnRegisterLink();
    }

    @And("User enters {string},  and  {string} and confirm {string}")
    public void userEntersAndAndConfirm(String userName, String password, String cPassword) {

//        base.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
//        base.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//        base.driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(cPassword);

        NewtoursRegisterPage newtoursRegisterPage= new NewtoursRegisterPage(base.driver);
        newtoursRegisterPage.enterUsername(userName);
        newtoursRegisterPage.enterPassword(password);
        newtoursRegisterPage.enterConfirmPassword(cPassword);

    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() {

//       base.driver.findElement(By.xpath("//input[@name='submit']")).click();

        NewtoursRegisterPage newtoursRegisterPage = new NewtoursRegisterPage(base.driver);
        newtoursRegisterPage.clickOnSubmitButton();
    }


    @Then("confirmation page is displayed with users {string}")
    public void confirmationPageIsDisplayedWithUsers(String userName) {

        NewToursConfirmationPage newToursConfirmationPage=new NewToursConfirmationPage(base.driver);
        assertThat(newToursConfirmationPage.getNoteText().contains(userName),equalTo(true));
    }

    @Then("an error message is displayed {string}")
    public void anErrorMessageIsDisplayed(String errorMsg) {
        assertThat(base.driver.findElement(By.xpath("//span[contains(text(),'does not match')]")).getText(), is(equalTo(errorMsg)));

    }

    @Given("User is on the Newtours website {string}")
    public void userIsOnTheNewtoursWebsite(String url) {

        base.driver.manage().window().maximize();
        base.driver.get(url);
    }

    @And("User enters {string},  and  {string} and enter invalid password {string}")
    public void userEntersAndAndEnterInvalidPassword(String userName, String password, String iPassword) {

        NewtoursRegisterPage newtoursRegisterPage = new NewtoursRegisterPage(base.driver);
        newtoursRegisterPage.enterUsername(userName);
        newtoursRegisterPage.enterPassword(password);
        newtoursRegisterPage.enterConfirmPassword(iPassword);

    }


}
