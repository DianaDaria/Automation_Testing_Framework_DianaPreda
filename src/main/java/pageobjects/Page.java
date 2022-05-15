package pageobjects;

import managers.WebDriverWaiterManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    private WebElement searchBtn;

    public void navigateToRegisterPageViaHeader() {
        WebDriverWaiterManager.waitElementToBeVisible(myAccountIcon, driver);
        myAccountIcon.click();
        WebDriverWaiterManager.waitElementToBeVisible(registerBtn, driver);
        WebDriverWaiterManager.waitElementToBeClickable(registerBtn, driver);
        registerBtn.click();
    }

    public void perfomSearchFor(String valoareCautata) {
        searchInputField.sendKeys(valoareCautata);
        searchBtn.click();
    }

    public void clearSearchField() {
        searchInputField.click();
    }
}