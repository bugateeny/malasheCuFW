package dataDrivenTesting;

import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestNGHook extends BaseUtil {

    private BaseUtil base;

    public TestNGHook(BaseUtil base) {
        this.base = base;
    }


    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
        base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        base.driver.manage().window().maximize();

//        WebDriverManager.firefoxdriver().setup();
//        base.driver = new FirefoxDriver();

    }


    @AfterClass
    public void tearDown() {
        base.driver.close();
//        base.driver.quit();
    }
}

