package dataDrivenTesting;

import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TDD_Excel extends BaseUtil {

    ChromeDriver driver;

    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test(dataProvider = "LoginData")  //  initialize LoginData name used in Dataprovider

    public void loginTest(String userName, String pwd, String exp) {
        System.out.println("This is a TEST FOR  " + exp +  "  Test datas");

        //  Username  field
        //  Have stored username element in WebElement  so we can reuse
        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='Email']"));
        txtUserName.clear();
        txtUserName.sendKeys(userName);

//Password field
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        txtPassword.clear();
        txtPassword.sendKeys(pwd);

//  Login button
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

//  After successful login

//  Get expected and actual Page Title
        String expPageTitle = "Dashboard / nopCommerce administration";
        String actPageTitle = driver.getTitle();

// Valid path
        if (exp.equals("Valid"))  //   exp variable declared in Dataprovider is  Valid as we expected it to be.  This loop wont start
        // Then we need to check 2 conditions.  Login Pass  or Fail
        {
            if (expPageTitle.equals(actPageTitle)) {
                driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click(); //  If the expPageTitle.equals(actPageTitle condition is met LOGOUT
                Assert.assertTrue(true); //  then assert
            } else {
                Assert.assertTrue(false);  //   If above conditon not me FAIL assertion

            }


        }
        else if (exp.equals("Invalid"))
        {
            if (expPageTitle.equals(actPageTitle))   //  If this happens then we expecte test to FAIL testing
            {
                driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }

        }


    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() {   //  Object accept all kinds of data
        //   4 combination of data we are passing, so test method will run 4 times
        String loginData[][] = {
                {"admin@yourstore.com", "admin", "Valid" },
                {"admin@yourstore.com", "adm", "Invalid" },
                {"adm@yourstore.com", "admin", "Invalid" },
                {"adm@yourstore.com", "adm", "Invalid" }
        };

        return loginData;
    }

    @AfterClass
    public void tearDown() {
        driver.close();
//        base.driver.quit();
    }
}

