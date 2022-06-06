package pages;

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
        waitForElementVisibility(pageHeader);
        return pageHeader.getText();
    }


    public void clickOnTopSellersButton() {
        print("clickOnTopSellersButton");
        waitForElementVisibility(topSellersButton);
        scrollIntoView(topSellersButton);
        topSellersButton.click();
    }

    public boolean specificGameIsPresent() {
        waitForElementVisibility(specificGame);
        return elementPresent(specificGame);
    }

    public void clickOnSpecificGame(String gameName) {
        print("clickOnDesiredGame");
        String xpath = "//a[contains(@class,'app_impression_tracked')]//div[contains(@class,'tab_item_name')][normalize-space()=" + gameName + "]";
        specificGame.click();
    }

}
