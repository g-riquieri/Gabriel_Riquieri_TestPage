package Test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    @Test
    public void test001(){
        String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe";
        System.out.println(rutaDriver);
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        WebDriver driver = new ChromeDriver();
        driver.get("https://osunlar.org/");
    }
}
