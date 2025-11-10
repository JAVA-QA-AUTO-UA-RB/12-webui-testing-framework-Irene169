package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void moveSliderTo() {
        // Initialize HorizontalSliderPage
        HorizontalSliderPage page = new HorizontalSliderPage(driver);

        // Open slider page
        page.open();

        // Move slider to 3.5
        page.moveSliderTo("3.5");

        // Validate the slider value
        Assert.assertEquals(page.getValue(), "3.5");
    }
}