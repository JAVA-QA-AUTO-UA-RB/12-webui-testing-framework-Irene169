package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOption2InDropdownTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.open();
        dropdownPage.selectOptionByVisibleText("2");

        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Option 2",
                "Expected selected option to be 'Option 2'");
    }
}