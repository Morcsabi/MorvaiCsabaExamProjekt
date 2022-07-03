import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AboutPageTest extends BaseTest{

    @Test
    @DisplayName("TC13 Names save to file")
    @Description("TC13 - Save the names from name cards to file, read the file assert the content")
    public void saveCardNamesToFileTest() throws InterruptedException {
        registrationAndLogin();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.navigateToAbout();
        aboutPage.saveCardNamesToFile("CardNames.txt");
        Utils utils = new Utils(driver);
        String actual = utils.read("CardNames.txt");
        String expected = "PABLO ESCOBAR\n" +
                "MONTINO RIAU\n" +
                "ALEX NAASRI\n" +
                "HONGMAN CHIOA\n" +
                "SANTIO ANDRESS\n" +
                "RAMESH PAUL";

        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("TC14 Count the titles")
    @Description("TC14 - Get the number of name card titles on page")
    public void countTitles() throws InterruptedException {
        registrationAndLogin();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.navigateToAbout();
        int actual = aboutPage.countTitles();
        Assertions.assertEquals(6, actual);
    }


}
