package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOption2InDropdownTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        // Open the page
        dropdownPage.open();

        // Select option 2
        dropdownPage.selectOptionByValue("2");

        // Verify the selected option
        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Option 2",
                "Expected selected option to be 'Option 2'");
    }
}