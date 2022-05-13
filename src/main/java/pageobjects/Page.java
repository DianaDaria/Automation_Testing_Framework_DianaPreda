package pageobjects;

import managers.PropertiesManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    private WebElement searchBtn;

    protected final String BASE_URL = PropertiesManager.getBaseUrl();

    public void navigateToRegisterPageViaHeader() {
        myAccountIcon.click();
        registerBtn.click();
    }

    public void perfomSearchFor(String valoareCautata) {
        searchInputField.sendKeys(valoareCautata);
        searchBtn.click();
    }

    public void clearSearchField() {
        searchInputField.click();
    }

    public static void navigateToPage(String pageName, WebDriver driver) {
        Method definedMethod;
        try {
            definedMethod = Class.forName("pageobjects." + pageName).getMethod("goToPage");
            definedMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pageContainsCorrectEndpoint(String pageName, WebDriver webDriver) {
        Method defineMethod;
        try {
            defineMethod = Class.forName("pageobjects." + pageName).getMethod("getENDPOINT");
            String valoareaEndpoint = (String) defineMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(webDriver));
            String valoareaActualaEndpoint = webDriver.getCurrentUrl();
            Assertions.assertTrue(valoareaActualaEndpoint.contains(valoareaEndpoint), "The ENDPOINT defined in the pageObject of" + pageName + "page is not present within the current URL address");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}