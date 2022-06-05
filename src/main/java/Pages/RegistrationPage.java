package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
        Select dropDownMenu = new Select(countryOfResidenceDropDownMenu);
        dropDownMenu.selectByValue(value);
    }

    public RegistrationPage enterExistingEmailAddress() {
        print("enterExistingEmailAddress");
        emailAddressField.click();
        emailAddressField.sendKeys(Strings.VALID_EMAIL_ADDRESS);
        return this;
    }

    public RegistrationPage enterExistingEmailIntoConfirmYourAddressField() {
        print("enterExistingEmailIntoConfirmYourAddressField");
        confirmYourAddressField.click();
        confirmYourAddressField.sendKeys(Strings.VALID_EMAIL_ADDRESS);
        return this;
    }

    //Method for switching to an iFrame and clicking on reCAPTCHA checkbox


    public void clickOnIAgreeCheckbox() {
        print("clickOnIAgreeCheckbox");
        scrollIntoView(iAgreeCheckbox);
        waitForElementVisibility(iAgreeCheckbox);
        waitForElementToBeClickable(iAgreeCheckbox);
        clickOnElement(iAgreeCheckbox);
    }

    public void submitCredentials() {
        waitForElementToBeClickable(continueButton);
        scrollIntoView(continueButton);
        continueButton.submit();
    }

    public String errorDisplayMessage() {
        waitForElementVisibility(errorDisplay);
        scrollIntoView(errorDisplay);
        return errorDisplay.getText();
    }

}
