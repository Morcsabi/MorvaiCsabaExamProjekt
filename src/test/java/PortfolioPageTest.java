import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PortfolioPageTest extends BaseTest {

    @Test
    @DisplayName("TC11 Pagination test")
    @Description("TC11 - Count all of portfolios on Portfolio page with pagination")
    public void paginationTest() throws InterruptedException {
        registrationAndLogin();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.navigatePortfolioPage();
        int actual = 0;
        while (true){
            actual += portfolioPage.projectCount();

            if (portfolioPage.isLastPage()){
                break;
            }
            portfolioPage.clickMoveNext();
        }
       Assertions.assertEquals(5, actual);
    }
    @Test
    @DisplayName("TC12 Portfolio content validation")
    @Description("TC12 - Validate the content of Osen Clock page")
    public void contentValidation() throws InterruptedException {
        registrationAndLogin();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.osenClockViewDetails();
        String actual = portfolioPage.getOsenText();
        String expected = "The “Seamless Watch” watch has all the features that users expect in a digital watch, and some unusual features.";
        Assertions.assertEquals(expected, actual);

    }
}
