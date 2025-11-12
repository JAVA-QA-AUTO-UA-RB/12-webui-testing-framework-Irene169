package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropSteps {

    private DragAndDropPage dragAndDropPage;

    @Given("I open the Drag and Drop page")
    public void iOpenTheDragAndDropPage() {
        dragAndDropPage = new DragAndDropPage(WebHooks.driver);
        dragAndDropPage.open();
    }

    @When("I perform drag and drop from column A to column B")
    public void iPerformDragAndDrop() {
        dragAndDropPage.performDragAndDrop();
    }

    @Then("column A should contain {string} and column B should contain {string}")
    public void columnsShouldContain(String expectedA, String expectedB) {
        Assert.assertEquals(dragAndDropPage.getTextInColumnA(), expectedA,
                String.format("Column A should contain '%s'", expectedA));
        Assert.assertEquals(dragAndDropPage.getTextInColumnB(), expectedB,
                String.format("Column B should contain '%s'", expectedB));
    }
}