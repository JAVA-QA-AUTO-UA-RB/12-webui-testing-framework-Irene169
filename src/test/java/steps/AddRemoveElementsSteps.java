package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsSteps {

    private AddRemoveElementsPage page;

    @Given("I open the AddRemove Elements page")
    public void iOpenTheAddRemoveElementsPage() {
        page = new AddRemoveElementsPage(WebHooks.driver);
        page.open();
    }

    @When("I add {int} {string} buttons")
    public void iAddButtons(int count, String buttonName) {
        page.addElements(count);
    }

    @Then("I should see {int} {string} buttons displayed")
    public void iShouldSeeButtons(int expectedCount, String buttonName) {
        Assert.assertEquals(page.getDeleteButtonsCount(),
                expectedCount,
                "Number of Delete buttons does not match expected");
    }

    @When("I remove all {string} buttons")
    public void iRemoveAllButtons(String buttonName) {
        page.removeAllElements();
    }

    @Then("I should see no {string} buttons on the page")
    public void iShouldSeeNoButtons(String buttonName) {
        Assert.assertTrue(page.areAllElementsRemoved(),
                "Delete buttons are still displayed after removal");
    }
}