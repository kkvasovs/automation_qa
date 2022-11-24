import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lv.acodemy.constants.Generic.SAUCE_URL;

public class TestSauceDemo {

    EdgeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod(description = "Preconditions")
    public void initialize() {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        driver.get(SAUCE_URL);
    }

    @Test (description = "Happy path: Test authorization with standart_user")
    public void authorizeTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.itemElementCount(), 6);
    }

    @Test (description = "Failure path: Test authorization error message with incorrect credentials")
    public void invalidCredentialTest() {
        loginPage.authorize("abc", "dbe");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
