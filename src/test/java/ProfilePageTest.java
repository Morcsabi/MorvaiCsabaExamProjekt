import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfilePageTest extends BaseTest{

    @Test
    @DisplayName("TC15 Save profile")
    @Description("TC15 - Save profile")
    public void saveProfile() throws InterruptedException {
        registrationAndLogin();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigate();
        profilePage.fillProfile("Béla", "Béci", "2222222");
        String message = profilePage.getProfileAlert();
        Assertions.assertEquals("Profile Edited!", message);
    }

    @Test
    @DisplayName("TC16 Delete account")
    @Description("TC16 - Delete account")
    public void deleteAccount() throws InterruptedException {
        registrationAndLogin();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigate();
        profilePage.deleteAccount();
        Assertions.assertFalse(profilePage.isThereACookie("Me"));

    }



}
