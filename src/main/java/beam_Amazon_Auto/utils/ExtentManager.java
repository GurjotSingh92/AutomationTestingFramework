package beam_Amazon_Auto.utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
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
