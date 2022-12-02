import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.openqa.selenium.Keys.ENTER;

public class testShopAcodemy {

    ChromeDriver driver = new ChromeDriver();
    public static final String SHOP_URL = "https://shop.acodemy.lv";

    @BeforeMethod
    public void initialize() {
        driver.get(SHOP_URL);
    }

    @Test
    public void addToCart() throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//a[@class='button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart']"));
        addToCart.click();
        WebElement openCart = driver.findElement(By.xpath("//a[@class='cart-contents']"));
        openCart.click();
        WebElement coupon = driver.findElement(By.xpath("//div[@class='coupon']//input[contains(@class,'input-text')]"));
        coupon.click();
        coupon.sendKeys("test");
        coupon.sendKeys(ENTER);
        driver.manage().timeouts().implicitlyWait();


//        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//ul[@class='woocommerce-error']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
