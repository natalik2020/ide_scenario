package belovaTestScenario1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BelovaTestScenario1_old {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://ya.ru");
        Thread.sleep(5000);
        firefoxDriver.quit();
    }

    public static void scenarioWithExtention(ChromeDriver driver) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=src/main/resources/chrome_profile");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.litlib.net");
        Thread.sleep(10000);
    }

    public static void runJsScriptExample(WebDriver driver) throws InterruptedException {
        driver.get("https://www.litlib.net");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("function getElementByXpath(path) {\n" +
                "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n" +
                "}\n" +
                "\n" +
                "getElementByXpath(\"//div[@data-test='HONEY-AD AD-ad_1']\").remove();");
        Thread.sleep(10000);
    }
}