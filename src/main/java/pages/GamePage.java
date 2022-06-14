package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.utils.Log;

public class GamePage extends BasePage {


    public GamePage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy (xpath = "//div[@id = 'appHubAppName']")
    WebElement gameName;

    @FindBy (xpath = "//a[@id = 'btn_add_to_cart_54029']")
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
        Log.info("Getting specific game name");
        Reporter.log("Getting specific game name");
        return gameName.getText();
    }

    public void clickOnAddToCartButtonForPrimeStatusUpgrade() {
        Log.info("Clicking on 'Add to cart' button for 'Prime Status Upgrade'");
        Reporter.log("Clicking on 'Add to cart' button for 'Prime Status Upgrade'");
        scrollIntoView(addPrimeStatusUpgradeToCart);
        waitForElementToBeClickable(addPrimeStatusUpgradeToCart);
        addPrimeStatusUpgradeToCart.click();
    }

    public void clickOnAddToCartButtonForValveCompletePack() {
        Log.info("Clicking on 'Add to cart' button for 'Valve Complete Pack'");
        Reporter.log("Clicking on 'Add to cart' button for 'Valve Complete Pack");
        scrollIntoView(addValveCompletePackToCart);
        waitForElementToBeClickable(addValveCompletePackToCart);
        addValveCompletePackToCart.click();
    }

    public void clickOnAddToYourWishListButton() {
        Log.info("Clicking on 'Add to Wishlist' button");
        Reporter.log("Clicking on 'Add to Wishlist' button");
        waitForElementVisibility(addToWishListButton);
        addToWishListButton.click();
    }

    public boolean addToWishListButtonIsPresent() {
        Log.info("Checking whether 'Add to Wishlist' button is present");
        Reporter.log("Checking whether 'Add to Wishlist' button is present");
        waitForElementVisibility(addToWishListButton);
        if (addToWishListButton.isDisplayed()) {
            Log.info("'Add to Wishlist' button is present");
            Reporter.log("'Add to Wishlist' button is present");
        }else {
            Log.error("'Add to Wishlist' button is missing");
            Reporter.log("'Add to Wishlist' button is missing");
        }
        return verifyElementPresent(addToWishListButton);
    }

    public boolean onWishListButtonIsPresent() {
        Log.info("Checking whether 'On Wishlist' button is present");
        Reporter.log("Checking whether 'On Wishlist' button is present");
        waitForElementVisibility(onWishlistButton);
        if (onWishlistButton.isDisplayed()){
            Log.info("'On Wishlist' button is present");
            Reporter.log("'On Wishlist' button is present");
        }else {
            Log.error("'On Wishlist' button is missing");
            Reporter.log("'On Wishlist' button is missing");
        }
        return verifyElementPresent(onWishlistButton);
    }

    public void clickOnOnWishlistButton() {
        Log.info("Clicking on 'Wishlist' button");
        Reporter.log("Clicking on 'Wishlist' button");
        waitForElementVisibility(onWishlistButton);
        onWishlistButton.click();
    }

    public void clickOnWishlistPageButton() {
        Log.info("Clicking on 'Wishlist Page' button");
        Reporter.log("Clicking on 'Wishlist Page' button");
        waitForElementVisibility(wishlistPageButton);
        wishlistPageButton.click();
    }

    public boolean gameOnWishListIsPresent() {
        Log.info("Checking if the game on wishlist is present");
        Reporter.log("Checking if the game on wishlist is present");
        waitForElementVisibility(gameOnWishlist);
        if (gameOnWishlist.isDisplayed()){
            Log.info("Game on wishlist is present");
            Reporter.log("Game on wishlist is present");
        }else {
            Log.error("Game is missing from the wishlist");
            Reporter.log("Game is missing from the wishlist");
        }
        return verifyElementPresent(gameOnWishlist);
    }

    public String getGameOnWishlistName() {
        Log.info("Getting game on wishlist");
        Reporter.log("Getting game on wishlist");
        return nameOfGameOnWishlist.getText();
    }

}
