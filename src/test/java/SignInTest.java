import Pages.SignInPage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.URL;

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

    @Test
    public void successfulSignIn() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("1. Navigate to Sign In page");
            SignInPage signInPage = new SignInPage(driver);
            print("2. Enter valid Steam Account Name");
            signInPage.enterSteamAccountName(Strings.VALID_STEAM_ACCOUNT_NAME);
            print("3. Enter valid Password");
            signInPage.enterPassword(Strings.VALID_PASSWORD);
            print("4. Click on 'Sign In' button");
            signInPage.clickOnSignInButton();

            print("4. Verify that Your profile name is present at the top right corner");
            assert signInPage.loginElementIsPresent() : "Error. Element is not present";
            print("Test successful");

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

    @Test
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
            print("Test successful");

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

    @Test
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
            print("Test successful");

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

    @Test
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
            print("Test successful");

        }finally {
            driver.quit();
        }
    }
}
