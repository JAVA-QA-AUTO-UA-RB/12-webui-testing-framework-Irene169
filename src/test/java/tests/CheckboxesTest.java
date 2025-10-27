package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void selectAllCheckboxesTest() {
        CheckboxesPage page = new CheckboxesPage(driver);

        // Open the checkboxes page
        page.open();

        // Verify there are exactly 2 checkboxes
        Assert.assertEquals(page.getCheckboxCount(), 2, "Expected 2 checkboxes on the page");

        // Select all checkboxes
        page.selectAll();

        // Verify all checkboxes are selected
        Assert.assertTrue(page.areAllSelected(), "All checkboxes should be selected");
    }
}