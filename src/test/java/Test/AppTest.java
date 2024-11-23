package Test;

import Pages.LandingPage;
import Pages.Login;
import Pages.SingUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    //variables
    private WebDriver driver;
    private static String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";

    //páginas
    private LandingPage landing;
    private Login login;
    private SingUp singup;


    @BeforeEach
    public void preConditions(){
        landing = new LandingPage(driver);
        landing.conexionDriver(browser,rutaDriver,property);
        landing.maximize();
        landing.cargarPagina("https://osunlar.org/");
        login = new Login(landing.getDriver());
        singup = new SingUp(landing.getDriver());

    }

    @Test
    public void test001() {
        landing.goToLogin();
        login.createAccaunt();
        singup.clickRadioButton();
        singup.completarFormulario("Gabriel Esteban","Riquieri Castro","38221647","06091994","3805444444","email@test.omniman","calle 456","Barrio X","Pais","Contraseña4567");
    }

    public void test002(){

    }

    @AfterEach
    public void postConditions(){

    }
}
