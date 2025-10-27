package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage {

    private WebDriver driver;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/checkboxes";

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Open the page
    public CheckboxesPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    // Select all checkboxes
    public CheckboxesPage selectAll() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) checkbox.click();
        }
        return this;
    }

    // Check if all checkboxes are selected
    public boolean areAllSelected() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) return false;
        }
        return true;
    }

    // Return the total number of checkboxes
    public int getCheckboxCount() {
        return checkboxes.size();
    }
}