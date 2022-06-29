import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PortfolioPageTest extends BaseTest {

    @Test
    @DisplayName("Pagination test")
    @Description("Count all of portfolios on Portfolio page with pagination")
    public void paginationTest() throws InterruptedException {
        registrationAndLogin();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
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
}
