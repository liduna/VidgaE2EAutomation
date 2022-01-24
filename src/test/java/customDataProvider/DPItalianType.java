package customDataProvider;

import org.testng.annotations.DataProvider;

public class DPItalianType {
    //This class provides data for testing of vidga planners "swedish type", that is with only one layer, no pannels
    /** This providers sends data to test case in test class where it is called by "name" of the provider*/


    @DataProvider(name = "browser/ITATypeLocation")
    public static Object [][] getData (){

        Object[][] data= {{"chrome", "https://www.ikea.com/it/it/planners/vidga-planner/"}, {"chrome", "https://www.ikea.com/cz/cs/planners/vidga-planner/"}};
        return data;
    }

}
