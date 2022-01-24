package tests.testSWE;

import customDataProvider.DPswedishType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.SWE.POSweType;


public class TestBasicSWE {


    /**
     * in the brackets there is allocation of dataProvider, specified by name and class, which fetches the data for the test
     */
    /** I initialize the initlializer here*/

    POSweType.Initializer browser = new POSweType.Initializer();
    POSweType vidgaSE;

    @Test(dataProvider = "edge/SWETypeLocation", dataProviderClass = DPswedishType.class)
    public void first_test_Swedish_Live(String browserName, String address) {

        /** Here I initialize objects and pass parameters*/

        vidgaSE = browser.startApp(browserName);

        vidgaSE.navigateToPage(vidgaSE.getAddres(address));
        vidgaSE.verifyPage();

        /** here is the testcase itself*/

        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.chooseCeiling();

        /** assertion */

        Assert.assertTrue(vidgaSE.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");

        //  vidgaSE.closeBrowser();

    }

    @Test(dataProvider = "chrome/SWETypeLocation", dataProviderClass = DPswedishType.class)
    public void parameterizedSWE(String browserName, String address) {


        vidgaSE = browser.startApp(browserName);

        vidgaSE.navigateToPage(vidgaSE.getAddres(address));
        vidgaSE.verifyPage();

        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.chooseCeiling();

        Assert.assertTrue(vidgaSE.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");


    }

    @AfterMethod
    public void afterMethod() {
        vidgaSE.closeBrowser();
    }
}
