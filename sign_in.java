package Practice_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sign_in {

    WebDriver chrome_driver = new ChromeDriver();


    @BeforeMethod
    public void setup_data() {
        chrome_driver.get("https://id.trueconnect.vn/Account/Login");
        sleep(2000);
    }

    @AfterMethod
    public void cleanup_data() {
        chrome_driver.quit();
        sleep(2000);
    }


    // To sleep after execute each step
    private void sleep(int time) {
        try {
            Thread.sleep(time);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // TEST-CASE

    // Testcase1: Username and password is right!
    @Test
    public void testcase1() {

        chrome_driver.findElement(By.id("Username")).sendKeys("charlotte");
        sleep(2000);
        chrome_driver.findElement(By.id("Password")).sendKeys("Nam@1901");
        sleep(2000);
        chrome_driver.findElement(By.name("button")).click();
        sleep(5000);

    }

    // Testcase2: Username is wrong and password is right!
    @Test
    public void testcase2() {

        chrome_driver.get("https://id.trueconnect.vn/Account/Login");
        sleep(2000);
        chrome_driver.findElement(By.id("Username")).sendKeys("wrong");
        sleep(2000);
        chrome_driver.findElement(By.id("Password")).sendKeys("Nam@1901");
        sleep(2000);
        chrome_driver.findElement(By.name("button")).click();
        sleep(5000);
    }

    // Testcase3: Username is wrong and password is wrong!
    @Test
    public void testcase3() {

        chrome_driver.get("https://id.trueconnect.vn/Account/Login");
        sleep(2000);
        chrome_driver.findElement(By.id("Username")).sendKeys("wrong");
        sleep(2000);
        chrome_driver.findElement(By.id("Password")).sendKeys("wrong");
        sleep(2000);
        chrome_driver.findElement(By.name("button")).click();
        sleep(5000);
    }

    // Testcase4: Username is right and password is wrong!
    @Test
    public void testcase4() {

        chrome_driver.get("https://id.trueconnect.vn/Account/Login");
        sleep(2000);
        chrome_driver.findElement(By.id("Username")).sendKeys("charlotte");
        sleep(2000);
        chrome_driver.findElement(By.id("Password")).sendKeys("wrong");
        sleep(2000);
        chrome_driver.findElement(By.name("button")).click();
        sleep(5000);
    }

    // Testcase5: Username is blank and password is blank!
    @Test
    public void testcase5() {

        chrome_driver.get("https://id.trueconnect.vn/Account/Login");
        sleep(2000);
        chrome_driver.findElement(By.id("Username")).sendKeys("");
        sleep(2000);
        chrome_driver.findElement(By.id("Password")).sendKeys("");
        sleep(2000);
        chrome_driver.findElement(By.name("button")).click();
        sleep(5000);
    }




}
