package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SignInPage extends BasePage {

    //Page elements:
    @FindBy (xpath = "//div[@class = 'login_btn_ctn']//span[contains(text(),'Sign In')]")
    WebElement signInButton;

    @FindBy (xpath = "//input[@id = 'input_username']")
    WebElement steamAccountNameField;

    @FindBy (xpath = "//input[@id = 'input_password']")
    WebElement passwordField;

    @FindBy (xpath = "//input[@id = 'remember_login']")
    WebElement rememberMeOnThisComputerCheckbox;

    @FindBy (xpath = "//span[@id = 'account_pulldown']")
    WebElement accountBox;

    @FindBy (xpath = "//div[@id = 'error_display']")
    WebElement errorDisplayBox;


    @FindBy (xpath = "div[@class = 'login_btn_ctn']//span[contains(text(),'Join Steam')]")
    WebElement joinSteamButton;


    //Methods

    public SignInPage(ChromeDriver driver) {
        super(driver);
        driver.get (Strings.LOGIN_PAGE_URL);
        waitForElementVisibility(signInButton);
    }

    public SignInPage enterSteamAccountName (String text) {
        print("Entering " + text + " in the 'Steam account name' field");
        steamAccountNameField.click();
        steamAccountNameField.sendKeys(text);
        return this;
    }

    public SignInPage enterPassword(String text) {
        print("Entering " + text + " in the password field");
        passwordField.click();
        passwordField.sendKeys(text);
        return this;
    }

    public void clickOnSignInButton() {
        print("Clicking on 'Sign in' button");
        signInButton.click();
    }

    public boolean accountBoxIsPresent() {
        print("Waiting for account box to be present");
        waitForElementVisibility(accountBox);
        return elementPresent(accountBox);
    }

    public String errorMessageInTheBox() {
        print("Getting error message in the box");
        waitForElementVisibility(errorDisplayBox);
        return errorDisplayBox.getText();
    }

}
