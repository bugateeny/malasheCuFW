package stepDef;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CucumberHook extends BaseUtil {

    private BaseUtil base;

    public CucumberHook(BaseUtil base) {
        this.base = base;
    }


    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        base.driver = new FirefoxDriver();

    }


    @After
    public void tearDown() {
//        base.driver.close();
        base.driver.quit();
    }
}







//
//    @Parameters("browserName")
//    @BeforeTest
//    public void initialize(String browserName) {
//        System.out.println("browser name is : " + browserName);
//
//        if (browserName.equalsIgnoreCase("chrome")) {
//
//            WebDriverManager.chromedriver().setup();
//            base.driver = new ChromeDriver();
//
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            base.driver = new FirefoxDriver();
//        }
//    }
//
//
//    @AfterTest
//    public void tearDown() {
//        base.driver.close();
////        base.driver.quit();
//
//    }
//}
//
