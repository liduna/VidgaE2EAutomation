package customDataProvider;

import org.testng.annotations.DataProvider;

public class DataSWE {

    //This class provides data for testing of vidga planners "swedish type", that is with only one layer, no pannels
    /** This providers sends data to test case in test class where it is called by "name" of the provider*/


    @DataProvider (name = "chrome/SWETypeLocation")
    public static Object [][] getChrome_SweType (){

        Object[][] data= {{"chrome", "https://www.ikea.com/se/sv/planners/vidga-planner/"}, {"chrome", "https://www.ikea.com/au/en/planners/vidga-planner/"}};
        return data;
    }

    @DataProvider (name = "edge/SWETypeLocation")
    public static Object [][] getEdge_SweType (){

        Object[][] data= {{"edge", "https://www.ikea.com/se/sv/planners/vidga-planner/"}, {"edge", "https://www.ikea.com/au/en/planners/vidga-planner/"}};
        return data;
    }

    @DataProvider (name = "firefox/SWETypeLocation")
    public static Object [][] getFirefox_SweType (){

        Object[][] data= {{"firefox", "https://www.ikea.com/se/sv/planners/vidga-planner/"}, {"firefox", "https://www.ikea.com/au/en/planners/vidga-planner/"}};
        return data;
    }


}
