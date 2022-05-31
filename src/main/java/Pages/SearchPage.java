package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(ChromeDriver driver) {super(driver);}


    @FindBy (xpath = "//span[normalize-space()='Counter-Strike: Global Offensive']")
    WebElement specificGame;

    public String getSpecificGameName() {
        print("getSpecificGameName");
        return specificGame.getText();
    }

            public void clickOnSpecificGame () {
            print("clickOnSpecificGame");
            waitForElementVisibility(specificGame);
            specificGame.click();
        }

}





