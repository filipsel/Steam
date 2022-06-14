package tests;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import tests.utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class BaseTest {
    ChromeDriver driver;

    public ChromeDriver openChromeDriver() {
        Log.info("Starting up ChromeDriver");
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
        Log.info("Performing a successful sign in");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
        signInPage.enterPassword(Strings.VALID_PASSWORD);
        signInPage.clickOnSignInButton();
        HomePage homePage = new HomePage(driver);
        assert homePage.accountBoxIsPresent() : "Error. Sign in unsuccessful";
        Log.info("Sign in successful");
    }

    public void searchForASpecificGameByName(ChromeDriver driver) {
        Log.info("Searching for a specific game by name");
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
        Log.info("Search successful");
    }

    public void addToCart(ChromeDriver driver) {
        Log.info("Successfully adding a specific game to cart");
        successfulSignIn(driver);
        searchForASpecificGameByName(driver);
        GamePage gamePage = new GamePage(driver);
        gamePage.clickOnAddToCartButtonForPrimeStatusUpgrade();
        String cartPageURL = driver.getCurrentUrl();
        Assert.assertEquals(cartPageURL, Strings.CART_PAGE_URL);
        CartPage cartPage = new CartPage(driver);
        assert cartPage.specificGameUpgradeIsPresent() : "Error. Specific game upgrade is not present on the list";
        Log.info("Successfully added to cart");
    }

    public void signInByClickingOnLoginButton(ChromeDriver driver) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickOnSignInButton();
        signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
        signInPage.enterPassword(Strings.VALID_PASSWORD);
        signInPage.clickOnSignInButton();
    }

    public boolean numberOfItemsOnTheList(ArrayList<WebElement> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.size() == 2) {
                return true;
            } else if (arrayList.size() == 0) {
                return true;
            }
        }
        return false;
    }

    @AfterMethod

    public void onTestFailure(@NotNull ITestResult arg0) {
        if (arg0.getStatus() == ITestResult.FAILURE) {
            Log.info("Failure detected...");
            String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
            ChromeDriver driver = openChromeDriver();
            arg0.getTestContext().getAttribute("webDriver");
            TakesScreenshot ts = (TakesScreenshot) (driver);
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./screenshots/" + fileName);
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
            Log.info("Screenshot taken");
        }
    }

    @AfterMethod

    public ITestResult printResult(@NotNull ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            print("Test successful");
            return result;
        } else {
            print("Test unsuccessful");
        }
        return result;
    }
}