import managers.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager fireFoxDriveManager = new WebDriverManager("FireFox");
//        fireFoxDriveManager.getDriverul().get("https://demo.opencart.com/");
//        fireFoxDriveManager.getDriverul().close();

        WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");
        System.out.println(webDriverManagerObiect.getDriverul());
        webDriverManagerObiect.getDriverul().get("https://demo-opencart.com/");

        HomePage homePage = new HomePage(webDriverManagerObiect.getDriverul());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObiect.getDriverul());
        registerPage.populateRegisterForWithData("Cindy", "Williams", "CindyWilliams@ymail.com", "022265236", "HardPassword2022", "HardPassword2022");
        registerPage.clickContinueBtn();

        registerPage.perfomSearchFor("Apple");
        registerPage.clearSearchField();
        registerPage.perfomSearchFor("Samsung");

//        firstNameInputField.sendKeys("Cindy");
//        lastNameInputField.sendKeys("Williams");
//        emailInputField.sendKeys("CindyWilliams@ymail.com");
//        phoneInputField.sendKeys("022265236");
//        passwordInput.sendKeys("HardPassword2022");
//        confirmPasswordInputField.sendKeys("DIP");
//        confirmPasswordInputField.clear();
//        confirmPasswordInputField.sendKeys("HardPassword2022");

        Thread.sleep(Long.parseLong("30000"));
        webDriverManagerObiect.getDriverul().close();
    }
}