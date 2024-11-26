package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    // Initializes Page Objects for the Web platform.
    public static void initWeb(){
        webProducts = PageFactory.initElements(driver, pageObjectS.web.Products.class);
        webCart = PageFactory.initElements(driver, pageObjectS.web.Cart.class);
        webShopSizes = PageFactory.initElements(driver, pageObjectS.web.Sizes.class);
    }

    // Initializes Page Objects for the Mobile platform.
    public static void initMobileApp(){
        MobileHeader = new pageObjectS.mobile.Header(mobileDriver);
        MobileLivingCategory = new pageObjectS.mobile.Living(mobileDriver);
        MobileNumbersTab = new pageObjectS.mobile.NumbersTab(mobileDriver);
    }

    // Initializes Page Objects for the Electron platform.
    public static void initElectron(){
        electronMain = PageFactory.initElements(driver, pageObjectS.electronApp.MainPage.class);
    }
}