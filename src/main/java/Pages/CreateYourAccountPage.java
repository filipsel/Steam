package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateYourAccountPage {

    ChromeDriver driver;

    @FindBy (xpath = "//input[@id = 'email']")
    WebElement emailAdressField;

    @FindBy (xpath = "//input[@id = 'reenter_email']")
    WebElement reenterEmailField;

    @FindBy (xpath = "//select[@id = 'country']//option[@value = 'RS']")
    WebElement countryOfResidenceChooseSerbia;

    @FindBy (xpath = "//span[@id = 'recaptcha-anchor']")
    WebElement reCaptchaBox;

    @FindBy (xpath = "//input[@id = 'i_agree_checkbox']")
    WebElement privacyPolicyCheckbox;

    @FindBy (xpath = "//button[@id = 'createAccountButton']")
    WebElement continueButton;


    public CreateYourAccountPage (ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
