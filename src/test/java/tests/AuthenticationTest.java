package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void formAuthenticationTest() {
        // Initialize the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Open the login page
        loginPage.open();

        // Perform login (returns SecureAreaPage)
        SecureAreaPage secureArea = loginPage.login("tomsmith", "SuperSecretPassword!");

        // Verify login success message
        Assert.assertTrue(secureArea.getSuccessMessage().contains("You logged into a secure area!"),
                "Login success message is not displayed");

        // Perform logout (returns LoginPage)
        LoginPage afterLogout = secureArea.logout();

        // Verify logout success message
        Assert.assertTrue(afterLogout.getLogoutMessage().contains("You logged out of the secure area!"),
                "Logout success message is not displayed");
    }
}