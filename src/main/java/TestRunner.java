import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager fireFoxDriveManager = new WebDriverManager("FireFox");
//        fireFoxDriveManager.getDriverul().get("https://demo.opencart.com/");
//        fireFoxDriveManager.getDriverul().close();

        WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");
        System.out.println(webDriverManagerObiect.getDriverul());
        webDriverManagerObiect.getDriverul().get("https://demo.opencart.com/");

        WebElement myAccountIcon = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccountIcon.click();
        Thread.sleep(1000);

        WebElement registerButton = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerButton.click();
        Thread.sleep(1000);

        //Actiuni asupra paginii de Registration
        WebElement firstNameInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        WebElement lastNameInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        WebElement emailInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-email\"]"));
        WebElement phoneInputField = webDriverManagerObiect.getDriverul().findElement(By.cssSelector("#input-telephone"));
        WebElement passwordInput = webDriverManagerObiect.getDriverul().findElement(By.id("input-password"));
        WebElement confirmPasswordInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        WebElement continueButton = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstNameInputField.sendKeys("Cindy");
        lastNameInputField.sendKeys("Williams");
        emailInputField.sendKeys("CindyWilliams@ymail.com");
        phoneInputField.sendKeys("022265236");
        passwordInput.sendKeys("HardPassword2022");
        confirmPasswordInputField.sendKeys("DIP");
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys("HardPassword2022");

        continueButton.click();

        Thread.sleep(Long.parseLong("30000"));

        webDriverManagerObiect.getDriverul().close();
    }
}