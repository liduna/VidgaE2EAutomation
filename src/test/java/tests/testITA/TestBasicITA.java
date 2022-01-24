package tests.testITA;

import customDataProvider.DPItalianType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pageObjects.ITA.POItalyType;


public class TestBasicITA {


    POItalyType.Initializer browser = new POItalyType.Initializer();
    POItalyType vidgaIT;


    @Test(dataProvider = "browser/ITATypeLocation", dataProviderClass= DPItalianType.class)
    public void testAddPanel1(String browserName, String address){

        vidgaIT = browser.startApp(browserName);

        vidgaIT.navigateToPage(vidgaIT.getAddres(address));
        vidgaIT.verifyPage();
        vidgaIT.selectPanelOnFirst();



    }

    /**this is a problem since these element dont have their ID's. Necessary to implement ASAP
     *
     */
    @Test(dataProvider = "browser/ITATypeLocation", dataProviderClass= DPItalianType.class)
    public void testAddPanel2(String browserName, String address){
       // POItalyType.Initializer browser = new POItalyType.Initializer();
        vidgaIT = browser.startApp(browserName);
        vidgaIT.navigateToPage(vidgaIT.getAddres(address));
        vidgaIT.verifyPage();

        vidgaIT.selectPanelOnSecond();
    }


    @Test(dataProvider = "chrome/ITATypeLocation", dataProviderClass= DPItalianType.class)
    public void first_test_Italian_Live(String browserName, String address) {


       // POItalyType.Initializer init = new POItalyType.Initializer();
         vidgaIT = browser.startApp(browserName);

        vidgaIT.navigateToPage(vidgaIT.getAddres(address));
        vidgaIT.verifyPage();

        vidgaIT.addLayer();
        vidgaIT.confirmMeasurementsNoInput();
        vidgaIT.add15CM();
        vidgaIT.chooseCeiling();
        vidgaIT.chooseWhite();

        Assert.assertTrue(vidgaIT.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");

    }

    @Test(dataProvider = "chrome/ITATypeLocation", dataProviderClass= DPItalianType.class)
    public void dropDown_test_Italian_Live(String browserName, String address) {


      //  POItalyType.Initializer browser = new POItalyType.Initializer();
        vidgaIT = browser.startApp(browserName);

        vidgaIT.navigateToPage(vidgaIT.getAddres(address));
        vidgaIT.verifyPage();

        vidgaIT.selectPanelOnFirst();
        vidgaIT.confirmMeasurementsNoInput();
        vidgaIT.add15CM();
        vidgaIT.chooseCeiling();
        vidgaIT.choosTripleRailings();
        vidgaIT.chooseWhite();

        Assert.assertTrue(vidgaIT.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");
    }


    @AfterMethod
    public void afterMethod() {
        vidgaIT.closeBrowser();
    }
}

