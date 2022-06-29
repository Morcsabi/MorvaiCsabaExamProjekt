import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriver wait;

    @BeforeEach
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*@AfterEach
    public void close(){
        driver.manage().deleteAllCookies();
        driver.close();
    }*/
   public void registrationAndLogin() throws InterruptedException {
       String name = "Me";
       String password = "myself";
       String email = "a@nd";
       String description = "I";
       RegisterLoginPage regLog = new RegisterLoginPage(driver);
       regLog.navigate();
      try {
           regLog.clickAcceptTerms();
       }
       catch (Exception e){}

       regLog.registration(name, password, email, description);

       regLog.login(name, password);
   }


}
