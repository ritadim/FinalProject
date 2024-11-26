package pageObjectS.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Living {
    private AppiumDriver mobileDriver;

    // Initializes the AppiumDriver and sets up page elements
    public Living(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    // Under the category of living, the currency tab
    @AndroidFindBy(xpath = "//*[@id='tab1_layout0']")
    private AndroidElement currency;

    // Currency tab input
    @AndroidFindBy(xpath = "//*[@id='tab1_input']")
    private AndroidElement tabInput;

    // The types of currency to convert to(recyclerview.widget)
    @AndroidFindBy(xpath = "//*[@id='unit_value' and @hidden='false']")
    private List<AndroidElement> currencyUnits;

    // Getter for the 'currency' element
    public AndroidElement getCurrency() {
        return currency;
    }

    // Getter for the 'tabInput' element
    public AndroidElement getTabInput() {
        return tabInput;
    }

    // Getter for the 'currencyUnits' list
    public List<AndroidElement> getCurrencyUnits() {
        return currencyUnits;
    }
}