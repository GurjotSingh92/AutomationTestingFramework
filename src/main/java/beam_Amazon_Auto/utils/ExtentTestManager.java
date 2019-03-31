package beam_Amazon_Auto.utils;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	
    static Map extentTestMap = new HashMap(); //An extentTestMap map is created. It holds the information of thread ids and ExtentTest instances.
    static ExtentReports extent = ExtentManager.getReporter(); //ExtentReports instance is created by calling getReporter() method from ExtentManager.
    
    //an instance of ExtentTest created and put into extentTestMap with current thread id.
    public static synchronized ExtentTest startTest(String testName, String desc) {
    	ExtentTest test = extent.startTest(testName, desc);
    	extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    //returns ExtentTest instance in extentTestMap by using current thread id.
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    
    //test ends and ExtentTest instance got from extentTestMap via current thread id.
    public static synchronized void endTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
    
   

}
