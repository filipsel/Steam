import Pages.CartPage;
import Pages.GamePage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{


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

    @Test
    public void addToCartTest() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Search for a specific game");
            searchForASpecificGameByName(driver);

            print("3. Click on 'Add to Cart' button");
            GamePage gamePage = new GamePage(driver);
            gamePage.clickOnAddToCartButton();
            print("3. Assert whether current URL matches that one of the specific game");
            String cartPageURL = driver.getCurrentUrl();
            Assert.assertEquals(cartPageURL, Strings.CART_PAGE_URL);
            CartPage cartPage = new CartPage(driver);
            print("3. Assert if the cart page header text is 'YOUR SHOPPING CART'");
            String currentPageHeader = cartPage.pageHeaderText();
            assert currentPageHeader.equals(Strings.CART_PAGE_HEADER) : "Error. Cart page header text is missing from the page, or is different from expected. Expected page header text: "
                    + Strings.CART_PAGE_HEADER + ". Actual header text: " + currentPageHeader;
            print("3. Assert whether the specific game upgrade is present on the list");
            assert cartPage.specificGameUpgradeIsPresent() : "Error. Specific game upgrade is not present on the list";

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

    @Test

    public void removeGameFromCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Sign in, search for a specific game and add it to cart");
            addToCartTest(driver);

            print("2. Remove the game from cart by clicking on 'Remove' button");
            CartPage cartPage = new CartPage(driver);
            cartPage.removeGameFromCart();
            print("2. Assert if the correct cart status message appears");
            String cardStatusMessage = cartPage.cartStatusMessageRemovedItem();
            assert cardStatusMessage.equals(Strings.CART_STATUS_MESSAGE) : "Error. Expected cart status message is missing from the page, or is different from expected. Expected message: "
                    + Strings.CART_STATUS_MESSAGE + ". Actual message: " + cardStatusMessage;

            print("Test successful");

        } finally {
            driver.quit();
        }
    }
}
