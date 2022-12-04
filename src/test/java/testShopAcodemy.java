import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class testShopAcodemy {

    ChromeDriver driver;
    public static final String SHOP_URL = "https://shop.acodemy.lv";
    private WebDriverWait wait;

    @BeforeMethod
    public void initialize() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SHOP_URL);
    }

    @Test
    public void addToCart() {
        WebElement addToCart = driver.findElement(By.xpath("//a[@class='button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart']"));
        addToCart.click();
    }

    @Test
    public void viewCart() {
        WebElement addToCart = driver.findElement(By.xpath("//a[@class='button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart']"));
        addToCart.click();
        WebElement openCart = driver.findElement(By.xpath("//a[@class='cart-contents']"));
        openCart.click();
    }

    @Test
    public void addCoupon() {
        WebElement addToCart = driver.findElement(By.xpath("//a[@class='button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart']"));
        addToCart.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'added_to_cart')]")));
        WebElement openCart = driver.findElement(By.xpath("//a[@class='cart-contents']"));
        openCart.click();
        WebElement coupon = driver.findElement(By.xpath("//div[@class='coupon']//input"));
        coupon.click();
        coupon.sendKeys("test");
        coupon.sendKeys(Keys.ENTER);
//        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//ul[ul@class='woocommerce-error']"));
    }

//    @Test
//    public void emptyCoupon(){
//        WebElement addToCart = driver.findElement(By.xpath("//a[@class='button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart']"));
//        addToCart.click();
//        WebElement openCart = driver.findElement(By.xpath("//a[@class='cart-contents']"));
//        openCart.click();
//        WebElement applyCode = driver.findElement(By.id("coupon_code"));
//        applyCode.click();
//
//        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//ul[@class='woocommerce-error']"));
//
//    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
