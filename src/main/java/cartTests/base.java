package cartTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class base {

    @Test
    public void addingToCarttest () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String[] vegetables = {"Cucumber", "Brocolli", "Beetroot"};
        addItems(driver, vegetables);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        //driver.findElement(By.cssSelector("span.promoInfo")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
        driver.quit();
    }

    public void addItems(WebDriver driver, String[] vegetables) {
        int j=0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // check if vegetable name is present in array or not
            // covert array into array list for easy search
            List itemsNeededList = Arrays.asList(vegetables);

            if (itemsNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == vegetables.length){
                    break;
                }
            }
        }
    }
}
