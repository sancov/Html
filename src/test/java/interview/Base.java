package interview;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class Base {
    protected static WebDriver driver;
    static long time = 10;


    @BeforeMethod
    public static void beforeMethod() {
        startDriver();
    }

    @AfterMethod
    public static void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static WebDriver startDriver() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/Drivers/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE); // fixes issue with browser keeps on loading, and doesn't allow test to execute
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        return driver;
    }
}
