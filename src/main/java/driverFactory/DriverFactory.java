package driverFactory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private WebDriver driver;

    /** in main thare are helper classes (such as driver factory) and page object classes, that is those, that are not
     * directly connected to tests*/

    public WebDriver getBrowser(String browser) {


        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");


                String headless = System.getProperty("headless");

                ChromeDriverManager.chromedriver();
                if ("true".equals(headless)) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                } else {
                    driver = new ChromeDriver();
                }
                this.driver.manage().window().maximize();

                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
                driver = new FirefoxDriver();
                this.driver.manage().window().maximize();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\bin\\msedgedriver.exe");
                driver = new EdgeDriver();
                this.driver.manage().window().maximize();
                break;

        }


        return driver;

    }

}
