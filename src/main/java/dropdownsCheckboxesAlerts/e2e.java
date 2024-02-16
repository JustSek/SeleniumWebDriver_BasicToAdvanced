package dropdownsCheckboxesAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class e2e {

    @Test
    public void e2eTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight" +
                "")).click();

        // One way selected by default, Return Date should be disabled (value 0.5)
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("Round Trip disabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //Adding 5 adults passengers
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        //driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.quit();
    }
}
