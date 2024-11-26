package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify text in alert")
    public static void VerifyTextFromAlert(String expected){
        String actual = UIActions.getAlertText(popup);
        System.out.println("the actual is: "+ actual);
        UIActions.acceptAlert(popup);
        assertEquals(actual,expected);
    }
    @Step("Verify text in element")
    public static void VerifyTextFromElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        String actual = UIActions.getElemText(elem);
        System.out.println("the actual is: " + actual);
        assertEquals(actual,expected);
    }
    @Step("Verify the number of products after filtering")
    public static void VerifyFilter(WebElement elem, String expected){
        Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
        String[] array = UIActions.getElemText(elem).split(" ");
        String actual = array[0];
        System.out.println("the actual is: "+ actual);
        assertEquals(actual,expected);
    }
    @Step("Verify visibility of elements(Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems){
        for(int i =0; i<elems.size();i++){
            softAssert.assertTrue(elems.get(i).isDisplayed());
        }
        softAssert.assertAll("some of the elements were not displayed");
    }

    @Step("Comparison between two strings")
    public static void VerifyText(String actual, String expected){
        System.out.println(actual);
        assertEquals(actual,expected);
    }
    @Step("Comparison between strings(Soft-Assertion)")
    public static void ComparisonBetweenText(List<String> listActual,List<String> listExpected){
        for(int i =0; i<listExpected.size();i++){
            //Counting the actual list from the end because in the Expected list index[0] is counted from the end
            System.out.println("The Actual String in index " + i +": "+ listActual.get(listActual.size()-1-i));
            System.out.println("The Expected String in index " + i +": "+listExpected.get(i));
            softAssert.assertEquals(listActual.get(listActual.size()-1-i),listExpected.get(i));
        }
        softAssert.assertAll("assertion error");
    }
    @Step("Comparison between two numbers")
    public static void VerifyNumber(int actual, int expected){
        System.out.println(actual);
        assertEquals(actual,expected);
    }
    @Step("Verify if the element is enabled")
    public static void elementEnable(WebElement elem){
        assertTrue(elem.isEnabled());
    }
}