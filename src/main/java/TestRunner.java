import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {

        WebDriverManager fireFoxDriveManager = new WebDriverManager("FireFox");
        fireFoxDriveManager.getDriverul().get("https://www.google.com/");
        fireFoxDriveManager.getDriverul().close();


//        WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");
//        System.out.println(webDriverManagerObiect.getDriverul());
//        webDriverManagerObiect.getDriverul().get("https://www.google.com/");
//        webDriverManagerObiect.getDriverul().close();
    }
}
