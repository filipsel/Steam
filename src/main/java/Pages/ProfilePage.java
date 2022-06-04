package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

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
        String name= profileName.getText();
        return name;
    }

    public void clickOnEditProfileButton() {
        waitForElementVisibility(editProfileButton);
        editProfileButton.click();
    }

    public String dialogueHeaderText() {
        waitForElementVisibility(dialogueHeader);
        String headerText = dialogueHeader.getText();
        return headerText;
    }

    public void enterNameIntoRealNameInputBox() {
        waitForElementVisibility(realNameInputBox);
        realNameInputBox.clear();
        realNameInputBox.sendKeys(Strings.PROFILE_NAME);
    }

    public void clickOnSaveButton() {
        print("clickOnSaveButton");
        waitForElementToBeClickable(saveButton);
        scrollIntoView(saveButton);
        saveButton.click();
    }

    public void clickOnbBckToYourProfileButton() {
        print("clickOnbBckToYourProfileButton");
        waitForElementToBeClickable(backToYourProfileButton);
        scrollIntoView(backToYourProfileButton);
        backToYourProfileButton.click();
    }

    public String realProfileName() {
        waitForElementVisibility(realNameHeader);
        return realNameHeader.getText();
    }
}
