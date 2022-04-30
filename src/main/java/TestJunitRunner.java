import jdk.jfr.Name;
import managers.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestJunitRunner {
    WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");

    @BeforeAll

    @BeforeEach
    public void configureTestPreconditions() {
        webDriverManagerObiect.getDriverul().get("https://demo-opencart.com/");
    }

    @AfterEach
    public void tearDownActivities() {
        webDriverManagerObiect.getDriverul().close();
        webDriverManagerObiect.getDriverul().quit();
    }

    @Test
    @DisplayName("The Registration page can be accesed from navigation bar")
    public void registerPageIsOpened() throws InterruptedException {
        HomePage homePage = new HomePage(webDriverManagerObiect.getDriverul());
        homePage.navigateToRegisterPageViaHeader();

        boolean containsCorrectUrlEndpoint = webDriverManagerObiect.getDriverul().getCurrentUrl().contains("/index.php?route=account/register");
        Assert.assertTrue("The actual url does not contain the correct endpoint", containsCorrectUrlEndpoint);
    }

    @Test
    @DisplayName("Correct error message is displayed when trying to create e user without checking the privacy policy")
    public void anErrorMessageIsDisplayedWhenCreatingAnAccountAcceptingThePrivacyPolicy() throws InterruptedException {
        HomePage homePage = new HomePage(webDriverManagerObiect.getDriverul());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObiect.getDriverul());
        registerPage.populateRegisterForWithData("Diana", "Preda", "dianapreda@ymail.com", "079112260", "Parolagrea123", "Parolagrea123");
        registerPage.clickContinueBtn();

        WebElement errorMessageForLackOfPrivacy = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));

        String expectedErrorText = "Warning: You must agree to the Privacy Policy!";
        String actualErrorText = errorMessageForLackOfPrivacy.getText();

        Assertions.assertEquals(expectedErrorText, actualErrorText, "The error message is not corect, please check the actual result.");
    }
}