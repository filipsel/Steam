package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import pages.utils.Log;

public class RegistrationPage extends BasePage{

    public RegistrationPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.CREATE_YOUR_ACCOUNT_URL);
        waitForElementToBeClickable(continueButton);
    }


    //Page elements

    @FindBy (xpath = "//input[@id = 'email']")
    WebElement emailAddressField;

    @FindBy (xpath = "//input[@id = 'reenter_email']")
    WebElement confirmYourAddressField;

    @FindBy (xpath = "//select[@id = 'country']")
    WebElement countryOfResidenceDropDownMenu;

    @FindBy (xpath = "//input[@type = 'checkbox']")
    WebElement iAgreeCheckbox;

    @FindBy (xpath = "//button[@id = 'createAccountButton']//span[contains(text(),'Continue')]")
    WebElement continueButton;

    @FindBy (xpath = "//div[@id = 'error_display']")
    WebElement errorDisplay;


    //Method for selecting Serbia from the country of residence drop-down menu
    public void selectIcelandFromCountryOfResidenceDropDownMenu(String value) {
        Log.info("Selecting Iceland from 'Country of Residence' drop-down menu");
        Reporter.log("Selecting Iceland from 'Country of Residence' drop-down menu");
        Select dropDownMenu = new Select(countryOfResidenceDropDownMenu);
        dropDownMenu.selectByValue(value);
    }

    public RegistrationPage enterExistingEmailAddress() {
        Log.info("Entering existing email address: " + Strings.VALID_EMAIL_ADDRESS);
        Reporter.log("Entering existing email address: " + Strings.VALID_EMAIL_ADDRESS);
        emailAddressField.click();
        emailAddressField.sendKeys(Strings.VALID_EMAIL_ADDRESS);
        return this;
    }

    public RegistrationPage enterExistingEmailIntoConfirmYourAddressField() {
        Log.info("Entering existing email " + Strings.VALID_EMAIL_ADDRESS + " into 'Confirm Your Address' field");
        Reporter.log("Entering existing email " + Strings.VALID_EMAIL_ADDRESS + " into 'Confirm Your Address' field");
        confirmYourAddressField.click();
        confirmYourAddressField.sendKeys(Strings.VALID_EMAIL_ADDRESS);
        return this;
    }


    public void clickOnIAgreeCheckbox() {
        Log.info("Clicking on 'I aggree' checkbox");
        Reporter.log("Clicking on 'I aggree' checkbox");
        scrollIntoView(iAgreeCheckbox);
        waitForElementVisibility(iAgreeCheckbox);
        waitForElementToBeClickable(iAgreeCheckbox);
        clickOnElement(iAgreeCheckbox);
    }

    public void submitCredentials() {
        Log.info("Submitting credentials");
        Reporter.log("Submitting credentials");
        waitForElementToBeClickable(continueButton);
        scrollIntoView(continueButton);
        continueButton.submit();
    }

    public String errorDisplayMessage() {
        Log.info("Getting error display message");
        Reporter.log("Getting error display message");
        waitForElementVisibility(errorDisplay);
        scrollIntoView(errorDisplay);
        return errorDisplay.getText();
    }

}
