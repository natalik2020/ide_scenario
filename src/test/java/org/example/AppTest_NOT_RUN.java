package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */

public class AppTest_NOT_RUN {
    private WebDriverWait webDriverWait;
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {

        WebDriverManager.chromedriver().setup();
        if (true){ //todo remove
            throw new RuntimeException();
        }
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 5);

        loginToLivelib();
    }

    @AfterEach
    void tearDown() {
       driver.quit();
    }

    @Test
    public void settingsName() throws InterruptedException {
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

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'профиль изменен')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("профиль изменен"));
        }
    }

    @Test
    public void testBelova() throws InterruptedException {

        //Поиск по сайту
        {
            String xpathExpression = "//input[@name='sq']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Белова");
        }

        //Go
        {
            driver.findElement(By.xpath("//input[@type='image']")).click();
        }

        //Алиса Белова
        {
            String xpathExpression = "//a[contains(@href, '/author/23422')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //  Милитариум. Мир на грани
        {
            String xpathExpression = "//a[contains(text(),'Милитариум. Мир на грани')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //Читать
        {
            String xpathExpression = "//a[contains(text(),'Читать')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'Огонь бытия')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("Огонь бытия"));
        }
    }

    @Test
    public void testNegativeBukvyNomer() throws InterruptedException {
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

        //Контакты
        {
            String xpathExpression = "//a[text()='Контакты']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }

        //ICQ
        {
            String xpathExpression = "//input[@name='icq']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("проверка");
        }

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'профиль изменен')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("профиль изменен"));
        }
    }

    @Test
    public void settingsNameNegative() throws InterruptedException {

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
            WebElement element = driver.findElement(By.xpath(xpathExpression));
            element.clear();
            element.sendKeys("   ");
        }

        //фамилия
        {
            String xpathExpression = "//input[@name='mySecondName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("   ");
        }

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'Ошибка! Необходимо заполнить все поля')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("Ошибка! Необходимо заполнить все поля."));
        }
    }

    private void loginToLivelib() {
        driver.get("https://www.litlib.net");
        //Thread.sleep(2000);
        driver.findElement(By.name("fname")).sendKeys("student1");
        driver.findElement(By.name("pass")).sendKeys("123xaxa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
