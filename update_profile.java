package Practice_TC;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class update_profile {


    WebDriver chromeDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

    @BeforeMethod
    public void setUp() {

        chromeDriver.get("https://id.trueconnect.vn/Account/login");
        chromeDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        chromeDriver.findElement(By.id("Username")).sendKeys("charlotte");
        chromeDriver.findElement(By.id("Password")).sendKeys("Nam@1901");

        // explicit wait for "Sign in button" appear and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/div/div/form/div[6]/button"))).click();
        // explicit wait for "Danh thiep dien tu button" appear and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[4]/a[1]/button"))).click();
    }


    @AfterMethod
    public void tearDown() {

    }


    // Update avatar & cover photo
    @Test
    public void Tescase1() throws AWTException, InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/app-user-banner/div[1]/div[2]/button"))).click();

        String filePath = "C:\\Users\\Hello\\OneDrive\\Máy tính\\AnhThe.jpg";
//      //Sử dụng Robot để điều khiển hệ thống
        Robot robot = new Robot();

        // Đặt đường dẫn tệp vào clipboard
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Thread.sleep(1000);
        // Gửi phím tắt Ctrl+V để dán đường dẫn tệp
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        // Gửi phím Enter để xác nhận tải lên
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(10000);
        //chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-1\"]/nz-modal-container/div/div/button/span/button")).click();


        JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
        WebElement hiddenElement = (WebElement) jsExecutor.executeScript(
                "return document.evaluate(//*[@id=\"cdk-overlay-2\"]/nz-modal-container/div/div/div/app-image-resize/div/button, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");

        // Thực hiện hành động click trên phần tử ẩn
        jsExecutor.executeScript("arguments[0].click();", hiddenElement);


        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-3\"]/nz-modal-container/div/div/div/app-image-resize/div/button"))).click();


//        Thread.sleep(10000);
//        // Định vị phần tử <input> để tải lên tệp ảnh
//        WebElement fileInput = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/app-user-banner/div[1]/div[2]/button"));  // Thay thế bằng cách định vị thích hợp
//        fileInput.click();
//
//        // Lấy đường dẫn tới tệp ảnh bạn muốn tải lên trên máy tính
//        String filePath = "C:\\Users\\Hello\\Downloads\\309304357_1583129602195662_4150601600369615547_n.png";
//
//        // Gửi đường dẫn tệp ảnh đến phần tử <input> để tải lên - Sử dụng sendKey - tối ưu code nhất nhưng chưa fix được!
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/app-user-banner/div[1]/div[2]/button")));
//        fileInput.sendKeys(filePath);

    }



    @Test
    public void Testcase2() throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-highlight/div/div/div[2]/button"))).click();

        chromeDriver.findElement(By.xpath("//*[@id=\"formly_4_ui-quill_hightlight_0\"]/div[2]/div[1]")).sendKeys("Đây là thông tin được tạo do auto test");

        Thread.sleep(5000);

        Alert alert = chromeDriver.switchTo().alert();
        alert.sendKeys("Co chó này");

    }

}
