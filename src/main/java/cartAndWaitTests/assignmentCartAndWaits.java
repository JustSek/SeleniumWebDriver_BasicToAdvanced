package cartAndWaitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class assignment3CartAndWaits {

    @Test
    public void assignmentTest () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        //Explicit wait will apply only to one element
        WebDriverWait w = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[text()=' User']/../span[@class='checkmark']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement options = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(options);
        dropdown.selectByVisibleText("Consultant");

        driver.findElement(By.id("signInBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        addAllItemsOnPage(driver);
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        Thread.sleep(3000);

        driver.quit();
    }

    public void addAllItemsOnPage(WebDriver driver) {
        List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for (int i=0; i<products.size();i++)
            {
            products.get(i).click();
            }
        }
}
