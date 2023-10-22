import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTestJSExecutor extends BaseTestClass {
    @BeforeMethod
    public void beforeMethod() {

        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
    }

    @Test
    public void TestWithJSExecutor() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();

        WebElement result2 = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(result2.getText(), "CUSTOMER SERVICE - CONTACT US");
    }


}
