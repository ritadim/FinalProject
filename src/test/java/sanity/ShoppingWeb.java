package sanity;

import extensions.UIActions;
import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class ShoppingWeb extends CommonOps {

    @Test(description = "Test01 - Verify Check Out")
    @Description("Adding one product to the cart and verify checkout")
    public void test01VerifyCheckOut(){
        WebFlows.addFirstItemToCart();
        Verifications.VerifyTextFromAlert("Checkout - Subtotal: $ 10.90");
    }
    @Test(description = "Test02 - Verify The Price Sum Of All Items")
    @Description("Verifies the price of all the items together")
    public void test02VerifyPriceOfAll(){
        WebFlows.addAllItemsToCart();
        Verifications.VerifyTextFromAlert("Checkout - Subtotal: $ 440.00");
    }
    @Test(description = "Test03 - Verify Removing One Item From Cart")
    @Description("Removing one item from cart")
    public void test03VerifyRemovingItem(){
        WebFlows.removeItemsFromCart();
        Verifications.VerifyTextFromElement(webCart.getQuantityOnCart(),"0");
    }
    @Test(description = "Test04 - Verify Removing All")
    @Description("Removing a large amount of products from the cart")
    public void test04VerifyRemovingAll(){
        WebFlows.removeAllItems();
        Verifications.VerifyTextFromElement(webCart.getTotalPrice(),"$ 0.00");
    }
    @Test(description = "Test05 - Verify Filtering The Clothing Results By Sizes")
    @Description("Verifies the size filter")
    public void test05VerifyFilterBySizes(){
        WebFlows.filterBySizes();
        Verifications.VerifyFilter(webProducts.getProductsFound(),"12");
    }
    @Test(description = "Test06 - Verify Visibility Of The Clothes Sizes")
    @Description("Make sure the sizes of the clothes is displayed(using soft assertion)")
    public void test06VerifyVisibilityOfSizes(){
        Verifications.visibilityOfElements(webShopSizes.getAllSizes());
    }
    @Test(description = "Test07 - Verify Price of a Specific Product",
    dataProvider = "data-provider-productPrices", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify price of a specific product with DDT (the title of the product and the price)")
    public void test07VerifyPriceOfProduct(String title,String price) {
        int index = UIActions.numberOfElem(webProducts.getProducts_Titles(),title);
        System.out.println(index);
        Verifications.VerifyText(webProducts.getPrices(index),price);
    }
}