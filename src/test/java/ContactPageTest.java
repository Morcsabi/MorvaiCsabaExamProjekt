import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactPageTest extends BaseTest{

    @Test
    @DisplayName("Complete contact message")
    @Description("Contact message with full infos")
    public void sendCompleteContactMessage() throws InterruptedException {
        registrationAndLogin();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.navigateContact();
        contactPage.fillContactForm("Steve", "Jobless", "mail@mail.com", 1, "Hello");
        contactPage.clickSendMessage();
        Thread.sleep(1000);
        contactPage.clickAlertOk();
        Thread.sleep(1000);
        String actualMessage = contactPage.getContactStatus();
        Assertions.assertEquals("Thanks! Contact form is submitted successfully.", actualMessage);
    }
    @Test
    @DisplayName("Contact message wrong email address")
    @Description("Contact message full info, wrong email address")
    public void sendContactWithWrongEmail() throws InterruptedException {
        registrationAndLogin();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.navigateContact();
        contactPage.fillContactForm("Steve", "Jobless", "mail@mail", 1, "Hello");
        contactPage.clickSendMessage();
        Thread.sleep(1000);
        contactPage.clickAlertOk();
        Thread.sleep(1000);
        String actualMessage = contactPage.getContactStatus();
        Assertions.assertEquals("Oops! There was a problem.", actualMessage);


    }

}
