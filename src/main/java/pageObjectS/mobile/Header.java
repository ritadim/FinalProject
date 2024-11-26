package pageObjectS.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Header {
    private AppiumDriver mobileDriver;

    // Initializes the AppiumDriver and sets up page elements
    public Header(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    // Encouraging upgrade popup button - NOT NOW
    @AndroidFindBy(xpath = "//*[@id='button2']")
    private AndroidElement notNow;

    // Encouraging upgrade popup button - OK
    @AndroidFindBy(xpath = "//*[@text='OK']")
    private AndroidElement OK;

    // All options in the header of the app
    @AndroidFindBy(xpath = "//*[@id='title']")
    private List<AndroidElement> titles;

    // The 'Living' option
    @AndroidFindBy(xpath = "//*[@text='LIVING']")
    private AndroidElement livingTitle;

    // Getter for the 'notNow' element
    public AndroidElement getNotNow() {
        return notNow;
    }

    // Getter for the 'OK' element
    public AndroidElement getOK() {
        return OK;
    }

    // Getter for the 'titles' list
    public List<AndroidElement> getTitles() {
        return titles;
    }

    // Getter for the 'livingTitle' element
    public AndroidElement getLivingTitle() {
        return livingTitle;
    }
}
