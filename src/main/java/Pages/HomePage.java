package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    public HomePage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class = 'global_action_link']")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class = 'home_ctn']//span[contains(text(),'Sign In')]")
    WebElement signInButton;

    @FindBy (xpath = "//input[@id = 'store_nav_search_term']")
    WebElement searchBox;

    @FindBy (xpath = "//img[@src = 'https://store.akamai.steamstatic.com/public/images/blank.gif']")
    WebElement searchButton;

    @FindBy (xpath = "//div [@id = 'genre_tab']")
    WebElement categoriesTab;

    @FindBy (xpath = "//a[contains(@class,'popup_menu_item')][normalize-space() = 'Free to Play']")
    WebElement freeToPlaySubcategory;

    @FindBy (xpath = "//span[@id ='account_pulldown']")
    WebElement accountPulldownMenu;

    @FindBy (xpath = "//a[normalize-space() = 'View profile']")
    WebElement viewProfileDropdownOption;

    public BasePage enterTextIntoSearchBox(String text) {
        waitForElementVisibility(searchBox);
        searchBox.click();
        searchBox.sendKeys(text);
        return this;
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnLoginButton() {
        waitForElementVisibility(loginButton);
        loginButton.click();
    }

    public void hoverOverCategoriesTab() {
        hoverOverElement(categoriesTab);
    }

    public void clickOnFreeToPlaySubcategory() {
        waitForElementVisibility(freeToPlaySubcategory);
        freeToPlaySubcategory.click();
    }

    public void clickOnAccountPulldownMenu() {
        waitForElementVisibility(accountPulldownMenu);
        accountPulldownMenu.click();
    }

    public void clickOnViewProfileDropdownOption() {
        waitForElementToBeClickable(viewProfileDropdownOption);
        viewProfileDropdownOption.click();
    }

}
