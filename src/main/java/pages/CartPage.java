package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.utils.Log;

import java.lang.annotation.RetentionPolicy;
import java.util.*;

public class CartPage extends BasePage {

    public CartPage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy(xpath = "//h2[@class = 'pageheader']")
    WebElement pageHeader;

    @FindBy(xpath = "//a[@class = 'remove_link']")
    WebElement removeButton;

    @FindBy(xpath = "//span[normalize-space() = 'Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[normalize-space() = 'CS:GO Prime Status Upgrade']")
    WebElement specificGameUpgrade;

    @FindBy(xpath = "//div[@class = 'cart_status_message']")
    WebElement cartStatusMessage;

    @FindBy(xpath = "//a[normalize-space() = 'Valve Complete Pack']")
    WebElement valveCompletePack;

    @FindBy(xpath = "//a[normalize-space() = 'CS:GO Prime Status Upgrade']")
    WebElement cSGoPrimeStatusUpgrade;

    @FindBy(xpath = "//a[normalize-space() = 'Remove all items']")
    WebElement removeAllItemsButton;

    @FindBy(xpath = "//span[normalize-space() = 'Yes']")
    WebElement confirmationButton;

    //Methods

    public String pageHeaderText() {
        Log.info("Getting page header text");
        Reporter.log("Getting page header text");
        return pageHeader.getText();
    }

    public String cartStatusMessageRemovedItem() {
        Log.info("Getting cart status message");
        Reporter.log("Getting cart status message");
        return cartStatusMessage.getText();
    }

    public boolean specificGameUpgradeIsPresent() {
        Log.info("Checking whether specific game upgrade is present");
        Reporter.log("Checking whether specific game upgrade is present");
        waitForElementVisibility(specificGameUpgrade);
        if (specificGameUpgrade.isDisplayed()){
            Log.info("Specific game upgrade is present");
            Reporter.log("Specific game upgrade is present");
        }else {
            Log.error("Specific game upgrade is missing");
            Reporter.log("Specific game upgrade is missing");
        }
        return verifyElementPresent(specificGameUpgrade);
    }

    public void removeGameFromCart() {
        Log.info("Removing the game from cart");
        Reporter.log("Removing the game from cart");
        waitForElementToBeClickable(removeButton);
        removeButton.click();
    }

    public void clickOnRemoveAllItemsButton() {
        Log.info("Removing all items from cart");
        Reporter.log("Removing all items from cart");
        removeAllItemsButton.click();
    }

    public ArrayList<WebElement> getNumberOfGamesInTheCart() {
        ArrayList<WebElement> numberOfGames = new ArrayList<>();
        numberOfGames.add(cSGoPrimeStatusUpgrade);
        numberOfGames.add(valveCompletePack);
        return numberOfGames;
    }

    public void clickOnConfirmationButton() {
        Log.info("Confirming by clicking on 'Yes' button");
        Reporter.log("Confirming by clicking on 'Yes' button");
        waitForElementToBeClickable(confirmationButton);
        if (confirmationButton.isDisplayed()) {
            confirmationButton.click();
        }
    }
}
