package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Base Page is a super class which contains methods fundamental for all page objects
 * that are to be created. Other page objects inherit from this class (for example the initialization
 * of the PageFactory*/

public abstract class BasePage {

    private static final int TIMEOUT = 15;

    private WebDriver driver;
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
        this.driver.quit();
    }


}