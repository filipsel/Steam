package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.utils.Log;

public class ProfilePage extends BasePage{

    public ProfilePage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy (xpath = "//span[@class = 'actual_persona_name']")
    WebElement profileName;

    @FindBy (xpath = "//span[normalize-space() = 'Edit Profile']")
    WebElement editProfileButton;

    @FindBy (xpath = "//div[@class = 'DialogHeader']")
    WebElement dialogueHeader;

    @FindBy (xpath = "//input[@name = 'real_name']")
    WebElement realNameInputBox;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement saveButton;

    @FindBy (xpath = "//a[normalize-space() = 'Back to Your Profile']")
    WebElement backToYourProfileButton;

    @FindBy (xpath = "//bdi[normalize-space() = 'steamtest240']")
    WebElement realNameHeader;


    //Methods

    public String profileNameText() {
        Log.info("Getting profile name");
        Reporter.log("Getting profile name");
        String name= profileName.getText();
        return name;
    }

    public void clickOnEditProfileButton() {
        Log.info("Clicking on 'Edit Profile' button");
        Reporter.log("Clicking on 'Edit Profile' button");
        waitForElementVisibility(editProfileButton);
        editProfileButton.click();
    }

    public String dialogueHeaderText() {
        Log.info("Getting dialogue header text");
        Reporter.log("Getting dialogue header text");
        waitForElementVisibility(dialogueHeader);
        String headerText = dialogueHeader.getText();
        return headerText;
    }

    public void enterNameIntoRealNameInputBox() {
        Log.info("Entering name into 'Real Name' input box");
        Reporter.log("Entering name into 'Real Name' input box");
        waitForElementVisibility(realNameInputBox);
        realNameInputBox.clear();
        realNameInputBox.sendKeys(Strings.PROFILE_NAME);
    }

    public void clickOnSaveButton() {
        Log.info("Clicking on 'Save' button");
        Reporter.log("Clicking on 'Save' button");
        waitForElementToBeClickable(saveButton);
        scrollIntoView(saveButton);
        saveButton.click();
    }

    public void clickOnbBckToYourProfileButton() {
        Log.info("Clicking on 'Back to Your Profile' button");
        Reporter.log("Clicking on 'Back to Your Profile' button");
        waitForElementToBeClickable(backToYourProfileButton);
        scrollIntoView(backToYourProfileButton);
        backToYourProfileButton.click();
    }

    public String realProfileName() {
        Log.info("Getting real profile name");
        Reporter.log("Getting real profile name");
        waitForElementVisibility(realNameHeader);
        return realNameHeader.getText();
    }
}
