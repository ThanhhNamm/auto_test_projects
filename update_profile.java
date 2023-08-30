package Practice_TC;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
import org.openqa.selenium.support.ui.Select;


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


    // Update avatar
    @Test
    public void Tescase1() throws AWTException, InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/app-user-banner/div[2]/div/div[1]/div/button/div"))).click();

        String filePath = "C:\\Users\\Hello\\OneDrive\\Máy tính\\AnhThe.jpg";

        //Sử dụng Robot để điều khiển hệ thống
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-image-resize/div/button"))).click();


    }


    // Update Cover photo ==> oke
    @Test
    public void Testcase2() throws InterruptedException, AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/app-user-banner/div[1]/div[2]/button"))).click();

        String expectedValue = "C:\\Users\\Hello\\OneDrive\\Document\\Hình ảnh\\Hình ảnh\\Ảnh mẫu\\368345627_238854679125976_5345742738850022693_n.jpg";

        //Sử dụng Robot để điều khiển hệ thống
        Robot robot = new Robot();

        // Đặt đường dẫn tệp vào clipboard
        StringSelection stringSelection = new StringSelection(expectedValue);
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-image-resize/div/button"))).click();


//        Assert.assertEquals(actualValue, expectedValue);



    }

    // Update Thông tin nổi bật ==> oke
    @Test
    public void Testcase3() throws InterruptedException {

        String actualValue = "Đây được tạo từ automation test";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-highlight/div/div/div[2]/button"))).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id=\"formly_2_ui-quill_hightlight_0\"]/div[2]/div[1]")).sendKeys(actualValue);
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-user-highlight-modal/div/div/button[2]")).click();

        String expectedValue = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-highlight/div/div[2]/div")).getText();
        Assert.assertNotEquals(actualValue,expectedValue,"True");
    }

    // Update Thông tin cá nhân
    @Test
    public void Testcase4() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-basic-edit/div/div[1]/div[2]/button"))).click();

        Thread.sleep(400);
        chromeDriver.findElement(By.xpath("//*[@id=\"formly_12_ui-input_address_0\"]")).sendKeys("Địa chỉ tạo bằng automation test");

        // update ngày sinh ==> chưa được
        Thread.sleep(400);
        WebElement updateDob = chromeDriver.findElement(By.xpath("//*[@id=\"formly_8_ui-datepicker_dob_0\"]/div/input"));
        updateDob.sendKeys("01/09/2010");
        updateDob.sendKeys(Keys.ENTER);


        // Update Gender ==> oke
        Thread.sleep(400);
        WebElement updateGender = chromeDriver.findElement(By.xpath("//*[@id=\"formly_10_ui-select_gender_0\"]/nz-select-top-control/nz-select-search/input"));
        updateGender.sendKeys("Nam");
        updateGender.sendKeys(Keys.ENTER);

        // Update Province ==> chưa được

        Thread.sleep(400);
        WebElement updateCity = chromeDriver.findElement(By.xpath("//*[@id=\"formly_12_ui-select_city_3\"]/nz-select-top-control/nz-select-item/div"));
        updateCity.sendKeys("Tỉnh Lào Cai");
        updateCity.sendKeys(Keys.ENTER);

        // Update District ==> chưa được
        Thread.sleep(200);
        Select updateDistrict = new Select(chromeDriver.findElement(By.xpath("//*[@id=\"formly_12_ui-select_district_4\"]/nz-select-top-control/nz-select-item")));
        updateDistrict.selectByVisibleText("Huyện Si Ma Cai");

    }


    // Update thông tin tổ chức
    @Test
    public void Testcase5() throws InterruptedException {

        Thread.sleep(10000);

        // Scrolling to the "Thông tin liên hệ" => Để hiện "Thông tin tổ chức" ở giữa màn hình
        Actions actions = new Actions(chromeDriver);
        WebElement lastElement = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[1]"));
        actions.moveToElement(lastElement);
        actions.perform();

        // Open modal "Thông tin tổ chức"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-organization/div/div[1]/div[2]/button"))).click();

        // Update vị trí
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_11_ui-input_position_0\"]"))).sendKeys("Automation Tester");
        Thread.sleep(1000);
        WebElement togglePosition = chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-user-organization-modal/div/app-ui-form/formly-form/formly-field/formly-group/formly-field[1]/formly-group/formly-field[2]/ng-component/formly-field-nz-input/app-toggle/div/nz-switch/button"));
        Thread.sleep(1000);
        if (togglePosition.isSelected()) {
            togglePosition.click();
        }

        // Update Phòng ban
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_13_ui-input_department_0\"]"))).sendKeys("Technical Department");
        Thread.sleep(1000);
        WebElement toggleDepartment = chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-user-organization-modal/div/app-ui-form/formly-form/formly-field/formly-group/formly-field[2]/formly-group/formly-field[2]/ng-component/formly-field-nz-input/app-toggle/div/nz-switch/button"));
        Thread.sleep(1000);
        if (toggleDepartment.isSelected()) {
            toggleDepartment.click();
        }

        // Update Tổ chức
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_15_ui-input_organization_0\"]"))).sendKeys("Non-profit organization");
        Thread.sleep(1000);
        WebElement toggleOrganization = chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-user-organization-modal/div/app-ui-form/formly-form/formly-field/formly-group/formly-field[3]/formly-group/formly-field[2]/ng-component/formly-field-nz-input/app-toggle/div/nz-switch/button"));
        Thread.sleep(1000);
        if (toggleOrganization.isSelected()) {
            toggleOrganization.click();
        }

        // Update Lĩnh vưc
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_17_ui-input_major_0\"]"))).sendKeys("Information Technology");
        Thread.sleep(1000);
        WebElement toggleField = chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-user-organization-modal/div/app-ui-form/formly-form/formly-field/formly-group/formly-field[4]/formly-group/formly-field[2]/ng-component/formly-field-nz-input/app-toggle/div/nz-switch/button"));
        Thread.sleep(1000);
        if (toggleField.isSelected()) {
            toggleField.click();
        }


        // Check kết quả
//        String expectedValue = "Nam";
//        String actualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div"))).getText();
//        System.out.println(actualValue);
//
//        Assert.assertEquals(expectedValue,actualValue);

    }

}
