package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInputField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInputField;

    @FindBy(css = "#input-telephone")
    private WebElement phoneInputField;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement confirmPasswordInputField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    public void populateRegisterForWithData(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        emailInputField.sendKeys(email);
        phoneInputField.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmPasswordInputField.sendKeys(confirmPassword);
    }

    public void clickContinueBtn() {
        continueButton.click();
    }
}