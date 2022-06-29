import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LandingPageTest extends BaseTest{



    @Test
    @DisplayName("Get Kio-Tape from Landing Page")
    @Description("Navigate to Kio-Tape Brand Project page from Landing page and save content to file for assertion")
    public void kioTapeViewProject() throws InterruptedException {
        registrationAndLogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToKioTapeProject();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://lennertamas.github.io/roxo/portfolio/kio-tape-2/", actualUrl);
    }
    @Test
    @DisplayName("Logout")
    @Description("Logout with logout button")
    public void logoutTest() throws InterruptedException {
        registrationAndLogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLogoutButton();
        String actual = driver.getCurrentUrl();
        Assertions.assertEquals("https://lennertamas.github.io/roxo/index.html", actual);
    }









}
