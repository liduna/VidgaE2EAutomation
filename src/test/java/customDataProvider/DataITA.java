package customDataProvider;

import org.testng.annotations.DataProvider;

public class DataITA {
    //This class provides data for testing of vidga planners "swedish type", that is with only one layer, no pannels
    /** This providers sends data to test case in test class where it is called by "name" of the provider*/


    @DataProvider(name = "chrome/ITATypeLocation")
    public static Object [][] getChrome_ITA (){

        Object[][] data= {{"chrome", "https://www.ikea.com/it/it/planners/vidga-planner/"}, {"chrome", "https://www.ikea.com/cz/cs/planners/vidga-planner/"}};
        return data;
    }
    @DataProvider(name = "edge/ITATypeLocation")
    public static Object [][] getEdge_ITA (){

        Object[][] data= {{"edge", "https://www.ikea.com/it/it/planners/vidga-planner/"}, {"edge", "https://www.ikea.com/cz/cs/planners/vidga-planner/"}};
        return data;
    }
}
