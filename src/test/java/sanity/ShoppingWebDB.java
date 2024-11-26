package sanity;

import extensions.DBActions;
import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;

@Listeners(utilities.Listeners.class)
public class ShoppingWebDB extends CommonOps{
    // the same test as test01 in ShoppingWeb class but getting the expected result from database
    @Test(description = "Test08 - Verify Check Out With DataBase Data")
    @Description("Verifies The Price Of The First Item")
    public void test08VerifyCheckOutDB(){
        String query ="SELECT Price FROM products";
        List<String> prices = DBActions.getCredentials(query);
        WebFlows.addFirstItemToCart();
        Verifications.VerifyTextFromAlert("Checkout - Subtotal: $ " + prices.get(0));
    }
}
