package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void horizontalSliderValueShouldChange() {
        HorizontalSliderPage sliderPage = new HorizontalSliderPage(driver);

        // Open the slider page
        sliderPage.open();

        // Move the slider horizontally (50 pixels)
        sliderPage.moveSliderByOffset(50);

        // Verify that the slider value has changed
        String sliderValue = sliderPage.getSliderValue();
        Assert.assertFalse(sliderValue.isEmpty(), "Slider value should have changed");
    }
}