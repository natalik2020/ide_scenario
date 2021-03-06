package belovaTestScenario1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.*;

public class LiveLibTest {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //runJsScriptExample();

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToLivelib();

        //профиль
        {
            String xpathExpression = "//a[text()='Профиль']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //настройки
        {
            String xpathExpression = "//b[text()='Настройки']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //имя
        {
            String xpathExpression = "//input[@name='myName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Наталия");

        }

        //фамилия
        {
            String xpathExpression = "//input[@name='mySecondName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Лаврухина");
        }

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    private static void loginToLivelib() throws InterruptedException {
        driver.get("https://www.litlib.net");
        //Thread.sleep(2000);
        driver.findElement(By.name("fname")).sendKeys("student1");
        driver.findElement(By.name("pass")).sendKeys("123xaxa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
