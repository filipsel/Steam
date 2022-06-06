package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class GamePage extends BasePage {


    public GamePage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy (xpath = "//div[@id = 'appHubAppName']")
    WebElement gameName;

    @FindBy (xpath = "//a[@id = 'btn_add_to_cart_54029']//span[contains(text(),'Add to Cart')]")
    WebElement addPrimeStatusUpgradeToCart;

    @FindBy (xpath = "//div[@class='game_area_purchase_game_dropdown_subscription game_area_purchase_game']//span[contains(text(),'Add to Cart')]")
    WebElement addValveCompletePackToCart;

    @FindBy (xpath = "//span[normalize-space() = 'Add to your wishlist']")
    WebElement addToWishListButton;

    @FindBy (xpath = "//span[normalize-space() = 'On Wishlist']")
    WebElement onWishlistButton;

    @FindBy (xpath = "//a[@id = 'wishlist_link']")
    WebElement wishlistPageButton;

    @FindBy (xpath = "//div[@id='wishlist_row_730']")
    WebElement gameOnWishlist;

    @FindBy (xpath = "//a[@class='title']")
    WebElement nameOfGameOnWishlist;


    //Methods

    public String getSpecificGameName() {
        print("Getting specific game name");
        return gameName.getText();
    }

    public void clickOnAddToCartButtonForPrimeStatusUpgrade() {
        print("Clicking on 'Add to cart' button for 'Prime Status Upgrade'");
        scrollIntoView(addPrimeStatusUpgradeToCart);
        waitForElementToBeClickable(addPrimeStatusUpgradeToCart);
        addPrimeStatusUpgradeToCart.click();
    }

    public void clickOnAddToCartButtonForValveCompletePack() {
        print("Clicking on 'Add to cart' button for 'Valve Complete Pack'");
        scrollIntoView(addValveCompletePackToCart);
        waitForElementToBeClickable(addValveCompletePackToCart);
        addValveCompletePackToCart.click();
    }

    public void clickOnAddToYourWishListButton() {
        print("Clicking on 'Add to Wishlist' button");
        waitForElementVisibility(addToWishListButton);
        addToWishListButton.click();
    }

    public boolean addToWishListButtonIsPresent() {
        print("'Add to Wishlist' button is present");
        waitForElementVisibility(addToWishListButton);
        return elementPresent(addToWishListButton);
    }

    public boolean onWishListButtonIsPresent() {
        print("'On Wishlist' button is present");
        waitForElementVisibility(onWishlistButton);
        return elementPresent(onWishlistButton);
    }

    public void clickOnOnWishlistButton() {
        print("Clicking on 'Wishlist' button");
        waitForElementVisibility(onWishlistButton);
        onWishlistButton.click();
    }

    public void clickOnWishlistPageButton() {
        print("Clicking on 'Wishlist Page' button");
        waitForElementVisibility(wishlistPageButton);
        wishlistPageButton.click();
    }

    public boolean gameOnWishListIsPresent() {
        print("Game on wishlist is present");
        waitForElementVisibility(gameOnWishlist);
        return elementPresent(gameOnWishlist);
    }

    public String getGameOnWishlistName() {
        print("Getting game on wishlist");
        return nameOfGameOnWishlist.getText();
    }

}
