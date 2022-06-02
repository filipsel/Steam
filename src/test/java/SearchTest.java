import Pages.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest {


    /** Search for a specific game by name
    Test steps:
    1. Perform a successful sign in test
    2. Enter a specific game name into the search field
    3. Search for the game
    4. Click on the specific game in the search pool

    Expected results:
    3. Check whether the specific game is in the search pool
    4. Assert whether the game page URL is correct
    4. Assert whether the game name matches with the game name that is searched for
     */

    @Test
    public void searchForASpecificGameByName() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Enter a specific game name into the search field");
            HomePage homePage = new HomePage(driver);
            homePage.enterTextIntoSearchBox(Strings.GAME_NAME);

            print("3. Search for the game");
            homePage.clickOnSearchButton();
            print("3. Check whether the specific game is in the search pool");
            SearchPage searchPage = new SearchPage(driver);
            String gameName = searchPage.getSpecificGameName();
            assert gameName.equals(Strings.GAME_NAME) : "error. Game name is missing from the page, or is different from expected. Expected game name: "
                    + Strings.GAME_NAME + ". Actual game name: " + gameName;

            print("4. Click on the specific game in the search pool");
            searchPage.clickOnSpecificGame();
            print("4. Assert whether the game URL is correct");
            String gameURL = driver.getCurrentUrl();
            Assert.assertEquals(gameURL, Strings.SPECIFIC_GAME_URL);
            print("4. Assert whether the game name matches with the game name that is searched for");
            GamePage gamePage = new GamePage(driver);
            String currentPageGameName = gamePage.getSpecificGameName();
            assert currentPageGameName.equals(Strings.GAME_NAME) : "Error. Game name is missing from the page, or is different from expected. Expected game name: "
                    + Strings.GAME_NAME + ". Actual game name: " + currentPageGameName;

            print("Test successful");

        } finally {
            driver.quit();
        }
    }

    /** Search by category for a specific game
    Test steps:
    1. Perform a successful sign in test
    2. Hover the mouse pointer over 'categories' tab
    3. Click on 'Free to Play' subcategory
    4. Scroll down and click on 'Top Sellers' button
    5. Click on the specific game

    Expected results:
    3. Assert whether you are on the 'Free to Play' page by checking if the page header is present
    4. Assert whether the specific game is present on the list
    5. Assert whether you're on the specific game page
     */

    @Test
    public void searchByCategory() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Hover the mouse pointer over 'categories' tab");
            HomePage homePage = new HomePage(driver);
            homePage.hoverOverCategoriesTab();

            print("3. Click on 'Free to Play' subcategory");
            homePage.clickOnFreeToPlaySubcategory();
            print("3. Assert whether you are on the 'Free to Play' page by checking if the page header is present");
            FreeToPlayPage freeToPlayPage = new FreeToPlayPage(driver);
            String pageHeader = freeToPlayPage.pageHeaderText();
            assert pageHeader.equals(Strings.FREE_TO_PLAY_PAGE_HEADER) : "Error. Page header text is ether wrong or missing, or page did not open at all. Expected: "
                    + Strings.FREE_TO_PLAY_PAGE_HEADER + ". Actual: " + pageHeader;

            print("4. Scroll down and click on 'Top Sellers' button");
            freeToPlayPage.clickOnTopSellersButton();
            print("4. Assert whether the specific game is present on the list");
            assert freeToPlayPage.specificGameIsPresent() : "Error. Specific game is not present on the list";

            print("5. Click on the specific game");
            freeToPlayPage.clickOnDesiredGame();
            GamePage gamePage = new GamePage(driver);
            print("5. Assert whether you're on the specific game page");
            String currentPageGameName = gamePage.getSpecificGameName();
            assert currentPageGameName.equals(Strings.GAME_NAME) : "Error. Game name is missing from the page, or is different from expected. Expected game name: "
                    + Strings.GAME_NAME + ". Actual game name: " + currentPageGameName;

            print("Test successful");

        }finally {
            driver.quit();
        }
    }
}
