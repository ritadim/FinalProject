package pageObjectS.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NumbersTab {
    private AppiumDriver mobileDriver;

    // Initializes the AppiumDriver and sets up page elements
    public NumbersTab(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    // Numeric keyboard from 7 to .
    @AndroidFindBy(xpath = "//*[contains(@id,'tab1_num')]")
    private List<AndroidElement> numKeyboard;

    // Arithmetic operations on the keyboard (from / to +)
    @AndroidFindBy(xpath = "//*[contains(@id,'tab1_4')]")
    private List<AndroidElement> operations;

    // Getter for the 'numKeyboard' list
    public List<AndroidElement> getNumKeyboard() {
        return numKeyboard;
    }

    // Getter for the 'operations' list
    public List<AndroidElement> getOperations() {
        return operations;
    }
}