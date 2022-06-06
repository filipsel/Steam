package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

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

    @FindBy (xpath = "//a[normalize-space() = 'View profile']")
    WebElement viewProfileDropdownOption;


    //Methods

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
        print("Clicking on 'Free to Play' subcategory");
        waitForElementVisibility(freeToPlaySubcategory);
        freeToPlaySubcategory.click();
    }

    public void clickOnAccountPullDownMenu() {
        print("Clicking on account pull-down menu");
        waitForElementVisibility(accountPulldownMenu);
        accountPulldownMenu.click();
    }

    public void clickOnViewProfileDropdownOption() {
        print("Clicking on 'View Profile' drop-down option");
        waitForElementToBeClickable(viewProfileDropdownOption);
        viewProfileDropdownOption.click();
    }

}