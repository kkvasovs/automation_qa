import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

        import lv.acodemy.page_object.InventoryPage;
        import lv.acodemy.page_object.LoginPage;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

import java.util.List;

import static lv.acodemy.constants.Generic.SAUCE_URL;

public class TestSauceDemo {

    EdgeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod(description = "Preconditions")
    public void initialize() {
        driver = new EdgeDriver();
        driver.get(SAUCE_URL);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test(description = "Happy path: Test authorization with standard user")
    public void authorizeTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.itemElementCount(), 6);
    }

    @Test
    public void openProductTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getTitleElement().getText(), "PRODUCTS");
        inventoryPage.clickOnProductByLabel("Sauce Labs Backpack");
        System.out.println();
            }

    @Test(description = "Failure: Test authorization error message with incorrect credentials")
    public void invalidCredentialTest() {
        loginPage.authorize("standard_user", "incorrect_pw");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}