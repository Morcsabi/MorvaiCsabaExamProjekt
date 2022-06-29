import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {this.driver = driver;}

    private final String contactUrl ="https://lennertamas.github.io/roxo/contact/";
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By email = By.id("email");
    private final By projectType = By.id("projectType");
    private final By projectTypeGraphics = By.xpath("//*[@id=\"projectType\"]/option[2]");
    private final By projectTypeWeb = By.xpath("//*[@id=\"projectType\"]/option[3]");
    private final By aboutProject = By.id("aboutProject");
    private final By sendMessageButton = By.id("contact-form-button");
    private final By contactStatus = By.id("contact-form-status");

    public void navigateContact(){driver.navigate().to(contactUrl);}

    public void fillContactForm(String firstN, String lastN, String eMail, int pType, String aTP){
        driver.findElement(firstName).sendKeys(firstN);
        driver.findElement(lastName).sendKeys(lastN);
        driver.findElement(email).sendKeys(eMail);
        driver.findElement(aboutProject).sendKeys(aTP);
        Select sc = new Select(driver.findElement(projectType));
        sc.selectByIndex(pType);

    }
    public void clickSendMessage(){
        driver.findElement(sendMessageButton).click();
    }

    public void clickAlertOk(){
        driver.switchTo().alert().accept();
    }

    public String getContactStatus(){
        return driver.findElement(contactStatus).getText();
    }

}