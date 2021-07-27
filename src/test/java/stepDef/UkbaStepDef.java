package stepDef;

import base.BaseUtil;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UkbaStepDef extends BaseUtil {

    private BaseUtil base;

    public UkbaStepDef(BaseUtil base) {
        this.base = base;
    }


    @Given("User is on the UKBA website")
    public void user_is_on_the_ukba_website() {

        // Write code here that turns the phrase above into concrete actions
        base.driver.manage().window().maximize();
        base.driver.navigate().to("https://www.gov.uk/check-uk-visa/y");
//Assertion
        Object base2 = base.driver.getTitle().equals("What’s your nationality as shown on your passport or travel document? - Check if you need a UK visa - GOV.UK");
        System.out.println("Page title is  :" + base2);


    }

    @When("User chooses {string} nationality")
    public void user_chooses_nationality(String countryName)  //  Add name here make it a dynamic name

    {
        Select select = new Select(base.driver.findElement(By.id("response")));  //  SELECT method to be called when find elements inside Select tags
//        select.selectByVisibleText("Japan"); // Instead of hardcoding Japan.   Variable name Country name is use, this allow country to be dynmaic in feature file
        select.selectByVisibleText(countryName);

//        driver.findElement(By.xpath("//option[contains(text(),'Japan')]")).click();
    }

    @And("User clicks on Continue button")
    public void user_clicks_on_continue_button() {

        base.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

    }

    @And("User selects the {string}  as reason for coming to UK")
    public void user_selects_the_as_reason_for_comig_to_uk(String string) {
        base.driver.findElement(By.xpath("//label[contains(text(),'Study')]")).click();

        //  Continue method re-used so no need to right another continue method

    }

    @And("User chooses option of longer than {int} months")
    public void user_chooses_option_of_longer_than_months(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        base.driver.findElement(By.xpath("//label[contains(text(),'longer than 6 months')]")).click();

        //  Continue method re-used so no need to right another continue method
    }

    @Then("User should be informed that {string}")
    public void user_should_be_informed_that(String msg) throws IOException {
        // Write code here that turns the phrase above into concrete actions

        assertThat(base.driver.
                findElement(By.xpath("//h2[contains(text(),'You’ll need a visa to study in the UK')]"))
                .getText(), is(equalTo(msg)));

        File scrFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
// Code to copy the screenshot in the desired location
        FileUtils.copyFile(scrFile, new File("images\\screenshots.jpg"));



    }


}

