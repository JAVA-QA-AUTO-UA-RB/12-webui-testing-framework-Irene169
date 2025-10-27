package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;

public class AbTestingTest extends BaseTest {

    @Test
    public void headerShouldContainAbTestText() {
        // Initialize page object
        AbTestingPage abPage = new AbTestingPage(driver, wait);

        // Open the page
        abPage.open();

        // Get header text
        String text = abPage.getHeaderText();

        // Verify header contains "A/B Test"
        Assert.assertTrue(text.contains("A/B Test"),
                "Expected header to contain 'A/B Test'. Actual: " + text);
    }
}