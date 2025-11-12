package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/horizontal_slider";

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement rangeValue;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(slider));
        return this;
    }

    public HorizontalSliderPage moveSliderTo(String targetValue) {

        slider.sendKeys(Keys.HOME);

        double current = Double.parseDouble(rangeValue.getText());
        double target = Double.parseDouble(targetValue);

        while (Math.abs(current - target) > 0.01) {
            if (current < target) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
            current = Double.parseDouble(rangeValue.getText());
        }

        return this;
    }

    public String getValue() {
        return rangeValue.getText();
    }
}