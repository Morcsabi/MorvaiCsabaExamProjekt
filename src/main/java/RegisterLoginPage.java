import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.util.ArrayList;

public class RegisterLoginPage {

    WebDriver driver;

    private final String roxoPageUrl = "https://lennertamas.github.io/roxo/";
    private final By acceptTerms = By.id("terms-and-conditions-button");
    private final By closeTerms = By.className("CloseIcon");
    private final By overlayOnRegPage = By.id("overlay")
            ;
    private final By registerTab = By.id("register-form-button");
    private final By registerUsername = By.id("register-username");
    private final By registerPassword = By.id("register-password");
    private final By registerEmail = By.id("register-email");
    private final By registerDescription = By.id("register-description");
    private final By registerUserButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By registerAlert = By.id("register-alert");

    private final By loginTab = By.xpath("//*[@id=\"login-form-button\"]");
    private final By loginUsername = By.id("email");
    private final By loginPassword = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");


    public RegisterLoginPage(WebDriver driver) {this.driver = driver;}
    public void navigate() {driver.get(roxoPageUrl);}
    public void clickAcceptTerms() {driver.findElement(acceptTerms).click();}
    public void clickCloseTerms() {driver.findElement(closeTerms).click();}

    public String getOverlayStyle() {

        String overlayStyle = driver.findElement(overlayOnRegPage).getAttribute("style");
        return overlayStyle;
    }

    public void registration(String name, String password, String email, String description) throws InterruptedException {

        driver.findElement(registerTab).click();
        Thread.sleep(1000);
        driver.findElement(registerUsername).sendKeys(name);
        driver.findElement(registerPassword).sendKeys(password);
        driver.findElement(registerEmail).sendKeys(email);
        driver.findElement(registerDescription).sendKeys(description);
        Thread.sleep(1000);
        driver.findElement(registerUserButton).click();
        Thread.sleep(1000);
        //driver.navigate().refresh();
    }

    public String getRegisterAlert(){

        String result = driver.findElement(registerAlert).getText();
        return result;
    }

    public void login(String name, String password){

        driver.findElement(loginTab).click();
        driver.findElement(loginUsername).sendKeys(name);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String loggedIn(){
       return driver.getCurrentUrl();
        }

    public void clickRegistrationTab(){driver.findElement(registerTab).click();}


}
