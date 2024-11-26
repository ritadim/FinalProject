package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;
import java.util.List;

public class MobileActions extends CommonOps {
    @Step("tap on element")
    public static void tap(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        mobileAction.tap((new TapOptions())
                        .withElement(ElementOption.element(elem)))
                .perform();
    }
    @Step("swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        // execute swipe using TouchAction
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    @Step("update text element")
    public static void mobileUpdateText(AndroidElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("click on element")
    public static void mobileClick(AndroidElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("get attribute value")
    public static String attributeValue(AndroidElement elem,String attributeName){
        return elem.getAttribute(attributeName);
    }
    @Step("clicks on every character of a given attribute value, if the value is >=10")
    public static void clickOnEveryCharacter(List<AndroidElement> elems, String Value, String attributeName){
        if(Integer.parseInt(Value)>9){
            for (char character: Value.toCharArray()){
                for (int a = 0; a < elems.size(); a++){
                    if(attributeValue(elems.get(a),attributeName).equals(String.valueOf(character)))
                        mobileClick(elems.get(a));
                    else continue;
                }
            }
        }
        else System.out.println("the given number is less than 10");
    }
    @Step("clicks on element with given attribute value, if the value is <10")
    public static void clickOnElemFromList(List<AndroidElement> elems, String Value, String attributeName){
        for(int i = 0; i < elems.size(); i++){
            if(attributeValue(elems.get(i),attributeName).equals(Value)){
                mobileClick(elems.get(i));
            }
            else continue;
        }
    }
}