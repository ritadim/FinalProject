package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;


public class WebFlows extends CommonOps {

    //this flow is also used in database testing
    @Step("Business Flow: adding one product to the cart and clicking on checkout")
    public static void addFirstItemToCart(){
        UIActions.click(webProducts.getAddToCartBtn_one());
        UIActions.click(webCart.getCheckOutBtn());
        UIActions.switchToPopup();
    }
    @Step("Business Flow: adding all the products to the cart and clicking on checkout")
    public static void addAllItemsToCart(){
        UIActions.clickOnElems(webProducts.getAddToCartBtns(), webCart.getCloseCartBtn());
        UIActions.click(webCart.getCartBtn());
        UIActions.click(webCart.getCheckOutBtn());
        UIActions.switchToPopup();
    }
    @Step("Business Flow: adding product to the cart and removing the product")
    public static void removeItemsFromCart(){
        UIActions.click(webProducts.getAddToCartBtn_one());
        UIActions.click(webCart.getRemoveBtn());
        UIActions.click(webCart.getCloseCartBtn());
    }
    @Step("Business Flow: adding all the products to the cart and removing them all")
    public static void removeAllItems(){
        UIActions.clickOnElems(webProducts.getAddToCartBtns(), webCart.getCloseCartBtn());
        UIActions.click(webCart.getCartBtn());
        UIActions.mouseHover(webProducts.getStartingPoint(),webCart.getCartIcon());
        UIActions.arrowDownClick(45);
        UIActions.clickOnAllFromEnd(webCart.getRemoveBtns());
    }
    @Step("Business Flow: filter results by the sizes: XS, S, XL")
    public static void filterBySizes(){
        UIActions.clickOnElemsFromList(webShopSizes.getAllSizes(), 2);
        UIActions.click(webShopSizes.getAllSizes().get(5));
    }
}