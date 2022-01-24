package pageObjects.SWE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.BasePage;

public class POSweType extends BasePage {

    /**
     * THESE ARE INTRODUCTORY ELEMENTS
     */

    @FindBy(id = "f2e60fe1-c4f4-11eb-9eb1-7b097c951065")
    WebElement pageIkeaTitle;

    @FindBy(className = "pub__curated-gallery__item")
    WebElement pictureTitle;

    @FindBy(className = "page-title")
    WebElement pageTitle;

    @FindBy(id = "application-iframe")
    WebElement testFrame;

    @FindBy(id = "vidga-application")
    WebElement prodFrame;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/img")
    WebElement introPicutre;

    @FindBy(css = "#root > div > div.WhatsIncluded_wrapper__17GYG > h3")
    WebElement summary;
    /*******************************/


    /**
     * THESE ARE CLICKABLE ELEMENTS - how to implement swiper??
     */

    @FindBy(id = "add_layer_button")
    WebElement adding_Layer;

    @FindBy(id = "Layer_removeButtonSingleOption__CITWh")
    WebElement removing_Layer;


    @FindBy(id = "next_button_layer_options")//(id = "next_button_layer_options")#next_button_layer_options //*[@id="next_button_layer_options"]
    WebElement btn_next_layer;

    @FindAll({
            @FindBy(className = "inputContainer"),
            @FindBy(className = "WidthInput_WidthInput__31nio")
    })
    WebElement input_field;

    @FindBy(id = "next_button_measurements")
    WebElement btn_next_measurements;

    @FindBy(id = "true")
    WebElement adding_15;


    @FindBy(id = "false")
    WebElement adding_0;

    @FindBy(id = "next_button_addional_measurements")
    //(id = "next_button_addional_measurements")
    WebElement btn_next_additional;

    @FindBy(id = "ceiling")
    WebElement ceiling_picker;

    @FindBy(id = "wall")
    WebElement wallPicker;

    @FindBy(id = "single")
    WebElement singleRailswall;

    @FindBy(id = "wall_6cm")
    WebElement fitting6cm;

    @FindBy(id = "wall_12cm")
    WebElement fitting12cm;

    @FindBy(id = "single_single")
    WebElement singleRailsTwoSpar;

    @FindBy(id = "triple_single")
    WebElement threeRails;

    @FindBy(id = "white")
    WebElement colourPicker;

    /*********************/

    @FindBy(xpath = "/html/body/iframe")
    WebElement silentFrame;


    /**
     * constructor of a super class
     */

    public POSweType(WebDriver driver) {
        super(driver);
    }


    /**
     * This is nested class that is taking care of initializing driver
     */


    /**
     * INTRODUCTORY METHODS
     */

    public String getAddres(String address) {
        return address;
    }

    /*
           public void setAddress(String address) {
            this.pageAddress = address;
        }
    */
    public void verifyPage() {
        waitForElementToAppear(By.className("page-title"));
        Assert.assertTrue(pageTitle.isDisplayed());

        waitForElementToAppear(By.id("vidga-application"));
        switchToFrame(prodFrame);
        waitForElementToAppear(By.xpath("//*[@id='root']/div/div[1]/img"));
        Assert.assertTrue(introPicutre.isDisplayed());

    }


    public void verifyIsPresent() {
        waitForElementToAppear(By.id("next_button_layer_options"));
        Assert.assertTrue(btn_next_layer.isDisplayed());
        System.out.println("next is displayed");
    }

    /**
     * INTERCEPTING ELEMENTS METHODS
     */

    public void addLayer() {
        waitForElementToBeClickable(By.id("add_layer_button"));
        javaScriptExecutorClick(adding_Layer);
        waitForElementToAppear(By.id("next_button_layer_options"));
        javaScriptExecutorClick(btn_next_measurements);

    }

    public void confirmMeasurementsNoInput() {
        waitForElementToAppear(By.id("next_button_measurements"));

        Assert.assertTrue(btn_next_measurements.isDisplayed());

    }

    public void add15CM() {

        javaScriptExecutorClick(adding_15);
        Assert.assertTrue(adding_15.isSelected());

        javaScriptExecutorClick(btn_next_additional);


    }

    public void chooseCeiling() {
        javaScriptExecutorClick(ceiling_picker);

    }

    public WebElement getSummary() {
        return summary;
        //waitForElementToAppear(By.cssSelector("#root > div > div.WhatsIncluded_wrapper__2Y0in > h3"));

    }

    public void switchToSilentFrame() {
        switchToFrame(silentFrame);

    }

}
