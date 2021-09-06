package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */

public class AppTestPageObject {
    private WebDriverWait webDriverWait;
    private static WebDriver driver;
    public static final String A_TEXT_ПРОФИЛЬ = "//a[text()='Профиль']";

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);

        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 5);

        loginToLivelib();
    }

    @AfterEach
    void tearDown() {
        // driver.quit();
    }

    @Test
    public void settingsName() throws InterruptedException {
        Profile();
        Settings();
        MyName();
        MySurname();

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

    private void MySurname() {
        //фамилия
        {
            String xpathExpression = "//input[@name='mySecondName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Лаврухина");
        }
    }

    private void MyName() {
        //имя
        {
            String xpathExpression = "//input[@name='myName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Наталия");
        }
    }

    private void Settings() {
        //настройки
        {
            String xpathExpression = "//b[text()='Настройки']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    private void Profile() {
        //профиль
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(A_TEXT_ПРОФИЛЬ)));
            driver.findElement(By.xpath(A_TEXT_ПРОФИЛЬ)).click();
        }
    }

    @Test
    public void testBelova() throws InterruptedException {
        SiteSearching();
        Go();
        AliceBelova();
        BookMilitarium();
        Read();

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'Огонь бытия')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("Огонь бытия"));
        }
    }

    private void Read() {
        //Читать
        {
            String xpathExpression = "//a[contains(text(),'Читать')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    private void BookMilitarium() {
        //  Милитариум. Мир на грани
        {
            String xpathExpression = "//a[contains(text(),'Милитариум. Мир на грани')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    private void AliceBelova() {
        //Алиса Белова
        {
            String xpathExpression = "//a[contains(@href, '/author/23422')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    private void Go() {
        //Go
        {
            driver.findElement(By.xpath("//input[@type='image']")).click();
        }
    }

    private void SiteSearching() {
        //Поиск по сайту
        {
            String xpathExpression = "//input[@name='sq']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("Белова");
        }
    }

    @Test
    public void testNegativeBukvyNomer() throws InterruptedException {
        Profile();
        Settings();
        Contacts();
        Icq();

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

    private void Icq() {
        {
            String xpathExpression = "//input[@name='icq']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("проверка");
        }
    }

    private void Contacts() {
        {
            String xpathExpression = "//a[text()='Контакты']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    @Test
    public void settingsNameNegative() throws InterruptedException {
        Profile();
        Settings();
        Name();
        Surname();

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

   /* //Проверка
    {
        Thread.sleep(4000);
        String xpathExpression = "//div[contains(text(),'Ошибка! Необходимо заполнить все поля')]";
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        String text = driver.findElement(By.xpath(xpathExpression)).getText();
        Assertions.assertTrue(text.contains("Ошибка! Необходимо заполнить все поля."));
    }*/

    private void Surname() {
        //фамилия
        {
            String xpathExpression = "//input[@name='mySecondName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            driver.findElement(By.xpath(xpathExpression)).sendKeys("   ");
        }
    }

    private void Name() {
        //имя
        {
            String xpathExpression = "//input[@name='myName']";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            WebElement element = driver.findElement(By.xpath(xpathExpression));
            element.clear();
            element.sendKeys("   ");
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
