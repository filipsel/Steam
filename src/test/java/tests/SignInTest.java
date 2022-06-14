package tests;

import org.testng.Assert;
import org.testng.Reporter;
import pages.HomePage;
import pages.SignInPage;
import pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.utils.Log;

import static org.testng.TestRunner.PriorityWeight.priority;

public class SignInTest extends BaseTest {

    /** Successful Login Test
    Test steps:
    1. Navigate to Sign In page
    2. Enter valid Steam Account Name
    3. Enter valid Password
    4. Click on 'Sign In' button

    Expected result:
    4. Verify that Your profile name is present in the top right corner
     */

    @Test (priority = 1)

    public void successfulSignIn() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Navigate to Sign In page");
            Log.info("Navigating to 'Sign In' page");
            Reporter.log("Navigating to 'Sign In' page");
            SignInPage signInPage = new SignInPage(driver);

            print("2. Enter valid Steam Account Name");
            signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);

            print("3. Enter valid Password");
            signInPage.enterPassword(Strings.VALID_PASSWORD);

            print("4. Click on 'Sign In' button");
            signInPage.clickOnSignInButton();

            HomePage homePage = new HomePage(driver);
            print("4. Verify that Your profile name is present at the top right corner");
            assert homePage.accountBoxIsPresent() : "Error. Element is not present";

        }finally {
            driver.quit();
        }
    }

    /** Successfully sign in and sign out of Steam account
    Test steps:
    1. Successfully sign in to Steam
    2. Click on account pull-down menu
    3. Click on 'logout' button

    Expected results:
    3. Verify that the account pull-down menu with user's name is not present, meaning that the user has successfully logged out of their account
     */

    @Test (priority = 2)


    //Napisi test korake
    public void successfullySignInAndSignOut() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Successfully sign in to Steam");
            successfulSignIn(driver);

            HomePage homePage = new HomePage(driver);
            print("2. Click on account pull-down menu");
            homePage.clickOnAccountPullDownMenu();

            print("3. Click on 'logout' button");
            homePage.clickOnLogoutButton();
            print("3. Verify that the account pull-down menu with user's name is not present, meaning that the user has successfully logged out of their account");
            assert homePage.loginButtonIsPresent() : "Error. Login button is not present. User is not logged out of their account";

        }finally {
            driver.quit();

        }
    }

    /** Sign in with invalid Steam Account name and valid Password
    Test steps:
    1. Navigate to Sign In page
    2. Enter invalid Steam Account Name
    3. Enter valid Password
    4. Click on 'Sign In' button

    Expected results:
    4. Verify that the expected error message is displayed
     */

    @Test (priority = 3)

    public void signInWithInvalidSteamAccountNameAndValidPassword() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Navigate to Sign In page");
            SignInPage signInPage = new SignInPage(driver);
            print("2. Enter invalid Steam Account Name");
            signInPage.enterSteamAccountName(Strings.INVALID_STEAM_ACCOUNT_NAME);
            print("3. Enter valid Password");
            signInPage.enterPassword(Strings.VALID_PASSWORD);
            print("4. Click on 'Sign In' button");
            signInPage.clickOnSignInButton();

            print("4. Verify that the expected error message is displayed");
            String errorMessage = signInPage.errorMessageInTheBox();
            assert errorMessage.equals(Strings.SIGN_IN_ERROR_MESSAGE) : "Test unsuccessful, incorrect error message is displayed. Expected error message: " +
                    Strings.SIGN_IN_ERROR_MESSAGE + ". Actual error message displayed: " + errorMessage;
            Reporter.log("Displayed error message: "+ errorMessage);

        }finally {
            driver.quit();
        }
    }

    /** Sign in with valid Steam Account name and invalid Password
    Test steps:
    1. Navigate to Sign In page
    2. Enter valid Steam Account Name
    3. Enter invalid Password
    4. Click on 'Sign In' button

    Expected result:
    4. Verify that the expected error message is displayed
     */

    @Test (priority = 4)

    public void signInWithValidSteamAccountNameAndInvalidPassword() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Navigate to Sign In page");
            SignInPage signInPage = new SignInPage(driver);
            print("2. Enter valid Steam Account Name");
            signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
            print("3. Enter invalid Password");
            signInPage.enterPassword(Strings.INVALID_PASSWORD);
            print("4. Click on 'Sign In' button");
            signInPage.clickOnSignInButton();

            print("4. Verify that the expected error message is displayed");
            String errorMessage = signInPage.errorMessageInTheBox();
            assert errorMessage.equals(Strings.SIGN_IN_ERROR_MESSAGE) : "Test unsuccessful, incorrect error message is displayed. Expected error message: " +
                    Strings.SIGN_IN_ERROR_MESSAGE + ". Actual error message displayed: " + errorMessage;
            Reporter.log("Displayed error message: "+ errorMessage);

        }finally {
            driver.quit();
        }
    }

    /** Sign in with invalid credentials
    Test steps:
    1. Navigate to Sign In page
    2. Enter invalid Steam Account Name
    3. Enter invalid Password
    4. Click on 'Sign In' button

    Expected result:
    4. Verify that the expected error message is displayed
     */

    @Test (priority = 5)

    public void signInWithInvalidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Navigate to Sign In page");
            SignInPage signInPage = new SignInPage(driver);
            print("2. Enter valid Steam Account Name");
            signInPage.enterSteamAccountName(Strings.INVALID_STEAM_ACCOUNT_NAME);
            print("3. Enter invalid Password");
            signInPage.enterPassword(Strings.INVALID_PASSWORD);
            print("4. Click on 'Sign In' button");
            signInPage.clickOnSignInButton();

            print("4. Verify that the expected error message is displayed");
            String errorMessage = signInPage.errorMessageInTheBox();
            assert errorMessage.equals(Strings.SIGN_IN_ERROR_MESSAGE) : "Test unsuccessful, incorrect error message is displayed. Expected error message: " +
                    Strings.SIGN_IN_ERROR_MESSAGE + ". Actual error message displayed: " + errorMessage;
            Reporter.log("Displayed error message: "+ errorMessage);

        }finally {
            driver.quit();
        }
    }
}
