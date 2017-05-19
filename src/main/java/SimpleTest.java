import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by d.lihodedov on 19.05.2017.
 */
public class SimpleTest {
    private static ChromeDriverService service;
    public static WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:/chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        service.start();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver(service);
    }

    @Test
    public void simpleTest() throws InterruptedException {
        driver.get("https://vk.com");
        driver.getPageSource();
       // WebElement element = driver.findElement(By.id("quick_email"));
//element.click();
        //element.sendKeys("adf");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }
}
