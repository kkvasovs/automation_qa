import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testEdge {
    @Test
    public void edgeTest(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.google.lv/?hl=en");
        WebElement acceptButton = driver.findElement(By.xpath("//button//div[contains(text(),'Accept all')]"));
        acceptButton.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("acodemy");
        searchField.sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "acodemy - Google Search");

        driver.close();
        driver.quit();
    }
}
