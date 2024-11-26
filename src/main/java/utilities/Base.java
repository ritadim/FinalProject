package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static String platform;

    //Web
    protected static WebDriver driver;
    //the Alert object initialization is in the UIActions class
    protected static Alert popup;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static TouchAction mobileAction;

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database
    protected static Connection con;
    protected static ResultSet rs;
    protected static Statement stmt;

    //Page Objects - Web
    protected static pageObjectS.web.Products webProducts;
    protected static pageObjectS.web.Cart webCart;
    protected static pageObjectS.web.Sizes webShopSizes;

    //Page Objects - Mobile
    protected static pageObjectS.mobile.Header MobileHeader;
    protected static pageObjectS.mobile.Living MobileLivingCategory ;
    protected static pageObjectS.mobile.NumbersTab MobileNumbersTab;

    //Page Objects - Electron
    protected static pageObjectS.electronApp.MainPage electronMain;
}