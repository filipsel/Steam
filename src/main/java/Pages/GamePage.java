package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

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
        print("getSpecificGameName");
        return gameName.getText();
    }

    public void clickOnAddToCartButtonForPrimeStatusUpgrade() {
        print("clickOnAddToCartButtonForPrimeStatusUpgrade");
        scrollIntoView(addPrimeStatusUpgradeToCart);
        waitForElementToBeClickable(addPrimeStatusUpgradeToCart);
        addPrimeStatusUpgradeToCart.click();
    }

    public void clickOnAddToCartButtonForValveCompletePack() {
        print("clickOnAddToCartButtonForValveCompletePack");
        scrollIntoView(addValveCompletePackToCart);
        waitForElementToBeClickable(addValveCompletePackToCart);
        addValveCompletePackToCart.click();
    }

    public void clickOnAddToYourWishListButton() {
        print("clickOnAddToWishListButton");
        waitForElementVisibility(addToWishListButton);
        addToWishListButton.click();
    }

    public boolean addToWishListButtonIsPresent() {
        print("addToWishListButtonIsPresent");
        waitForElementVisibility(addToWishListButton);
        return presentElement(addToWishListButton);
    }

    public boolean onWishListButtonIsPresent() {
        print("onWishListButtonIsPresent");
        waitForElementVisibility(onWishlistButton);
        return presentElement(onWishlistButton);
    }

    public void clickOnOnWishlistButton() {
        print("clickOnOnWishlistButton");
        waitForElementVisibility(onWishlistButton);
        onWishlistButton.click();
    }

    public void clickOnWishlistPageButton() {
        print("clickOnWishlistPageButton");
        waitForElementVisibility(wishlistPageButton);
        wishlistPageButton.click();
    }

    public boolean gameOnWishListIsPresent() {
        print("gameOnWishListIsPresent");
        waitForElementVisibility(gameOnWishlist);
        return presentElement(gameOnWishlist);
    }

    public String getGameOnWishlistName() {
        print("getGameOnWishlistName");
        return nameOfGameOnWishlist.getText();
    }

}
