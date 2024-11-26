package pageObjectS.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Sizes {

    // The title of the sizes section
    @FindBy(css = "h4[class*='jepTHo']")
    private WebElement TitleSizes;

    // List of all available size options with checkmarks
    @FindBy(xpath = "//label/span[@class='checkmark']")
    private List<WebElement> allSizes;

    // Getter for 'TitleSizes'
    public WebElement getTitleSizes() {
        return TitleSizes;
    }

    // Getter for 'allSizes'
    public List<WebElement> getAllSizes() {
        return allSizes;
    }
}