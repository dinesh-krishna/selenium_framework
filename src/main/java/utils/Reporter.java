package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Reporter {
	public ExtentTest test;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	// using the file path
	

	public String testCaseName, testDescription, category, authors;

	public void reportStep(String desc, String status, boolean bSnap) {

		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;

			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.addScreenCaptureFromPath("./../reports/images/"+snapNumber+".jpg");
		}

		// Write if it is successful or failure or information
		if(status.equalsIgnoreCase("PASS")){
			test.log(Status.PASS, desc);
		}else if(status.equalsIgnoreCase("FAIL")){
			test.log(Status.FAIL, desc);
			//throw new RuntimeException("FAILED");
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(Status.WARNING, desc);
		}else if(status.equalsIgnoreCase("INFO")){
			test.log(Status.INFO, desc);
		}

	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	public abstract long takeSnap();


	public ExtentReports startResult(){
		spark = new ExtentSparkReporter("./reports/report.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		//test = extent.startTest(testCaseName, testDescription);
		test=extent.createTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		//extent.endTest(test);
	}



}
