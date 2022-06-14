package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.utils.Log;

public class SearchPage extends BasePage {

    public SearchPage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy(xpath = "//span[normalize-space()='Counter-Strike: Global Offensive']")
    WebElement specificGame;


    //Methods

    public String getSpecificGameName() {
        Log.info("Getting specific game name");
        Reporter.log("Getting specific game name");
        return specificGame.getText();
    }

    public void clickOnSpecificGame() {
        Log.info("Clicking on specific game");
        Reporter.log("Clicking on specific game");
        waitForElementVisibility(specificGame);
        specificGame.click();
    }

}





