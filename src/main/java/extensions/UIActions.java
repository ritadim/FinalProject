package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("click on element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("update text element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("click on element on select")
    public static void updateDrop(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select select = new Select(elem);
        select.selectByVisibleText(text);
    }
    @Step("clear filed")
    public static void clearFiled(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }
    @Step("gets the element text")
    public static String getElemText(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getText();
    }
    @Step("clicks accept on a popup")
    public static void acceptAlert(Alert popup){
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        popup.accept();
    }
    @Step("switching to popup")
    public static void switchToPopup(){
        popup = driver.switchTo().alert();
    }
    @Step("click dismiss on a popup")
    public static void cancelAlert(Alert popup){
        popup.dismiss();
    }
    @Step("sending text to alert")
    public static void sendTextToAlert(Alert popup,String text){
        popup.sendKeys(text);
    }
    @Step("gets the popup text")
    public static String getAlertText(Alert popup){
        return popup.getText();
    }
    @Step("clicks on all elements in the list and clicks on another element after every click ")
    public static void clickOnElems(List<WebElement> elems,WebElement elem){
        for(int i = 0; i< elems.size(); i++){
            click(elems.get(i));
            click(elem);
        }
    }

    @Step("clicks on all elements in the list")
    public static void clickOnAll(List<WebElement> elems){
        for(int i =0; i< elems.size(); i ++){
            click(elems.get(i));
        }
    }
    @Step("clicks on all elements in the list from the end")
    public static void clickOnAllFromEnd(List<WebElement> elems){
        for(int i = elems.size()-1; i> -1; i--){
            click(elems.get(i));
        }
    }
    @Step("mouse hover and click on element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
        action.moveToElement(elem1).moveToElement(elem2).click(elem2).build().perform();
    }

    @Step("click on the down arrow as many times as defined")
    public static void arrowDownClick(int numberOfClicks){
        for(int i = 0; i < numberOfClicks; i++) {
            action.sendKeys(Keys.ARROW_DOWN);
        }
        action.build().perform();
        Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
    }
    @Step("click on predefined number of elements in the list")
    public static void clickOnElemsFromList(List<WebElement> elems, int numOfClicks){
        for(int i = 0; i< numOfClicks; i++){
            click(elems.get(i));
            Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
        }
    }
    @Step("returns the index of the relevant element from the list, based on the data received")
    public static int numberOfElem(List<WebElement> elems,String data){
        int a = 0;
        for(int i = 0 ;i < elems.size(); i ++) {
            if (getElemText(elems.get(i)).equalsIgnoreCase(data))
                a += i;
            else continue;
        }
        return a;
    }
    @Step("returns the texts of the elements in the list (as List<String>)")
    public static List<String> getTextOfElems(List<WebElement> elems){
        List<String> list = new ArrayList<String>();
        for(int i = 0; i< elems.size(); i++){
            list.add(getElemText(elems.get(i)));
        }
        return list;
    }

    @Step("mouse hover to element")
    public static void mouseHover(WebElement elem1){
        //Uninterruptibles.sleepUninterruptibly(Long.parseLong(getData("Timeout02")), TimeUnit.SECONDS);
        action.moveToElement(elem1).click(elem1).build().perform();
    }
    @Step("clicks enter on the keyboard")
    public static void Enter(WebElement elem, Keys value){
        elem.sendKeys(value);
    }
}