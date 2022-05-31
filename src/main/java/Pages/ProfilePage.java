package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    public ProfilePage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[@class = 'actual_persona_name']")
    WebElement profileName;

    @FindBy (xpath = "//span[normalize-space()='Edit Profile']")
    WebElement editProfileButton;

    @FindBy (xpath = "//div[@class='DialogHeader']")
    WebElement dialogueHeader;

    @FindBy (xpath = "//input[@name='real_name']")
    WebElement realNameInputBox;

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

    public String enterNameIntoRealNameInputBox() {
        waitForElementVisibility(realNameInputBox);
        realNameInputBox.clear();
        realNameInputBox.sendKeys(Strings.PROFILE_NAME);
        return enterNameIntoRealNameInputBox();
    }
}
