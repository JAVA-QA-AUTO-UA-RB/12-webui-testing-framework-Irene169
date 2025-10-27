package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbTestingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/abtest";

    // Header element
    @FindBy(css = "div.example h3")
    private WebElement header;

    public AbTestingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Open the page
    public AbTestingPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    // Get the header text
    public String getHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText();
    }
}