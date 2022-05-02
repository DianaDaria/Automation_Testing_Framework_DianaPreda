package stepdefinitions;

import cucumber.api.java.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import utils.TestContext;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUpBeforeEachTest() {
        testContext.getWebDriverManager().getDriverul();
    }

    @After
    public void tearDownActionsEachTest() {
        testContext.getWebDriverManager().getDriverul().close();
        testContext.getWebDriverManager().getDriverul().quit();
    }
}