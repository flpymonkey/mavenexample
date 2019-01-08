import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bencj\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.wolframalpha.com/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testPageTitle(){
        Assert.assertTrue(driver.getTitle().contains("Wolf"));
    }
}
