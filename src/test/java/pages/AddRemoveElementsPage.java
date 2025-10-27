package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRemoveElementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/add_remove_elements/";

    // Locators
    private final By addButton = By.cssSelector("button[onclick='addElement()']");
    private final By deleteButtons = By.cssSelector("button.added-manually");

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Open the page
    public AddRemoveElementsPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    // Add N elements
    public AddRemoveElementsPage addElements(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(addButton).click();
        }
        // Wait until the expected number of delete buttons appear
        wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtons, count));
        return this;
    }

    // Get the number of Delete buttons
    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }

    // Remove all elements
    public AddRemoveElementsPage removeAllElements() {
        while (!driver.findElements(deleteButtons).isEmpty()) {
            driver.findElements(deleteButtons).get(0).click();
            // Wait until the number decreases by 1
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(deleteButtons,
                    driver.findElements(deleteButtons).size() + 1));
        }
        return this;
    }

    // Check if all elements are removed
    public boolean areAllElementsRemoved() {
        return driver.findElements(deleteButtons).isEmpty();
    }
}