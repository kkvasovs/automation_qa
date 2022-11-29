import lv.acodemy.constants.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaits {

    EdgeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testWaiter(){
        driver.get(Generic.GOOGLE_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("element_that_is_not_in_place")));
//        driver.findElement(By.xpath("element_that_is_not_in_place"));
    }

    @AfterMethod
    public void after(){
        driver.close();
        driver.quit();
    }
}
