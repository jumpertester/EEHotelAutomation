package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by cwarren on 11/07/2018.
 */
public class Launcher {

    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/utils/chromedriver.exe");
        return new ChromeDriver();
    }

    public static WebDriver getBrowser(WebDriver driver){
        String baseUrl = ("http://hotel-test.equalexperts.io/");
        driver.get(baseUrl);
        driver.navigate().refresh();
        return driver;
    }
}
