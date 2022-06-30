import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutPage {
    WebDriver driver;


    public AboutPage(WebDriver driver) {this.driver = driver;}

    private final String aboutUrl ="https://lennertamas.github.io/roxo/about/";
    private final By nameCardInfo = By.xpath("//*[@class=\"site-team-member-content\"]");
    private final By nameCardName = By.xpath("//*[@class=\"site-team-member-content\"]/h3");
    private final By nameCardTitle = By.xpath("//*[@class=\"site-team-member-content\"]/p");

    public void navigateToAbout() {driver.navigate().to(aboutUrl);}

    public void saveCardNamesToFile(String filename){
        Utils utils = new Utils(driver);
        utils.fileName = filename;
        List<WebElement> listOnPage = driver.findElements(nameCardName);

        for (int i = 0; i < listOnPage.size(); i++) {

            String text = listOnPage.get(i).getText();

            utils.write(text);
        }
    }
    //public void countCardNames



}
