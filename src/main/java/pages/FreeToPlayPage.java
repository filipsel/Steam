package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.utils.Log;

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
        Log.info("Getting page header text");
        Reporter.log("Getting page header text");
        waitForElementVisibility(pageHeader);
        return pageHeader.getText();
    }


    public void clickOnTopSellersButton() {
        Log.info("Clicking on 'Top Sellers' button");
        Reporter.log("Clicking on 'Top Sellers' button");
        waitForElementVisibility(topSellersButton);
        scrollIntoView(topSellersButton);
        topSellersButton.click();
    }

    public boolean specificGameIsPresent() {
        Log.info("Checking whether specific game is present");
        Reporter.log("Checking whether specific game is present");
        waitForElementVisibility(specificGame);
        if (specificGame.isDisplayed()){
            Log.info("Specific game is present");
            Reporter.log("Specific game is present");
        }else {
            Log.error("Error. Specific game is missing");
            Reporter.log("Error. Specific game is missing");
        }
        return verifyElementPresent(specificGame);
    }

    public void clickOnSpecificGame(String gameName) {
        Log.info("Clicking on specific game: " + gameName);
        Reporter.log("Clicking on specific game: " + gameName);
        String xpath = "//a[contains(@class,'app_impression_tracked')]//div[contains(@class,'tab_item_name')][normalize-space()=" + gameName + "]";
        specificGame.click();
    }

}
