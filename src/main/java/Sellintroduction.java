import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Sellintroduction {
    public static void main(String[] args) {

        //Not needed if webdriver manager is implemented
        // System.setProperty("webdriver.chrome.driver", "/Users/justy/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "/Users/justy/Documents/geckodriver.exe");
        //WebDriver driver1 = new FirefoxDriver();
        //System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");
        //WebDriver driver2 = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}
