import Pages.HomePage;
import Pages.ProfilePage;
import Pages.SignInPage;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTest extends BaseTest{


    /** Open profile settings
     Test steps:
     1. Perform a successful sign in test
     2. Click on 'View profile' from the account pull-down menu
     3.Click on 'Edit profile' button
     4. Enter a specific name into 'Real name' input box
     5. Click on 'Save' button to save your options
     6. Go back to your profile page

     Expected results:
     2. Verify that you are on the 'Profile' page and the profile name is 'steamtest240'
     3. Verify that the page header contains word 'About'
     6.Verify the correct real name appears in header
     */

    @Test
    public void openProfileSettings() {
        ChromeDriver driver = new ChromeDriver();


        try{
            print("1. Perform a successful sign in test");
            successfulSignIn(driver);

            print("2. Click on 'View profile' from the account pull-down menu");
            HomePage homePage = new HomePage(driver);
            homePage.clickOnAccountPulldownMenu();
            homePage.clickOnViewProfileDropdownOption();
            print("2. Verify that you are on the 'Profile' page and the profile name is 'steamtest240'");
            ProfilePage profilePage = new ProfilePage(driver);
            String profileName = profilePage.profileNameText();
            assert profileName.equals(Strings.PROFILE_NAME) : "Error. Profile name ether wrong, or is missing from the page. Expected profile name: "
                    + Strings.PROFILE_NAME + ". Actual profile name: " + profileName;

            print("3.Click on 'Edit profile' button");
            profilePage.clickOnEditProfileButton();
            print("3. Verify that the page header contains word 'About'");
            String pageHeader = profilePage.dialogueHeaderText();
            assert pageHeader.equals("ABOUT") : "Error. Wrong text in page dialogue header. Expected: 'About'. Actual:" + pageHeader;

            print("4. Enter a specific name into 'Real name' input box");
            profilePage.enterNameIntoRealNameInputBox();

            print("5. Click on 'Save' button to save your options");
            profilePage.clickOnSaveButton();

            print("6. Go back to your profile page");
            profilePage.clickOnbBckToYourProfileButton();
            print("6.Verify the correct real name appears in header");
            String realNameHeader = profilePage.realProfileName();
            assert realNameHeader.equals(Strings.PROFILE_NAME) : "Error. Real profile name ether wrong or missing. Expected real profile name: " +
                    Strings.PROFILE_NAME + ". Actual real profile name: " + realNameHeader;

            print("Test successful");

        }finally {
            driver.quit();
        }
    }
}
