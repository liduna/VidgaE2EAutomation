package pageObjects;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SWE.POSweType;

public class BasePage {

    private static final int TIMEOUT = 15;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    protected void switchToFrame(WebElement element) {
        this.driver.switchTo().frame(element);
    }

    protected void javaScriptExecutorClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("arguments[0].click()", element);
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void navigateToPage(String address) {
        this.driver.get(address);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static class Initializer {
        private WebDriver driver;


        public POSweType startApp(String browser) {


            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");


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
                    System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    this.driver.manage().window().maximize();
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    this.driver.manage().window().maximize();
                    break;

            }
            POSweType vidgaSEtype = new POSweType(driver);
            return vidgaSEtype;


        }


    }
}
