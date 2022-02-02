package pageObjects.SWE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

/**
 * This is the page object for the Swedish type of page - with only one type of layer and
 * whit components only. This page object class contains all the elements that are on the page
 * and methods that can be performed on them
 */


public class SWEType extends BasePage {

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

    /*@FindAll({
            @FindBy(className="IKEA__price-amount"),
            @FindBy(xpath="//*[@id=\"root\"]/div/div[8]/div/div/ikea-component/div/div[1]/ikea-component/div/div[2]/b/span/span/span")
    })
    WebElement summary;*/

    @FindBy(className = "Checkout__total-price")         //   //*[@id="root"]/div/div[8]/div/div/ikea-component/div/div[1]/ikea-component/div/div[2]/b/span/span/span      //"Checkout__total-price")  //css #root > div > div.WhatsIncluded_wrapper__17GYG > h3 //WhatsIncluded_whatsIncluded__2XDbC  //WhatsIncluded__item-total-price
    WebElement summary;


    @FindBy(className = "AddToBag__button AddToBag__button--cart")//Checkout__add-to-bag
    WebElement cartButton;


    /**
     * THESE ARE CLICKABLE ELEMENTS
     */

    @FindBy(id = "add_layer_button")
    WebElement adding_Layer;

    @FindBy(id = "Layer_removeButtonSingleOption__CITWh")
    WebElement removing_Layer;


    @FindBy(id = "next_button_layer_options")//(id = "next_button_layer_options")#next_button_layer_options //*[@id="next_button_layer_options" className Layer_nextButton__2iohh]
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


    @FindBy(xpath = "/html/body/iframe")
    WebElement silentFrame;


    /**
     * constructor of the class
     */

    public SWEType(WebDriver driver) {
        super(driver);
    }


    /**
     * INTRODUCTORY METHODS
     */

    public String getAddres(String address) {
        return address;
    }


    public void verifyRightPage() {
        waitForElementToAppear(By.className("page-title"));
        waitForElementToAppear(By.id("vidga-application"));
        switchToFrame(prodFrame);
        waitForElementToAppear(By.xpath("//*[@id='root']/div/div[1]/img"));

    }


    /**
     * INTERCEPTING ELEMENTS METHODS
     */

    public void addLayer() {
        waitForElementToBeClickable(By.id("add_layer_button"));
        adding_Layer.click();
        //waitForElementToBeClickable(adding_Layer);
        // javaScriptExecutorClick(adding_Layer);


    }

    public void confirmLayer() {

        // waitForElementToBeClickable(btn_next_layer);
        //btn_next_layer.click();
        waitForElementToBeClickable(By.id("next_button_layer_options"));
        javaScriptExecutorClick(btn_next_layer);


    }


    public void confirmMeasurementsNoInput() {
        ///waitForElementToBeClickable(btn_next_measurements);

        waitForElementToBeClickable(By.id("next_button_measurements"));
        btn_next_measurements.click();
        // javaScriptExecutorClick(btn_next_measurements);


    }

    public void add15CM() {
        //adding_15.click();
        //waitForElementToBeClickable(By.id("true"));
        javaScriptExecutorClick(adding_15);
    }

    public void clickNextAdditional(){
        javaScriptExecutorClick(btn_next_additional);
    }
    public void chooseCeiling() {
        javaScriptExecutorClick(ceiling_picker);

    }

    public WebElement getSummary() {
        //waitForElementToAppear(By.className("IKEA__price-amount"));
        return summary;
        //waitForElementToAppear(By.cssSelector("#root > div > div.WhatsIncluded_wrapper__2Y0in > h3"));

    }

    public WebElement getPageIkeaTitle() {

        return this.pictureTitle;
        //waitForElementToAppear(By.cssSelector("#root > div > div.WhatsIncluded_wrapper__2Y0in > h3"));

    }

    public WebElement getCartButton() {

        return cartButton;
    }

    public boolean verifySummaryIsPresent(String price) {
        return price.equals("0") || price.contains("0.00") || price.equals("0:-") || price.isEmpty() || price.contains("(0:-");

    }

    public void switchToSilentFrame() {
        switchToFrame(silentFrame);

    }


}
