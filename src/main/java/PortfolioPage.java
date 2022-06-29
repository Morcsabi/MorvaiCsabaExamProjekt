import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PortfolioPage {

    WebDriver driver;

    public PortfolioPage(WebDriver driver) {
        this.driver = driver;
    }


    private final String portfolioUrl = "https://lennertamas.github.io/roxo/portfolio/";
    private final String osenClockDetails = "https://lennertamas.github.io/roxo/portfolio/osen-clock/";
    private final By moveNext = By.xpath("//*[@class=\"pagination\"]/li[5]");
    private final By movePrevious = By.xpath("//*[@id=\"project\"]/div/div/div[2]/div/ul/li[2]/a");
    private final By itemName = By.xpath("//*[@id=\"project\"]//h3");
    private final By osenFirstLine = By.xpath("//*[@class=\"site-project-single-description\"]/p[1]");

    public void navigatePortfolioPage() {
        driver.navigate().to(portfolioUrl);
    }

    public void clickMoveNext() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(moveNext));
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

    public void osenClockViewDetails(){
        driver.navigate().to(osenClockDetails);
    }
    public String getOsenText(){
        return driver.findElement(osenFirstLine).getText();
    }

}
