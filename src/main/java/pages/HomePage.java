package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import pages.utils.Log;

public class HomePage extends BasePage{

    public HomePage(ChromeDriver driver) {
        super(driver);
    }


    //Page Elements

    @FindBy(xpath = "//a[@class = 'global_action_link']")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class = 'home_ctn']//span[contains(text(),'Sign In')]")
    WebElement signInButton;

    @FindBy (xpath = "//input[@id = 'store_nav_search_term']")
    WebElement searchBox;

    @FindBy (xpath = "//a[@id='store_search_link']//img")
    WebElement searchButton;

    @FindBy (xpath = "//div [@id = 'genre_tab']")
    WebElement categoriesTab;

    @FindBy (xpath = "//a[contains(@class,'popup_menu_item')][normalize-space() = 'Free to Play']")
    WebElement freeToPlaySubcategory;

    @FindBy (xpath = "//span[@id ='account_pulldown']")
    WebElement accountPulldownMenu;

    @FindBy (xpath = "//a[@href='javascript:Logout();']")
    WebElement logoutButton;

    @FindBy (xpath = "//a[normalize-space() = 'View profile']")
    WebElement viewProfileDropdownOption;

    @FindBy (xpath = "//span[@id = 'account_pulldown']")
    WebElement accountBox;


    //Methods

    public BasePage enterTextIntoSearchBox(String text) {
        Log.info("Entering " + text + " into search box");
        Reporter.log("Entering " + text + " into search box");
        waitForElementVisibility(searchBox);
        searchBox.click();
        searchBox.sendKeys(text);
        return this;
    }
    public void clickOnSearchButton() {
        Log.info("Clicking on 'Search' button");
        Reporter.log("Clicking on 'Search' button");
        waitForElementVisibility(searchBox);
        searchButton.click();
    }

    public void hoverOverCategoriesTab() {
        hoverOverElement(categoriesTab);
    }

    public void clickOnFreeToPlaySubcategory() {
        Log.info("Clicking on 'Free to Play' subcategory");
        Reporter.log("Clicking on 'Free to Play' subcategory");
        waitForElementVisibility(freeToPlaySubcategory);
        freeToPlaySubcategory.click();
    }

    public void clickOnAccountPullDownMenu() {
        Log.info("Clicking on account pull-down menu");
        Reporter.log("Clicking on account pull-down menu");
        waitForElementVisibility(accountPulldownMenu);
        accountPulldownMenu.click();
    }

    public void clickOnLogoutButton() {
        Log.info("Clicking on logout button");
        Reporter.log("Clicking on logout button");
        waitForElementToBeClickable(logoutButton);
        logoutButton.click();
    }

    public void clickOnViewProfileDropdownOption() {
        Log.info("Clicking on 'View Profile' drop-down option");
        Reporter.log("Clicking on 'View Profile' drop-down option");
        waitForElementToBeClickable(viewProfileDropdownOption);
        viewProfileDropdownOption.click();
    }

    public boolean accountBoxIsPresent() {
        Log.info("Waiting for account box to be present");
        Reporter.log("Waiting for account box to be present");
        waitForElementVisibility(accountBox);
        if (accountBox.isDisplayed()){
            Log.info("Account box is present");
            Reporter.log("Account box is present");
        }else {
            Log.info("Error. Account box is missing");
            Reporter.log("Error. Account box is missing");
        }
        return verifyElementPresent(accountBox);
    }

    public boolean loginButtonIsPresent() {
        Log.info("Checking whether login button in the top right corner is present");
        Reporter.log("Checking whether login button in the top right corner is present");
        waitForElementVisibility(loginButton);
        if (loginButton.isDisplayed()){
            Log.info("Login button is present");
            Reporter.log("Login button is present");
        }else {
            Log.info("Login button is missing");
            Reporter.log("Login button is missing");
        }
        return verifyElementPresent(loginButton);
    }

}
