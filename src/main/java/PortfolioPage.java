import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PortfolioPage {

    WebDriver driver;

    public PortfolioPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String portfolioUrl = "https://lennertamas.github.io/roxo/portfolio/";
    private final By moveNext = By.xpath("//*[@class=\"pagination\"]/li[5]");
    //private final By moveNextDisabled = By.xpath("//*[@id=\"project\"]/div/div/div[2]/div/ul/li[5]/a");
    private final By movePrevious = By.xpath("//*[@id=\"project\"]/div/div/div[2]/div/ul/li[2]/a");
    private final By itemName = By.xpath("//*[@id=\"project\"]//h3");

    public void navigatePortfolioPage() {
        driver.navigate().to(portfolioUrl);
    }

    public void clickMoveNext() {
        driver.findElement(moveNext).click();
    }

    public int projectCount() {
        int count = 0;
        List<WebElement> noOfItems = driver.findElements(itemName);
        count = noOfItems.size();
        return count;
    }

    public boolean isLastPage() {
        return driver.findElement(moveNext).getAttribute("class").equals("page-item disabled");
    }
}
