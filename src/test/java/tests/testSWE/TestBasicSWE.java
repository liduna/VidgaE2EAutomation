package tests.testSWE;

import customDataProvider.DataSWE;
import driverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.SWE.SWEType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestBasicSWE {


    /**
     * in the brackets there is allocation of dataProvider, specified by name and class, which fetches the data for the test
     */
    /**
     * I initialize the initializer here
     */

    DriverFactory browser = new DriverFactory();
    SWEType vidgaSE;

    @Test(dataProvider = "edge/SWETypeLocation", dataProviderClass = DataSWE.class)
    public void first_test_Swedish_Live(String browserName, String address) throws InterruptedException {

        /** Here I initialize objects and pass parameters*/
        vidgaSE = new SWEType(browser.getBrowser(browserName));
        vidgaSE.navigateToPage(address);
        vidgaSE.ClearBrowserCache();


        /** here is the testcase itself*/

        vidgaSE.verifyRightPage();
        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.clickNextAdditional();
        vidgaSE.chooseCeiling();


        /** assertion */


        String price = vidgaSE.getSummary().getText();
        System.out.println(price);
        Assert.assertEquals(vidgaSE.verifySummaryIsPresent(price), false, "summary is zero or is not displayed");


    }
    @Test(dataProvider = "chrome/SWETypeLocation", dataProviderClass = DataSWE.class)
    public void browserParamSWEType(String browserName, String address) throws InterruptedException {

        /** Here I initialize objects and pass parameters*/
        vidgaSE = new SWEType(browser.getBrowser(browserName));
        vidgaSE.navigateToPage(address);
        vidgaSE.ClearBrowserCache();


        /** here is the testcase itself*/

        vidgaSE.verifyRightPage();
        vidgaSE.addLayer();
        vidgaSE.confirmMeasurementsNoInput();
        vidgaSE.add15CM();
        vidgaSE.clickNextAdditional();
        vidgaSE.chooseCeiling();


        /** assertion */


        String price = vidgaSE.getSummary().getText();
        System.out.println(price);
        Assert.assertEquals(vidgaSE.verifySummaryIsPresent(price), false, "summary is zero or is not displayed");


    }




/**this method executes after each test method and closes the browser*/
    @AfterMethod
    public void afterMethod()  {
        vidgaSE.closeBrowser();

    }
}
