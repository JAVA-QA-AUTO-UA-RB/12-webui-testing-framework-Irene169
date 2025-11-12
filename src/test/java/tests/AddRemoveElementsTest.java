package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addAndRemoveElementsTest() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.open();
        page.addElements(3);

        Assert.assertEquals(page.getDeleteButtonsCount(), 3,
                "Expected 3 Delete buttons.");

        page.removeAllElements();

        Assert.assertTrue(page.areAllElementsRemoved(), "All Delete buttons should be removed.");
    }
}