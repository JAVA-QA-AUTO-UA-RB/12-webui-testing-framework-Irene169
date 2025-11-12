package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By flashMessage = By.id("flash");
    private By logoutButton = By.cssSelector(".icon-2x.icon-signout");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getSuccessMessage() {
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return flash.getText().trim(); // обрізаємо пробіли та символ ×
    }

    public String getLogoutMessage() {
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return flash.getText().trim(); // обрізаємо пробіли та символ ×
    }

    public LoginPage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return new LoginPage(driver);
    }
}