package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(ChromeDriver driver) {super(driver);}


    //Page elements

    @FindBy (xpath = "//span[normalize-space()='Counter-Strike: Global Offensive']")
    WebElement specificGame;


    //Methods

    public String getSpecificGameName() {
        print("Getting specific game name");
        return specificGame.getText();
    }

            public void clickOnSpecificGame () {
            print("Clicking on specific game");
            waitForElementVisibility(specificGame);
            specificGame.click();
        }

}





