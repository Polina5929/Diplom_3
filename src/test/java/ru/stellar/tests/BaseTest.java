package ru.stellar.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.stellar.api.StellarApiClient;

public class BaseTest {

    protected WebDriver driver;
    protected StellarApiClient apiClient = new StellarApiClient();
    protected String createdUserToken;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        ChromeOptions options = new ChromeOptions();

        if ("yandex".equalsIgnoreCase(browser)) {
            options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
            WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().browserVersion("150").setup();
        } else {
            WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().browserVersion("153").setup();
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (createdUserToken != null) {
            apiClient.deleteUser(createdUserToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot(description.getMethodName());
        }
    };

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    private byte[] takeScreenshot(String name) {
        if (driver == null) {
            return new byte[0];
        }
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}