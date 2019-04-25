package amazonAutoTestingFramework.utils;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	
	public static class ExtentManager {
		static String userDir = System.getProperty("user.dir");
		
	    private static ExtentReports extent;
	    
	    public synchronized static ExtentReports getReporter() {
	    	if(extent==null) {
	    		extent=new ExtentReports(
	    				"ExtentReports/Suite_Report_" + "beamAuto" + "_" + ".html",
	    				true);
	    	}
	    	return extent;
	    }

	}
	
    static Map extentTestMap = new HashMap(); //An extentTestMap map is created. It holds the information of thread ids and ExtentTest instances.
    static ExtentReports extent = ExtentManager.getReporter(); //ExtentReports instance is created by calling getReporter() method from ExtentManager.
    
    //an instance of ExtentTest created and put into extentTestMap with current thread id.
    public static synchronized ExtentTest startExtentTest(String testName, String desc) {
    	ExtentTest test = extent.startTest(testName, desc);
    	extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    //returns ExtentTest instance in extentTestMap by using current thread id.
    public static synchronized ExtentTest getExtentTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    
    //test ends and ExtentTest instance got from extentTestMap via current thread id.
    public static synchronized void endExtentTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

}
