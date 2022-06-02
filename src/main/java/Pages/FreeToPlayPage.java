package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class FreeToPlayPage extends BasePage{

    public FreeToPlayPage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy (xpath = "//h2[@class='pageheader']")
    WebElement pageHeader;

    @FindBy (xpath = "//div[contains(text(),'Top Sellers')]")
    WebElement topSellersButton;

    @FindBy (xpath = "//a[contains(@class,'app_impression_tracked')]//div[contains(@class,'tab_item_name')][normalize-space()='Counter-Strike: Global Offensive']")
    WebElement specificGame;


    //Methods

    public String pageHeaderText() {
        return pageHeader.getText();
    }


    public void clickOnTopSellersButton() {
        waitForElementVisibility(topSellersButton);
        scrollIntoView(topSellersButton);
        topSellersButton.click();
    }

    public boolean specificGameIsPresent() {
        waitForElementVisibility(specificGame);
        return presentElement(specificGame);
    }

    public void clickOnDesiredGame () {
        specificGame.click();
    }

}
