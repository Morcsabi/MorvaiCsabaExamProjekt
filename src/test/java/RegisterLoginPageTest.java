import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

public class RegisterLoginPageTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("TC1 Accept Terms and conditions")
    @Description("TC1 - Click accept button on Terms and conditions window")
    public void acceptPrivacyTerms() {
        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        registerLoginPage.clickAcceptTerms();
        String actual = registerLoginPage.getOverlayStyle();
        Assertions.assertEquals("display: none;", actual);
    }

    @Test
    @Order(2)
    @DisplayName("TC2 Close Terms and conditions")
    @Description("TC2 - Close Terms and conditions window with close icon")
    public void closePrivacyTerms() {
        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        registerLoginPage.clickCloseTerms();
        String actual = registerLoginPage.getOverlayStyle();
        Assertions.assertEquals("display: none;", actual);
    }

    @Test
    @Order(3)
    @DisplayName("TC3 Valid registration")
    @Description("TC3 - Registration with valid username, password, email, description")
    public void validRegistration() throws InterruptedException {
        String name = "Béla";
        String password = "jelszó";
        String email = "bela@king.com";
        String description = "Béla a király";
        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        Thread.sleep(1500);
        registerLoginPage.clickCloseTerms();
        registerLoginPage.registration(name, password, email, description);
        String expected = "User registered!";
        Assertions.assertEquals(expected, registerLoginPage.getRegisterAlert());
    }

    @Test
    @Order(4)
    @DisplayName("TC4 Registration without email")
    @Description("TC4 - Registration with username and password without email")
    public void registrationWithoutEmail() throws InterruptedException {
        String name = "János";
        String password = "jelszó";
        String email = "";
        String description = "János a király";
        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        Thread.sleep(1500);
        try {
            registerLoginPage.clickCloseTerms();
        } catch (Exception e) {
        }
        registerLoginPage.registration(name, password, email, description);
        String expected = "User registered!";
        Assertions.assertNotEquals(expected, registerLoginPage.getRegisterAlert());
    }

    @Test
    @Order(5)
    @DisplayName("TC5 Valid login")
    @Description("TC5 - Login with valid username, password and email")
    public void validLogin() throws InterruptedException {
        String name = "Béla";
        String password = "jelszó";
        String email = "bela@king.com";
        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        registerLoginPage.clickAcceptTerms();
        registerLoginPage.registration(name, password, email, "");
        Thread.sleep(2000);
        refresh();
        registerLoginPage.login(name, password);
        Assertions.assertEquals("https://lennertamas.github.io/roxo/landing.html", registerLoginPage.loggedIn());
    }

    @Test
    @Order(6)
    @DisplayName("TC6 Register from data file")
    @Description("TC6 - Register from data file")
    public void registerFromFile() throws InterruptedException {
        Utils utils = new Utils(driver);
        String[] users = utils.read("RegisterUsers.txt").split("\n");

        RegisterLoginPage registerLoginPage = new RegisterLoginPage(driver);
        registerLoginPage.navigate();
        try {
            registerLoginPage.clickAcceptTerms();
        }
        catch (Exception e){}

        for (int i = 0; i < users.length; i+=4) {

            String name = users[i];
            String password = users[i+1];
            String email = users[i+2];
            String description = users[i+3];
            registerLoginPage.registration(name, password, email, description);
            String actual = registerLoginPage.getRegisterAlert();

            Assertions.assertEquals("User registered!", actual);
        }
    }
}