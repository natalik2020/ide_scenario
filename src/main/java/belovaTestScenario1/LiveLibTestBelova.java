package belovaTestScenario1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiveLibTestBelova {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //runJsScriptExample();

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToLivelib();

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
    }

    private static void loginToLivelib() throws InterruptedException {
        driver.get("https://www.litlib.net");
        driver.findElement(By.name("fname")).sendKeys("student1");
        driver.findElement(By.name("pass")).sendKeys("123xaxa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
