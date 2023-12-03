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

public class contact {

    // set up Driver environment
    WebDriver chromeDrivers = new ChromeDriver();


    // set up wait syntax
    WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));



    // set up chrome driver
    @BeforeMethod
    public void setUp() {

        chromeDriver.get("https://id.trueconnect.vn/Account/login");

        // send key username and password
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Username\"]"))).sendKeys("charlotte");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Password\"]"))).sendKeys("Nam@1901");

        WebElement remember = chromeDriver.findElement(By.xpath("//*[@id=\"RememberLogin\"]"));
        // check and click remember me
        if (!remember.isSelected()) {
            remember.click();
        }

        // click login
        chromeDriver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/form/div[6]/button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[4]/a[1]/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tabs\"]/a[2]"))).click();


    }

    @AfterMethod
    public void tearDown() {

    }

    @Test
    public void findContact() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-phonebook/div/div[2]/nz-input-group/span/input"))).sendKeys("Noss");


    }
    @Test
    public void changeName() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-phonebook/div/div[2]/app-phonebook-list/app-phonebook-item[1]/div/div[3]/button[3]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/div[2]/div/div[2]/div/button"))).click();

        WebElement inputName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_1_ui-input_displayname_0\"]")));
        inputName.clear();
        inputName.sendKeys("This content is created by Automation Test");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-1\"]/nz-modal-container/div/div/div/app-phonebook-item-edit/div/div/div/div/button"))).click();


        WebElement newName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-phonebook/div/div[2]/app-phonebook-list/app-phonebook-item[1]/div/div[2]/span[1]")));
        String actualValue = newName.getText();

        String expectedValue = "This content is created by Automation Test";

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void downloadContact() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-phonebook/div/div[2]/app-phonebook-list/app-phonebook-item[5]/div"))).click();
        // download file vcf in my computer
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-profile/div/app-profile-banner/div[2]/div[2]/button"))).click();
    }






}
