package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */

public class AppTestPageObjectTest {
    public static final String A_TEXT_ПРОФИЛЬ = "//a[text()='Профиль']";
    public static final String TEXT_НАСТРОЙКИ = "//b[text()='Настройки']";
    public static final String INPUT_NAME_MY_NAME = "//input[@name='myName']";
    public static final String MY_SECOND_NAME = "//input[@name='mySecondName']";
    public static final String CONTAINS_TEXT_ЧИТАТЬ = "//a[contains(text(),'Читать')]";
    public static final String МИЛИТАРИУМ_МИР_НА_ГРАНИ = "//a[contains(text(),'Милитариум. Мир на грани')]";
    public static final String HREF_AUTHOR_23422 = "//a[contains(@href, '/author/23422')]";
    public static final String XPATH_POISK_PO_SAJTU = "//input[@name='sq']";
    public static final String XPATH_EXAMINATION_OGON_BYTYUA = "//div[contains(text(),'Огонь бытия')]";
    public static final String NAME_ICQ = "//input[@name='icq']";
    public static final String XPATH_CONTACTS = "//a[text()='Контакты']";
    public static final String XPATH_SECOND_NAME = "//input[@name='mySecondName']";
    public static final String XPATH_MY_NAME = "//input[@name='myName']";

    private WebDriverWait webDriverWait;
    private static WebDriver driver;

    @FindBy(xpath = A_TEXT_ПРОФИЛЬ)
    WebElement editPpofileText;
    @FindBy(xpath = TEXT_НАСТРОЙКИ)
    WebElement openSettingsTest;
    @FindBy(xpath = INPUT_NAME_MY_NAME)
    WebElement myNameInput;
    @FindBy(xpath = MY_SECOND_NAME)
    WebElement secondNameInput;
    @FindBy(xpath = CONTAINS_TEXT_ЧИТАТЬ)
    WebElement readingBook;
    @FindBy(xpath = МИЛИТАРИУМ_МИР_НА_ГРАНИ)
    WebElement militariumBook;
    @FindBy(xpath = HREF_AUTHOR_23422)
    WebElement aliceBelovaLink;
    @FindBy(xpath = "//input[@type='image']")
    WebElement goInput;
    @FindBy(xpath = XPATH_POISK_PO_SAJTU)
    WebElement searchSiteInput;
    @FindBy(xpath = XPATH_EXAMINATION_OGON_BYTYUA)
    WebElement examTextOgon;
    @FindBy(xpath = NAME_ICQ)
    WebElement icqInput;
    @FindBy(xpath = XPATH_CONTACTS)
    WebElement contactsLink;
    @FindBy(xpath = XPATH_SECOND_NAME)
    WebElement surnameInput;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement inputSubmitType;
    @FindBy(xpath = XPATH_MY_NAME)
    WebElement nameElement;


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
        driver.quit();
    }

    @Test
    @Description("Тест на изменение профиля")
    public void settingsName() throws InterruptedException {
        editProfile();
        openSettings();
        editMyName();
        editMySurname();

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

    @Step("Заполнить фамилию")
    private void editMySurname() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(MY_SECOND_NAME)));
            secondNameInput.sendKeys("Лаврухина");
        }
    }

    @Step("Заполнить имя")
    private void editMyName() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_NAME_MY_NAME)));
            myNameInput.sendKeys("Наталия");
        }
    }

    @Step("Открыть настройки")
    private void openSettings() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEXT_НАСТРОЙКИ)));
            openSettingsTest.click();
        }
    }

    @Step("Редактировать профиль")
    private void editProfile() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(A_TEXT_ПРОФИЛЬ)));
            editPpofileText.click();
        }
    }

    @Test
    @Description("Поиск писателя Алиса Белова")
    public void testBelova() throws InterruptedException {
        siteSearching();
        go();
        openAliceBelova();
        openBookMilitarium();
        reading();

        //Проверка
        {
            Thread.sleep(2000);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_EXAMINATION_OGON_BYTYUA)));
            String text = examTextOgon.getText();
            Assertions.assertTrue(text.contains("Огонь бытия"));
        }
    }

    @Step("Читать книгу")
    private void reading() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTAINS_TEXT_ЧИТАТЬ)));
            readingBook.click();
        }
    }

    @Step("Открыть книгу")
    private void openBookMilitarium() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(МИЛИТАРИУМ_МИР_НА_ГРАНИ)));
            militariumBook.click();
        }
    }

    @Step("Открыть профиль Алиса Белова")
    private void openAliceBelova() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(HREF_AUTHOR_23422)));
            aliceBelovaLink.click();
        }
    }

    @Step("Go!")
    private void go() {
        {
            goInput.click();
        }
    }

    @Step("Поиск по сайту")
    private void siteSearching() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_POISK_PO_SAJTU)));
            searchSiteInput.sendKeys("Белова");
        }
    }

    @Test
    @Description("Тест на ввод букв в цифровое поле")
    public void testNegativeBukvyNomer() throws InterruptedException {
        editProfile();
        openSettings();
        editContacts();
        vvodIcq();

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

    @Step("Заполнить поле ICQ")
    private void vvodIcq() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(NAME_ICQ)));
            icqInput.sendKeys("проверка");
        }
    }

    @Step("Заполнить поле контакты")
    private void editContacts() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_CONTACTS)));
            contactsLink.click();
        }
    }

    @Test
    @Description("Тест на удаление из профиля обязательного поля имя")
    public void settingsNameNegative() throws InterruptedException {
        editProfile();
        openSettings();
        name();
        surname();

        //Проверка
        {
            Thread.sleep(4000);
            String xpathExpression = "//div[contains(text(),'Ошибка! Необходимо заполнить все поля')]";
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            String text = driver.findElement(By.xpath(xpathExpression)).getText();
            Assertions.assertTrue(text.contains("Ошибка! Необходимо заполнить все поля."));
        }
    }

    @Step("Заполнить поле фамилия")
    private void surname() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SECOND_NAME)));
            surnameInput.sendKeys("   ");

            inputSubmitType.click();
        }
    }

    @Step("Заполнить поле имя")
    private void name() {
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_MY_NAME)));
            nameElement.clear();
            nameElement.sendKeys("   ");
        }
    }

    @Step("Залогиниться")
    private void loginToLivelib() {
        driver.get("https://www.litlib.net");
        driver.findElement(By.name("fname")).sendKeys("student1");
        driver.findElement(By.name("pass")).sendKeys("123xaxa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
