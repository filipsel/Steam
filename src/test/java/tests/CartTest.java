package tests;

import org.testng.Reporter;
import org.testng.log4testng.Logger;
import pages.CartPage;
import pages.GamePage;
import pages.Strings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.ArrayList;

public class CartTest extends BaseTest {


    /** Add to Cart test
    Test steps:
    1. Perform a successful sign in test
    2. Search for a specific game
    3. Click on 'Add to Cart' button

    Expected results:
    3. Assert whether current URL matches that one of the specific game
    3. Assert if the cart page header text is 'YOUR SHOPPING CART'
    3. Assert whether the specific game upgrade is present on the list
     */

    @Test (priority = 1)

    public void addToCartTest() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Successfully sign in to Steam");
            successfulSignIn(driver);

            print("2. Search for a specific game");
            searchForASpecificGameByName(driver);

            print("3. Click on 'Add to Cart' button");
            GamePage gamePage = new GamePage(driver);
            gamePage.clickOnAddToCartButtonForPrimeStatusUpgrade();
            print("3. Assert whether current URL matches that one of the specific game");
            String cartPageURL = driver.getCurrentUrl();
            Assert.assertEquals(cartPageURL, Strings.CART_PAGE_URL);
            CartPage cartPage = new CartPage(driver);
            print("3. Assert if the cart page header text is 'YOUR SHOPPING CART'");
            String currentPageHeader = cartPage.pageHeaderText();
            assert currentPageHeader.equals(Strings.CART_PAGE_HEADER) : "Error. Cart page header text is missing from the page, or is different from expected. Expected page header text: "
                    + Strings.CART_PAGE_HEADER + ". Actual header text: " + currentPageHeader;
            Reporter.log("Current page header is: " + currentPageHeader, true);
            print("3. Assert whether the specific game upgrade is present on the list");
            assert cartPage.specificGameUpgradeIsPresent() : "Error. Specific game upgrade is not present on the list";
            Reporter.log("Specific game upgrade is present", true);

            print("Test successful");

        }finally {
            driver.quit();
        }
    }

     /** Remove from cart test
     Test steps:
     1. Sign in, search for a specific game and add it to cart
     2. Remove the game from cart by clicking on 'Remove' button

     Expected results:
     2. Assert if the correct cart status message appears
     */

    @Test (priority = 2)

    public void removeGameFromCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Sign in, search for a specific game upgrade/pack and add it to cart");
            addToCart(driver);

            print("2. Remove the game from cart by clicking on 'Remove' button");
            CartPage cartPage = new CartPage(driver);
            cartPage.removeGameFromCart();
            print("2. Assert if the correct cart status message appears");
            String cardStatusMessage = cartPage.cartStatusMessageRemovedItem();
            assert cardStatusMessage.equals(Strings.CART_STATUS_MESSAGE) : "Error. Expected cart status message is missing from the page, or is different from expected. Expected message: "
                    + Strings.CART_STATUS_MESSAGE + ". Actual message: " + cardStatusMessage;
            Reporter.log("Card status message is: " + cardStatusMessage, true);

            print("Test successful");

        } finally {
            driver.quit();
        }
    }

    /** Add two games to cart and remove them
    Test steps:
    1. Perform a successful sign in test
    2. Search for a specific game
    3. Click on 'Add to Cart' button
    4. Navigate back to the game page
    5. Add another game upgrade/pack to the list
    6. Remove all items from the list
    7. Confirm by clicking 'Yes' in the popup window

    Expected results:
    5. After you are taken to cart page again, verify if there are two game upgrades/packs on the cart page
    6. Verify if there are no more items on the cart page
    7. Verify if there are no more items on the cart page
    */

    @Test (priority = 3)

    public void addTwoGamesToCartAndRemoveThem() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Search for a specific game");
            searchForASpecificGameByName(driver);

            print("3. Click on 'Add to Cart' button");
            GamePage gamePage = new GamePage(driver);
            gamePage.clickOnAddToCartButtonForPrimeStatusUpgrade();

            print("4. Navigate back to the game page");
            driver.navigate().back();

            print("5. Add another game upgrade/pack to the list");
            gamePage.clickOnAddToCartButtonForValveCompletePack();
            print("5. After you are taken to cart page again, verify if there are two game upgrades/packs on the cart page");
            CartPage cartPage = new CartPage(driver);
            ArrayList<WebElement> numberOfGames = cartPage.getNumberOfGamesInTheCart();
            assert numberOfItemsOnTheList(numberOfGames) : "Error. Incorrect number of games in the cart. Expected number of games: 2. Actual number of games: " + numberOfGames;
            print("5. Assert whether current URL matches that one of the specific game");
            String cartPageURL = driver.getCurrentUrl();
            Assert.assertEquals(cartPageURL, Strings.CART_PAGE_URL);

            print("6. Remove all items from the list");
            cartPage.clickOnRemoveAllItemsButton();

            print("7. Confirm by clicking 'Yes' in the popup window");
            cartPage.clickOnConfirmationButton();
            print("7. Verify if there are no more items on the cart page");
            assert numberOfItemsOnTheList(numberOfGames) : "Error. Incorrect number of games in the cart. Expected number of games: 0. Actual number of games: " + numberOfGames;

            print("Test successful");

        }finally {
            driver.quit();
        }
    }
}
