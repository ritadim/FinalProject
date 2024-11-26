package pageObjectS.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Products {
    // List of product images displayed on the product grid
    @FindBy(xpath = "//div[@tabindex='1']/div[2]")
    private List<WebElement> products_Pics;

    // List of product titles displayed on the product grid
    @FindBy(xpath = "//div[@tabindex='1']/p")
    private List<WebElement> products_Titles;

    // List of "Add to Cart" buttons for all products
    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartBtns;

    // Specific "Add to Cart" button for one product
    @FindBy(css = "div[class*='dwOYCh']>button")
    private WebElement addToCartBtn_one;

    // List of price integer parts before the decimal point
    @FindBy(css = "p[class*='ljgnQL']>b")
    private List<WebElement> prices_beforeTheDecimalPoint;

    // List of price fractional parts after the decimal point
    @FindBy(css = "p[class*='ljgnQL']>span")
    private List<WebElement> prices_afterTheDecimalPoint;

    // A random element on the main page to use as a starting point for interactions
    @FindBy(css = "main[class*='sc-ebmerl-4']")
    private WebElement startingPoint;

    // Label displaying the number of products found after filtering
    @FindBy(css = "main[class*=sc-ebmerl-4]>p")
    private WebElement productsFound;

    // Getter for 'products_Pics'
    public List<WebElement> getProducts_Pics() {
        return products_Pics;
    }

    // Getter for 'products_Titles'
    public List<WebElement> getProducts_Titles() {
        return products_Titles;
    }

    // Getter for 'addToCartBtns'
    public List<WebElement> getAddToCartBtns() {
        return addToCartBtns;
    }

    // Getter for 'addToCartBtn_one'
    public WebElement getAddToCartBtn_one() {
        return addToCartBtn_one;
    }

    // Getter for 'prices_beforeTheDecimalPoint'
    public List<WebElement> getPrices_beforeTheDecimalPoint() {
        return prices_beforeTheDecimalPoint;
    }

    // Getter for 'prices_afterTheDecimalPoint'
    public List<WebElement> getPrices_afterTheDecimalPoint() {
        return prices_afterTheDecimalPoint;
    }

    // Getter for 'startingPoint'
    public WebElement getStartingPoint() {
        return startingPoint;
    }

    // Getter for 'productsFound'
    public WebElement getProductsFound() {
        return productsFound;
    }

    // Method name: getPrices
    // Method description: retrieves the full price (integer and decimal parts) of a product at the specified index
    // Method parameters: int( The index of the product whose price needs to be retrieved.)
    // Method return: the complete price as a concatenated string (integer part + decimal part)
    public String getPrices(int productIndex){
        String totalPrice = prices_beforeTheDecimalPoint.get(productIndex).getText()
                + prices_afterTheDecimalPoint.get(productIndex).getText();
        System.out.println(totalPrice);
        return totalPrice;
    }
}