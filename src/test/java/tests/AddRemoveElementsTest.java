package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addAndRemoveElementsTest() {
        // Initialize page object
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait);

        // Open the page
        page.open();

        // Add 3 elements
        page.addElements(3);

        // Verify 3 delete buttons are displayed
        Assert.assertEquals(page.getDeleteButtonsCount(), 3,
                "Expected 3 Delete buttons.");

        // Remove all elements
        page.removeAllElements();

        // Verify all elements are removed
        Assert.assertTrue(page.areAllElementsRemoved(), "All Delete buttons should be removed.");
    }
}