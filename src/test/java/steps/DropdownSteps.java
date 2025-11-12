package steps;
import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DropdownPage;


public class DropdownSteps {

    private DropdownPage dropdownPage;
    @Given("I open the Dropdown page")
    public void iOpenDropdownPage() {
        dropdownPage = new DropdownPage(WebHooks.driver);
        dropdownPage.open();
    }
    @When("I select {string}")
    public void iSelectOption(String optionText) {
        dropdownPage.selectOptionByVisibleText(optionText);
    }
    @Then("I should see that {string} is selected")
    public void iShouldSeeThatOptionIsSelected(String expectedOption) {
        String actualOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(actualOption, expectedOption,
                String.format("Expected option '%s' but got '%s'", expectedOption, actualOption));
    }
}