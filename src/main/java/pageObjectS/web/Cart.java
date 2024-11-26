package pageObjectS.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Cart {
    // Title of the cart
    @FindBy(css = "div[class*='grXYZl']>span")
    private WebElement cartTitle;

    // The number shown on the cart icon
    @FindBy(css = "div[class*='fMfPui']>div")
    private WebElement iconNumber;

    // The close button on the cart
    @FindBy(css = "button[class*='gFkyvN']")
    private WebElement closeCartBtn;

    // The "Checkout" button in the cart
    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkOutBtn;

    // List of products currently in the cart
    @FindBy(css = "div[class*='hDmOrM']")
    private List<WebElement> products;

    // Titles of all products in the cart
    @FindBy(css = "p[class*='elbkhN']")
    private List<WebElement> productsTitles;

    // Buttons to increase product quantity
    @FindBy(xpath = "//button[text()=\"+\"]")
    private List<WebElement> plusBtn;

    // Buttons to decrease product quantity
    @FindBy(xpath = "//button[text()=\"-\"]")
    private List<WebElement> minusBtn;

    // Quantity of the first item in the cart
    @FindBy(css = "p[class*='gKtloF']>br")
    private WebElement quantityFirstItem;

    // Price of the first item in the cart
    @FindBy(css = "div[class*='bnZqjD']>p")
    private WebElement priceOfFirstItem;

    // List of remove buttons for all products in the cart
    @FindBy(css = "button[title*='remove']")
    private List<WebElement> removeBtns;

    // Remove button for the first product
    @FindBy(css = "button[class*='gBQuHE']")
    private WebElement removeBtn;

    // The cart button (used to open the cart)
    @FindBy(css = "div[class*='fGgnoG']>div")
    private WebElement cartBtn;

    // Quantity displayed on the cart icon
    @FindBy(xpath = "//div[@title='Products in cart quantity']")
    private WebElement quantityOnCart;

    // The cart icon displayed at the top of the screen
    @FindBy(css = "div[class*='fMfPui']")
    private WebElement cartIcon;

    // Subtotal label in the cart
    @FindBy(xpath = "//p[text()='SUBTOTAL']")
    private WebElement subTotalLabel;

    // Total price displayed in the cart
    @FindBy(css = "p[class*='jzywDV']")
    private WebElement totalPrice;

    // Getter for 'cartTitle'
    public WebElement getCartTitle() {
        return cartTitle;
    }

    // Getter for 'iconNumber'
    public WebElement getIconNumber() {
        return iconNumber;
    }

    // Getter for 'closeCartBtn'
    public WebElement getCloseCartBtn() {
        return closeCartBtn;
    }

    // Getter for 'checkOutBtn'
    public WebElement getCheckOutBtn() {
        return checkOutBtn;
    }

    // Getter for 'products'
    public List<WebElement> getProducts() {
        return products;
    }

    // Getter for 'productsTitles'
    public List<WebElement> getProductsTitles() {
        return productsTitles;
    }

    // Getter for 'plusBtn'
    public List<WebElement> getPlusBtn() {
        return plusBtn;
    }

    // Getter for 'minusBtn'
    public List<WebElement> getMinusBtn() {
        return minusBtn;
    }

    // Getter for 'quantityFirstItem'
    public WebElement getQuantityFirstItem() {
        return quantityFirstItem;
    }

    // Getter for 'priceOfFirstItem'
    public WebElement getPriceOfFirstItem() {
        return priceOfFirstItem;
    }

    // Getter for 'removeBtns'
    public List<WebElement> getRemoveBtns() {
        return removeBtns;
    }

    // Getter for 'removeBtn'
    public WebElement getRemoveBtn() {
        return removeBtn;
    }

    // Getter for 'cartBtn'
    public WebElement getCartBtn() {
        return cartBtn;
    }

    // Getter for 'quantityOnCart'
    public WebElement getQuantityOnCart() {
        return quantityOnCart;
    }

    // Getter for 'cartIcon'
    public WebElement getCartIcon() {
        return cartIcon;
    }

    // Getter for 'subTotalLabel'
    public WebElement getSubTotalLabel() {
        return subTotalLabel;
    }

    // Getter for 'totalPrice'
    public WebElement getTotalPrice() {
        return totalPrice;
    }
}