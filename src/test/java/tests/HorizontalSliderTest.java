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

        // Set the slider value to 3.5
        sliderPage.setSliderValue(3.5);

        // Get actual slider value
        double actualValue = sliderPage.getSliderValue();

        // Assert the slider reached the correct value
        Assert.assertEquals(actualValue, 3.5, "Slider value should be exactly 3.5");
    }
}