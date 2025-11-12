package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckboxesPage;

public class CheckboxesSteps {

    private CheckboxesPage checkboxesPage;

    @Given("I open the Checkboxes page")
    public void iOpenTheCheckboxesPage() {
        // Open the checkboxes page
        checkboxesPage = new CheckboxesPage(WebHooks.driver);
        checkboxesPage.open();
    }

    @Then("I should see {int} checkboxes")
    public void iShouldSeeCheckboxes(int expectedCount) {
        int actualCount = checkboxesPage.getCheckboxCount();
        Assert.assertEquals(actualCount, expectedCount,
                String.format("Expected %d checkboxes, but found %d", expectedCount, actualCount));
    }

    @When("I select all checkboxes")
    public void iSelectAllCheckboxes() {
        checkboxesPage.selectAll();
    }

    @Then("all checkboxes should be selected")
    public void allCheckboxesShouldBeSelected() {
        Assert.assertTrue(checkboxesPage.areAllSelected(), "All checkboxes should be selected");
    }
}