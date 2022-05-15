package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pageobjects.Page;
import utils.TestContext;

public class GeneralSteps {

    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String pageName) {
        Page.pageContainsCorrectEndpoint(pageName, context.getWebDriverManager().getDriverul());
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String pageName) {
        Page.navigateToPage(pageName, context.getWebDriverManager().getDriverul());
    }

    @Then("^Correct \"([^\"]*)\" endpoint dislayed$")
    public void correctEndpointDislayed(String pageName) {
        Page.pageContainsCorrectEndpoint(pageName, context.getWebDriverManager().getDriverul());
    }
}