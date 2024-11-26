package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOps extends Base{
    // Method name: getData
    // Method description: this method gets the data from xml configuration file
    // Method parameters: String
    // Method return: String
    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    // Method name: initBrowser
    // Method description: this method initialize the web browser and calls to webDriver initialization
    // Method parameters: String
    // Method return: void
    // comments: initialization of wait mechanism, web page objects
    public static void initBrowser(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            driver = initChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox")){
            driver = initFirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("ie")){
            driver = initIEDriver();
        }
        else if (browserType.equalsIgnoreCase("edge")){
            driver = initEdgeDriver();
        }
        else
        {
            throw new RuntimeException("Invalid browser type");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initWeb();
        action = new Actions(driver);
    }

    // Method name: initChromeDriver
    // Method description: this method initialize chrome web driver
    // Method return: WebDriver
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    // Method name: initFirefoxDriver
    // Method description: this method initialize firefox web driver
    // Method return: WebDriver
    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    // Method name: initIEDriver
    // Method description: this method initialize explorer web driver
    // Method return: WebDriver
    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    // Method name: initEdgeDriver
    // Method description: this method initialize edge web driver
    // Method return: WebDriver
    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    // Method name: initMobile
    // Method description: this method initialize a mobile testing environment using Appium
    // Method return: void
    // comments: configures DesiredCapabilities, wait mechanism, mobile page objects, create an instance of AndroidDriver.
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try{
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        }
        catch (Exception e){
            System.out.println("cannot connect to appium server, see details: " + e);
        }
        ManagePages.initMobileApp();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("Timeout")));
        mobileAction = new TouchAction(mobileDriver);
    }

    // Method name: initAPI
    // Method description: this method initialize API
    // Method return: void
    public static void initAPI(){
        RestAssured.baseURI = getData("baseURL");
        httpRequest = RestAssured.given();
    }


    // Method name: initElectron
    // Method description: this method initialize an Electron application testing environment
    // Method return: void
    // comments: configures DesiredCapabilities, wait mechanism, Electron page objects
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initElectron();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    // Method name: startSession
    // Method description: this method calls the initialization of the platform according to the parameter(PlatformName) received from testNG.xml file
    // Method parameters: String
    // Method return: void
    // comments: this method also make a connection to the database
    @BeforeClass//runs once before all the @Test methods in the class
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web")){
            initBrowser(getData("BrowserName"));
        }
        else if (platform.equalsIgnoreCase("mobile")){
            initMobile();
        }
        else if (platform.equalsIgnoreCase("api")){
            initAPI();
        }
        else if (platform.equalsIgnoreCase("electron")){
            initElectron();
        }
        else{
            throw new RuntimeException("Invalid platform name");
        }
        softAssert = new SoftAssert();
       // ManageDB.openConnection(getData("DBurl"),getData("DBUserName"),getData("DBPassword"));
    }


    // Method name: closeSession
    // Method description: this method quitting a WebDriver session
    // Method return: void
    // comments: quitting mobileDriver session and closing a database connection
    @AfterClass//runs once after all the @Test methods in the class
    public void closeSession(){
        // ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")){
            if(!platform.equalsIgnoreCase("mobile")) {
                driver.quit();
            }
            else {
                mobileDriver.quit();
            }
        }
    }


   // Method name: afterMethod
   // Method description: this method do a reset\refresh after each test method is executed
   // Method return: void
    @AfterMethod//runs after every @Test method in the class
    public void afterMethod(){
        if(!platform.equalsIgnoreCase("api")){
            if(!platform.equalsIgnoreCase("mobile")){
                if(platform.equalsIgnoreCase("web")){
                    try {
                        driver.get(getData("url"));
                    }
                    catch (RuntimeException e){
                        driver.navigate().refresh();
                        System.out.println("the exception is: "+e);
                    }
                }
            }
            else{
                    mobileDriver.resetApp();
            }
        }
    }

    // Method name: beforeMethod
    // Method description: Screen recording initialization
    // Method parameters: Method(represents the specific test method that is about to run)
    // Method return: void
    @BeforeMethod// runs before every @Test method in the class
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            // start recording tests
            try {
                MonteScreenRecorder.startRecord(method.getName());
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}