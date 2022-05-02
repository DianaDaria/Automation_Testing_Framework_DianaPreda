package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.RegisterPage;
import utils.TestContext;

import java.sql.SQLOutput;

public class RegistrationSteps {

    private TestContext context;
    private RegisterPage registerPage;

    public RegistrationSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriverul());
    }
}