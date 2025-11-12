package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void moveSliderTo() {
        HorizontalSliderPage page = new HorizontalSliderPage(driver);
        page.open();
        page.moveSliderTo("3.5");

        Assert.assertEquals(page.getValue(), "3.5");
    }
}