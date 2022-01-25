package tests.testSWE;

import customDataProvider.DataSWE;
import driverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.SWE.SWEType;


public class TestBasicSWE {


    /**
     * in the brackets there is allocation of dataProvider, specified by name and class, which fetches the data for the test
     */
    /** I initialize the initializer here*/

    DriverFactory browser = new DriverFactory();
    SWEType vidgaSE;

    @Test(dataProvider = "edge/SWETypeLocation", dataProviderClass = DataSWE.class)
    public void first_test_Swedish_Live(String browserName, String address) {

        /** Here I initialize objects and pass parameters*/
        vidgaSE = new SWEType(browser.getBrowser(browserName));
        vidgaSE.navigateToPage(address);

        /** here is the testcase itself*/

        vidgaSE.verifyOnPage();
        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.chooseCeiling();

        /** assertion */

        Assert.assertTrue(vidgaSE.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");


    }

    @Test(dataProvider = "chrome/SWETypeLocation", dataProviderClass = DataSWE.class)
    public void parameterizedSWE(String browserName, String address) {


        vidgaSE = new SWEType(browser.getBrowser(browserName));
        vidgaSE.navigateToPage(address);

        vidgaSE.verifyOnPage();

        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.chooseCeiling();

        Assert.assertTrue(vidgaSE.getSummary().isDisplayed());
        System.out.println("Summary of the products is displayed");


    }
/**this method executes after each test method and closes the browser*/
    @AfterMethod
    public void afterMethod() {
        vidgaSE.closeBrowser();
    }
}
