package Practice_TC;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class update_contactinfor {

    WebDriver chromeDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

    @BeforeMethod
    public void sepUp() throws InterruptedException {

        // Direct to Login Page of TrueConnect
        chromeDriver.get("https://id.trueconnect.vn/Account/login");

        // Find element Account and Send key
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Username\"]"))).sendKeys("charlotte");

        // Find element Password and Send key
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Password\"]"))).sendKeys("Nam@1901");

        // Find element Login button and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/div/div/form/div[6]/button"))).click();

        // Direct to Danh thiep dien tu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[4]/a[1]/button"))).click();

        // Sleep 10s
        Thread.sleep(10000);

    }

    @Test
    public void addNew() {

        // Scroll to Contact Inform to clickable
        Actions actions = new Actions(chromeDriver);
        WebElement desElement = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[2]/app-contacts-list/div/app-contact-list-item[7]/div/div[3]/button"));
        actions.moveToElement(desElement);
        actions.perform();

        // Open modal add new Contact Inform
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[1]/div[2]/button[1]"))).click();

        // Add Type of Contact Inform
        WebElement type = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_11_ui-select_type_0\"]/nz-select-top-control/nz-select-search/input")));
        type.sendKeys("github");
        type.sendKeys(Keys.ENTER);

        // Add new Data
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_11_ui-input_value_4\"]"))).sendKeys("This data is created by auto test");

        // Check toggle selected
        WebElement toggle = chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-contacts-edit-modal/div/div/app-ui-form/formly-form/formly-field/formly-group/formly-field[1]/formly-group/formly-field[2]/ng-component/formly-field-nz-input/app-toggle/div/nz-switch/button"));

        if (!toggle.isSelected()) {
            toggle.click();
        }

        // Config default
        WebElement checkboxDefault = chromeDriver.findElement(By.xpath("//*[@id=\"formly_11_checkbox_useAsBase_8\"]/span[1]/input"));

        if (!checkboxDefault.isSelected()) {
            checkboxDefault.click();
        }

        // Click Save button
        chromeDriver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-contacts-edit-modal/div/div/div/div/button[2]")).click();

    }


// Compare 2 Values has a bug. Actual not record the new data.
    @Test
    public void upDate() throws InterruptedException {

        // Scroll to Contact Inform to clickable
        Actions actions = new Actions(chromeDriver);
        WebElement desElement = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[2]/app-contacts-list/div/app-contact-list-item[7]/div/div[3]/button"));
        actions.moveToElement(desElement);
        actions.perform();

        // Open modal update Contact Inform
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[2]/app-contacts-list/div/app-contact-list-item[1]/div/div[3]/button"))).click();



        // Edit data
        String expectedValue = "autotest3@selenium.java";
        WebElement dataInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formly_11_ui-input_emailValue_7\"]")));
        dataInput.clear();
        dataInput.sendKeys(expectedValue);


        // Click Save button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-0\"]/nz-modal-container/div/div/div/app-contacts-edit-modal/div/div/div/div/button[2]"))).click();

        // Compare result from update Contact Information
        String actualValue = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[2]/app-contacts-list/div/app-contact-list-item[1]/div/button/div[2]/span")).getText();
        chromeDriver.navigate().refresh();  // reload page

        Thread.sleep(10000);

        // Scroll to Contact Inform to clickable
        WebElement desElement2 = chromeDriver.findElement(By.xpath("/html/body/app-root/app-main/div/div[2]/app-user/div/app-edit/div/div/app-user-contacts-manager/div/div[2]/app-contacts-list/div/app-contact-list-item[7]/div/div[3]/button"));
        actions.moveToElement(desElement2);
        actions.perform();

        Assert.assertEquals(actualValue,expectedValue);

    }

}
