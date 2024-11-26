package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    // Method name: onStart
    // Method description: Invoked after the test class is instantiated and before any configuration method is called
    public void onStart(ITestContext context) {
        System.out.println("Starting execution ");
    }

    // Method name: onFinish
    // Method description: Invoked after all the tests have run and all their Configuration methods have been called
    public void onFinish(ITestContext context) {
        System.out.println("Finish execution");
    }

    // Method name: onTestStart
    // Method description: Invoked each time before a test will be invoked.
    public void onTestStart(ITestResult test) {
        System.out.println("----------New Test Started--------" + test.getName());
    }
    // Method name: onTestSuccess
    // Method description: Invoked each time a test succeeds.
    public void onTestSuccess(ITestResult test) {
        System.out.println("---------Test:" + test.getName() + " Passed------------");
        if(!platform.equalsIgnoreCase("api")){
            // stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // delete recorded file
            File file = new File("C:/Automation/FinalProject/test-recordings/"+ test.getName()+".avi");
            if(file.delete()){
                System.out.println("File Deleted Successfully");
            }
            else {
                System.out.println("Failed To Delete File");
            }
        }
    }

    // Method name: onTestFailure
    // Method description: Invoked each time a test fails.
    public void onTestFailure(ITestResult test) {
        System.out.println("---------Test:" + test.getName() + " Failed------------");
        if(!platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    // Method name: onTestSkipped
    // Method description: Invoked each time a test is skipped.
    public void onTestSkipped(ITestResult test) {
        System.out.println("----------skipped test---------" + test.getName());
    }
    // Method name: onTestFailedButWithinSuccessPercentage
    // Method description: Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.
    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("onTestFailedButWithinSuccessPercentage" + test.getName());
    }

    // Method name: saveScreenshot
    // Method description:this method is captures and saves a screenshot
    // Method return: byte[](which is an array of bytes)
    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot(){
        if(!platform.equalsIgnoreCase("mobile")){
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
        else {
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
        }
    }
}
