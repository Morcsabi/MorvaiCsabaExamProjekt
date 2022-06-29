import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ProfilePage {
    WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private final String profileUrl ="https://lennertamas.github.io/roxo/profile";

    private final By profileName = By.id("name");
    private final By profileBio = By.id("bio");
    private final By profilePhone = By.id("phone-number");
    private final By profileEditAlert = By.id("edit-alert");
    private final By saveProfileButton = By.xpath("//*[@id=\"edit-profile\"]/form/div[5]/button");
    private final By deleteAccount = By.xpath("//*[@id=\"edit-profile\"]/form/div[6]/button");
    private final By sureDeleteAccount = By.id("delete-account-btn");

    public void navigate(){driver.navigate().to(profileUrl);}

    public void fillProfile (String name, String bio, String phoneNumber){
        driver.findElement(profileName).sendKeys(name);
        driver.findElement(profileBio).sendKeys(bio);
        driver.findElement(profilePhone).sendKeys(phoneNumber);
        driver.findElement(saveProfileButton).click();
    }

    public String getProfileAlert(){
        return driver.findElement(profileEditAlert).getText();
    }

    public void deleteAccount() throws InterruptedException {
        driver.findElement(deleteAccount).click();
        Thread.sleep(1000);
        driver.findElement(sureDeleteAccount).click();
    }

    public boolean isThereACookie(String cookieName) {
        if (driver.manage().getCookieNamed(cookieName) == null) {
            return false;
        } else {
            return true;
        }
    }
}
