import org.example.BasePage;
import org.example.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.example.Utility.Utility.setUtilityDriver;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected BasePage basePage;
    protected FormPage formPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void loadApplication() {
        String URL = "https://demoqa.com/automation-practice-form";
        driver.get(URL);

        // Initialize page objects
        basePage = new BasePage();
        BasePage.setDriver(driver);
        setUtilityDriver();
        formPage=new FormPage();


    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
