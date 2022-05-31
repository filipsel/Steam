import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class BaseTest {
    ChromeDriver driver;

    public ChromeDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void successfulSignIn(ChromeDriver driver) {
            SignInPage signInPage = new SignInPage(driver);
            signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
            signInPage.enterPassword(Strings.VALID_PASSWORD);
            signInPage.clickOnSignInButton();
            assert signInPage.loginElementIsPresent() : "Error. Sign in unsuccessful";
            print("Sign in successful");
    }

    public void searchForASpecificGameByName(ChromeDriver driver) {
            HomePage homePage = new HomePage(driver);
            homePage.enterTextIntoSearchBox(Strings.GAME_NAME);
            homePage.clickOnSearchButton();
            SearchPage searchPage = new SearchPage(driver);
            String gameName = searchPage.getSpecificGameName();
            assert gameName.equals(Strings.GAME_NAME) : "error. Game name is missing from the page, or is different from expected. Expected game name: "
                    + Strings.GAME_NAME + ". Actual game name: " + gameName;
            searchPage.clickOnSpecificGame();
            String gameURL = driver.getCurrentUrl();
            Assert.assertEquals(gameURL, Strings.SPECIFIC_GAME_URL);
            GamePage gamePage = new GamePage(driver);
            String currentPageGameName = gamePage.getSpecificGameName();
            assert currentPageGameName.equals(Strings.GAME_NAME) : "Error. Game name is missing from the page, or is different from expected. Expected game name: "
                    + Strings.GAME_NAME + ". Actual game name: " + currentPageGameName;
            print("Search successful");
    }

    public void addToCartTest(ChromeDriver driver) {
            successfulSignIn(driver);
            searchForASpecificGameByName(driver);
            GamePage gamePage = new GamePage(driver);
            gamePage.clickOnAddToCartButton();
            String cartPageURL = driver.getCurrentUrl();
            Assert.assertEquals(cartPageURL, Strings.CART_PAGE_URL);
            CartPage cartPage = new CartPage(driver);
            assert cartPage.specificGameUpgradeIsPresent() : "Error. Specific game upgrade is not present on the list";
            print("Successfully added to cart");
    }

    public void signInByClickingOnLoginButton(ChromeDriver driver){
            SignInPage signInPage = new SignInPage(driver);
            signInPage.clickOnSignInButton();
            signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
            signInPage.enterPassword(Strings.VALID_PASSWORD);
            signInPage.clickOnSignInButton();
    }
}