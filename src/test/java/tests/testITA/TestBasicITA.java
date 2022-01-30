package tests.testITA;

import customDataProvider.DataITA;
import driverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.ITA.ITAType;

import static org.testng.Assert.assertTrue;


public class TestBasicITA {

/** here I create class variables */
    DriverFactory browser = new DriverFactory();
    ITAType vidgaIT;

    @Test(dataProvider = "edge/ITATypeLocation", dataProviderClass = DataITA.class)
    public void testAddPanel1(String browserName, String address) {

        vidgaIT = new ITAType(browser.getBrowser(browserName));
        vidgaIT.navigateToPage(address);
    }

    /**
     * this is a problem since these element dont have their ID's. Necessary to implement ASAP
     */

    @Test(dataProvider = "edge/ITATypeLocation", dataProviderClass = DataITA.class)
    public void testAddPanel2(String browserName, String address) {

        vidgaIT = new ITAType(browser.getBrowser(browserName));
        vidgaIT.navigateToPage(address);


        vidgaIT.verifyPage();
        vidgaIT.selectPanelOnSecond();
    }


    @Test(dataProvider = "chrome/ITATypeLocation", dataProviderClass = DataITA.class)
    public void first_test_Italian_Live(String browserName, String address) {


        vidgaIT = new ITAType(browser.getBrowser(browserName));
        vidgaIT.navigateToPage(address);
        vidgaIT.verifyPage();

        vidgaIT.addLayer();
        vidgaIT.confirmMeasurementsNoInput();
        vidgaIT.add15CM();
        vidgaIT.chooseCeiling();
        vidgaIT.chooseWhite();

        assertTrue(vidgaIT.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");

    }

    @Test(dataProvider = "chrome/ITATypeLocation", dataProviderClass = DataITA.class)
    public void dropDown_test_Italian_Live(String browserName, String address) {

        vidgaIT = new ITAType(browser.getBrowser(browserName));
        vidgaIT.navigateToPage(address);
        vidgaIT.verifyPage();

        vidgaIT.selectPanelOnFirst();
        vidgaIT.confirmMeasurementsNoInput();
        vidgaIT.add15CM();
        vidgaIT.chooseCeiling();
        vidgaIT.choosTripleRailings();
        vidgaIT.chooseWhite();

        assertTrue(vidgaIT.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");
    }

    @AfterMethod
    public void afterMethod() {
        vidgaIT.closeBrowser();
    }

}



