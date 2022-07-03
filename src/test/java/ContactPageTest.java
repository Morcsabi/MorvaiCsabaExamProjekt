import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactPageTest extends BaseTest{

    @Test
    @DisplayName("TC9 Complete contact message")
    @Description("TC9 - Contact message with full information")
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
    @DisplayName("TC10 Contact message wrong email address")
    @Description("TC10 - Contact message full information, wrong email address")
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
