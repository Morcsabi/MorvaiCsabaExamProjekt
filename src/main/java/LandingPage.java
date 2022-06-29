import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;


    public LandingPage(WebDriver driver) {this.driver = driver;}

    //Nav Bar
    private final By navBarHomePage = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[1]/a");
    private final By navBarAbout = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[2]/a");
    private final By navBarPortfolio = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[3]/a");
    private final By navBarBlog = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[4]/a");
    private final By navBarGetInTouch = By.xpath("//*[@id=\"sitenavbar\"]/ul/li[5]/a/span/span");
    private final By navBarProfile = By.id("profile-btn");
    private final By navBarLogout = By.xpath("//*[@id=\"logout-link\"]/a");


    private final By kioTapeViewProject = By.xpath("//*[@id=\"project\"]/div/div/div[2]/div/div[2]/a");

    public void goToKioTapeProject(){
        driver.findElement(kioTapeViewProject).click();
    }

    public void clickLogoutButton(){
        driver.findElement(navBarLogout).click();
    }

    public void goToPortfolioPage(){
        driver.findElement(navBarPortfolio).click();
    }

    public void goToBlogPage(){
        driver.findElement(navBarBlog);
    }

    public void goToContact(){driver.findElement(navBarGetInTouch);
    }
    public void goToAboutPage(){
        driver.findElement(navBarAbout);
    }

    public void goToProfile(){
        driver.findElement(navBarProfile);
    }

















}
