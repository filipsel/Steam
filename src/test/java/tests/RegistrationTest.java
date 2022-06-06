package tests;

import pages.RegistrationPage;
import pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RegistrationTest extends BaseTest {

    /** Attempt to register with existing user credentials
    Test steps:
    1. Navigate to registration page
    2. Enter existing credentials
    3. Select Iceland from country of residence drop-down menu
    4. Check the 'terms and agreements' checkbox
    5. Submit credentials by clicking on 'Continue' button

    Expected results:
    5. Verify that you are still on the registration page and an error message is displayed
    */

    @Test
    public void attemptRegistrationWithExistingUserCredentials() {
        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Navigate to registration page");
            RegistrationPage registrationPage = new RegistrationPage(driver);

            print("2. Enter existing credentials");
            registrationPage.enterExistingEmailAddress()
                    .enterExistingEmailIntoConfirmYourAddressField();

            print("3. Select Iceland from country of residence drop-down menu");
            registrationPage.selectIcelandFromCountryOfResidenceDropDownMenu(Strings.SELECT_ICELAND);

            print("4. Check the 'terms and agreements' checkbox");
            registrationPage.clickOnIAgreeCheckbox();

            print("5. Submit credentials by clicking on 'Continue' button");
            registrationPage.submitCredentials();
            print("5. Verify that you are still on the registration page and an error message is displayed");
            String errorMessage = registrationPage.errorDisplayMessage();
            assert errorMessage.equals(Strings.REGISTRATION_ERROR_MESSAGE) : "Error. Registration error message not present. Expected error message: " +
                    Strings.REGISTRATION_ERROR_MESSAGE + ". Actual error message: " + errorMessage;

            print("Test successful");

        } finally {
            driver.quit();
        }
    }
}
