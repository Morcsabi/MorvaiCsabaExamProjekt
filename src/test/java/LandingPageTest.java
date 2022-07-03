import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LandingPageTest extends BaseTest{



    @Test
    @DisplayName("TC7 Get Kio-Tape from Landing Page")
    @Description("TC7 - Navigate to Kio-Tape Brand Project page from Landing page")
    public void kioTapeViewProject() throws InterruptedException {
        registrationAndLogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToKioTapeProject();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://lennertamas.github.io/roxo/portfolio/kio-tape-2/", actualUrl);
    }
    @Test
    @DisplayName("TC8 Logout")
    @Description("TC8 - Logout with logout button")
    public void logoutTest() throws InterruptedException {
        registrationAndLogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLogoutButton();
        String actual = driver.getCurrentUrl();
        Assertions.assertEquals("https://lennertamas.github.io/roxo/index.html", actual);
    }









}
