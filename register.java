package Practice_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class register {

    WebDriver chrome_driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(chrome_driver, Duration.ofSeconds(10));



    @BeforeMethod
    public void setUp() {

        chrome_driver.get("https://id.trueconnect.vn/Account/Register");
    }

    @AfterMethod
    public void tearDown() {
        if (chrome_driver != null) {
            chrome_driver.quit();
        }
    }

    @Test
    public void testCase1() {
        chrome_driver.findElement(By.id("UserName")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("FullName")).sendKeys("Automation Test 1");
        chrome_driver.findElement(By.id("Email")).sendKeys("auto1@gmail.com");
        chrome_driver.findElement(By.id("PhoneNumber")).sendKeys("0988837837");
        chrome_driver.findElement(By.id("password")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("password1")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("ReferralCode")).sendKeys("charlotte");

        WebElement agreeCheckbox = chrome_driver.findElement(By.id("agree-checkbox"));
        if(!agreeCheckbox.isSelected()) {
            agreeCheckbox.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        chrome_driver.findElement(By.id("submitBtn")).click();

    }


    // Test Username trùng với username đã đăng kí trước đó
    @Test
    public void testCase2() {
        chrome_driver.findElement(By.id("UserName")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("FullName")).sendKeys("Automation Test 1");
        chrome_driver.findElement(By.id("Email")).sendKeys("auto1@gmail.com");
        chrome_driver.findElement(By.id("PhoneNumber")).sendKeys("0988837837");
        chrome_driver.findElement(By.id("password")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("password1")).sendKeys("autotest01");
        chrome_driver.findElement(By.id("ReferralCode")).sendKeys("charlotte");

        WebElement agreeCheckbox = chrome_driver.findElement(By.id("agree-checkbox"));
        if(!agreeCheckbox.isSelected()) {
            agreeCheckbox.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        chrome_driver.findElement(By.id("submitBtn")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerForm\"]/div/div/div[3]")));
        String expectedErrorMessage = "Username đã tồn tại."; // Giá trị kỳ vọng
        String actualErrorMessage = errorMessage.getText(); // Lấy nội dung thông báo thực tế
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    // Test bỏ trống các trường required
    @Test
    public void testCase3() {
        chrome_driver.findElement(By.id("UserName")).sendKeys("");
        chrome_driver.findElement(By.id("FullName")).sendKeys("");
        chrome_driver.findElement(By.id("Email")).sendKeys("");
        chrome_driver.findElement(By.id("PhoneNumber")).sendKeys("");
        chrome_driver.findElement(By.id("password")).sendKeys("");
        chrome_driver.findElement(By.id("password1")).sendKeys("");
        chrome_driver.findElement(By.id("ReferralCode")).sendKeys("");

        WebElement agreeCheckbox = chrome_driver.findElement(By.id("agree-checkbox"));
        if(!agreeCheckbox.isSelected()) {
            agreeCheckbox.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        chrome_driver.findElement(By.id("submitBtn")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerForm\"]/div/div/div[3]")));
        String expectedErrorMessage = "Vui lòng nhập tên Username"; // Giá trị kỳ vọng
        String actualErrorMessage = errorMessage.getText(); // Lấy nội dung thông báo thực tế
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }


}

