package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;

public class AbTestingTest extends BaseTest {

    @Test
    public void headerShouldContainAbTestText() {

        AbTestingPage abPage = new AbTestingPage(driver);
        abPage.open();
        String text = abPage.getHeaderText();

        Assert.assertTrue(text.contains("A/B Test"),
                "Expected header to contain 'A/B Test'. Actual: " + text);
    }
}