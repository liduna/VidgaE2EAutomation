package pageObjects.ITA;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ITAType extends BasePage {

    //private String PAGE_ADDRESS_ITA = "https://www.ikea.com/it/it/planner/vidga-planner//";

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
    WebElement single_railing;

    @FindBy(id = "wall_6cm")
    WebElement fitting6cm;

    @FindBy(id = "wall_12cm")
    WebElement fitting12cm;

    @FindBy(id = "single_single")
    WebElement single_single_railing;

    @FindBy(id = "triple")
    WebElement triple_railing;

    @FindBy(id = "white")
    WebElement white_Picker;

    /** THESE ARE SPECIFIC ITALIAN CLICKABLE BUTTONS*/
    /*********************/

    @FindBy(id = "silver")
    WebElement silver_picker;
    /*
        @FindBy (css = "#root > div > div.Layer_wrapper__3hCrJ > div > div:nth-child(1) > ikea-component > div > div.Dropdown__button")//#root > div > div.Layer_wrapper__3hCrJ > div > div:nth-child(2) > ikea-component > div > div.Dropdown__button
        WebElement drop_down_btn;
    */
    @FindBy(className = "Dropdown__button")
    WebElement drop_down_btn;

    @FindBy(className = "dropdown-option")//#root > div > div.Layer_wrapper__3hCrJ > div > div:nth-child(2) > ikea-component > div > div.Dropdown__list
    WebElement drop_down_list;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/ikea-component/div/div[2]/ikea-component/div/div[1]/div[1]/div/ikea-component-body/ikea-component-body/dropdown-option[1]")
    WebElement curtains;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/ikea-component/div/div[1]/span/div")
    WebElement first_layer_dropdown;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/ikea-component/div/div[1]/span/div")
    WebElement second_layer_dropdown;


    ////*[@id="root"]/div/div[1]/div/div[1]/ikea-component/div/div[1]/span/div
    //   //*[@id="root"]/div/div[1]/div/div[2]/ikea-component/div/div[1]/span/div

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/ikea-component/div/div[2]/ikea-component/div/div[1]/div[1]/div/ikea-component-body/ikea-component-body/dropdown-option[2]")
    WebElement panels;


    /**
     * INTRODUCTORY METHODS
     */

    public ITAType(WebDriver driver) {
        super(driver);
    }




    public void verifyPage() {
        waitForElementToAppear(By.className("page-title"));
        System.out.println("title is displayed");
        waitForElementToAppear(By.id("vidga-application"));
        switchToFrame(prodFrame);
        waitForElementToAppear(By.xpath("//*[@id='root']/div/div[1]/img"));

        if ((introPicutre.isDisplayed())) {
            System.out.println("picture");
        }
    }


    public void verifyIsPresent() {
        waitForElementToAppear(By.id("next_button_layer_options"));

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
        if (btn_next_measurements.isDisplayed()) {
            System.out.println("next Measurements");
        }

    }

    public void add15CM() {

        javaScriptExecutorClick(adding_15);

        System.out.println("adding 15 cm");
        javaScriptExecutorClick(btn_next_additional);
    }

    public void chooseCeiling() {
        javaScriptExecutorClick(ceiling_picker);

    }

    public WebElement getSummary() {
        return summary;
    }

    public void choosTripleRailings() {
        javaScriptExecutorClick(triple_railing);

        //triple_railing.click();
    }


    /**
     * METHODS TYPICAL FOR ITALY ET ALL: -PANELS,SILVER
     *****/

    public void selectPanelOnFirst() {
        waitForElementToBeClickable(By.id("add_layer_button"));
        javaScriptExecutorClick(adding_Layer);
        javaScriptExecutorClick(drop_down_btn);

        //javaScriptExecutorClick(dropDown2);
        waitForElementToBeClickable(By.xpath
                ("//*[@id=\"root\"]/div/div[1]/div/div[1]/ikea-component/div/div[2]/" +
                        "ikea-component/div/div[1]/div[1]/div/ikea-component-body/ikea-component-body/dropdown-option[2]"));
        //panels.click();
        javaScriptExecutorClick(panels);
        System.out.println(panels.getText());


        waitForElementToAppear(By.id("next_button_layer_options"));
        javaScriptExecutorClick(btn_next_measurements);


    }

    public void selectPanelOnSecond() {
        waitForElementToBeClickable(By.id("add_layer_button"));
        javaScriptExecutorClick(drop_down_btn);

        //javaScriptExecutorClick(dropDown2);
        waitForElementToBeClickable(By.xpath
                ("//*[@id=\"root\"]/div/div[1]/div/div[1]/ikea-component/div/div[2]/" +
                        "ikea-component/div/div[1]/div[1]/div/ikea-component-body/ikea-component-body/dropdown-option[2]"));
        panels.click();
        System.out.println(panels.getText());
        javaScriptExecutorClick(adding_Layer);


        waitForElementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/ikea-component/div/div[1]/span/div"));
        second_layer_dropdown.click();


        waitForElementToAppear(By.id("next_button_layer_options"));
        javaScriptExecutorClick(btn_next_measurements);

    }

    public void chooseSilver() {
        javaScriptExecutorClick(silver_picker);

    }

    public void chooseWhite() {
        javaScriptExecutorClick(white_Picker);

    }


}
