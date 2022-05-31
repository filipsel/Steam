package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h2[@class = 'pageheader']")
    WebElement pageHeader;

    @FindBy (xpath = "//a[@class = 'remove_link']")
    WebElement removeButton;

    @FindBy (xpath = "//span[normalize-space()='Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy (xpath = "//a[normalize-space()='CS:GO Prime Status Upgrade']")
    WebElement specificGameUpgrade;

    @FindBy (xpath = "//div[@class='cart_status_message']")
    WebElement cartStatusMessage;

    public String pageHeaderText() {
        return pageHeader.getText();
    }

    public String cartStatusMessageRemovedItem() {
        return cartStatusMessage.getText();
    }

    public boolean specificGameUpgradeIsPresent() {
        waitForElementVisibility(specificGameUpgrade);
        return presentElement(specificGameUpgrade);
    }

    public void removeGameFromCart() {
        print("removeGameFromCart");
        waitForElementVisibility(removeButton);
        removeButton.click();
    }
}
