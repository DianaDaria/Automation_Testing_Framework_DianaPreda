package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utils.TestContext;

public class GeneralSteps {

    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaUrl) throws Throwable {
        context.getWebDriverManager().getDriverul().get(adresaUrl);
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) throws Throwable {
        boolean containsCorrectUrlEndpoint = context.getWebDriverManager().getDriverul().getCurrentUrl().contains(keyWord);
        Assert.assertTrue("The actual url does not contain the correct endpoint", containsCorrectUrlEndpoint);
    }
}