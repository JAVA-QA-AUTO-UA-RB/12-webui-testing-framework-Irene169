package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void allCheckboxesShouldbeSelected() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.open();

        Assert.assertEquals(page.getCheckboxCount(), 2, "Expected 2 checkboxes on the page");

        page.selectAll();

        Assert.assertTrue(page.areAllSelected(), "All checkboxes should be selected");
    }
}