package tests;

import org.testng.Reporter;
import pages.GamePage;
import pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.utils.Log;

public class WishListTest extends BaseTest {

    /** Add game to wishlist and remove it from wishlist
    Test steps:
    1. Perform a successful sign in test
    2. Search for a specific game
    3. Click on 'Add to your wishlist' button
    4. Go to 'Wishlist' page by clicking on the button with the same name
    5. Go back to game page
    6. Click on 'On wishlist' button

    Expected results:
    3. Assert if the 'On wishlist' button is present
    4. Assert if the specific game is present on the wishlist
    4. Assert if the name of the game matches with expected name of the game
    5. Assert whether you're back on the game page
    6. Assert if the 'Add to your wishlist' button is present
    */

    @Test

    public void addGameToWishlistAndRemoveItFromWishlist() {
        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Search for a specific game");
            searchForASpecificGameByName(driver);

            print("3. Click on 'Add to your wishlist' button");
            GamePage gamePage = new GamePage(driver);
            gamePage.clickOnAddToYourWishListButton();
            print("3. Assert if the 'On wishlist' button is present");
            assert gamePage.onWishListButtonIsPresent() : "Error. 'On wishlist' button is not visible";

            print("4. Go to 'Wishlist' page by clicking on the button with the same name");
            gamePage.clickOnWishlistPageButton();
            print("4. Assert if the specific game is present on the wishlist");
            assert gamePage.gameOnWishListIsPresent() : "Error. Game is missing from the page";
            print("4. Assert if the name of the game matches with expected name of the game");
            String nameOfGameOnWishlist = gamePage.getGameOnWishlistName();
            assert nameOfGameOnWishlist.equals(Strings.NAME_OF_GAME_ON_WISHLIST) : "Error. Specific game is different from expected or the game is missing from the list. Expected game name: " +
                    Strings.NAME_OF_GAME_ON_WISHLIST + ". Actual game name: " + nameOfGameOnWishlist;
            Reporter.log("Name of the game on wishlist: " + nameOfGameOnWishlist);

            print("5. Go back to game page");
            driver.navigate().back();
            print("5. Assert whether you're back on the game page");
            String gameURL = driver.getCurrentUrl();
            Assert.assertEquals(gameURL, Strings.SPECIFIC_GAME_URL);

            print("6. Click on 'On wishlist' button");
            gamePage.clickOnOnWishlistButton();
            print("6. Assert if the 'Add to your wishlist' button is present");
            assert gamePage.addToWishListButtonIsPresent() : "Error. 'On wishlist' button is not present";

        }finally{
            driver.quit();
        }
    }

}
