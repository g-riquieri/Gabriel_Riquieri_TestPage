package Test;

import Pages.LandingPage;
import Pages.Login;
import Pages.Panel;
import Pages.SingUp;
import Utils.Base;
import Utils.DataDriven;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

public class AppTest {
    //variables
    private WebDriver driver;
    private WebDriverWait wait;
    private static String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";
    private ArrayList<String> data;

    //páginas
    private LandingPage landing;
    private Login login;
    private SingUp singup;
    private Panel panel;


    @BeforeEach
    public void preConditions(){
        data = new ArrayList<String>();
        landing = new LandingPage(driver);
        landing.conexionDriver(browser,rutaDriver,property);
        landing.maximize();
        landing.cargarPagina("https://osunlar.org/");
        login = new Login(landing.getDriver());
        singup = new SingUp(landing.getDriver());
        panel = new Panel(landing.getDriver());

    }

    @Test
    //Verificar que se pueda crear un usuario visitante correctamente.
    public void test001_CreacionDeUsuarioVisitante_Positivo() {
        data= DataDriven.getTestData("test001_CreacionDeUsuarioVisitante_Positivo");
        landing.goToLogin();
        login.createAccaunt();
        singup.clickRadioButton();
        singup.completarFormulario(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),data.get(10));
        String respuestaEsperada = "Registro con éxito";
        singup.esperarXMilisegundos(3000);
        WebElement mensajeExito = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-success') and contains(text(),'Registro con éxito')]")));

        Assertions.assertEquals(respuestaEsperada, mensajeExito.getText(), "El mensaje de registro no coincide con el esperado.");

    }

    @Test
    //Confirmar que no se permite la creación de usuario con campos vacíos.
    public void test002_CreacionDeUsuarioVisitante_Negtivo() {
        data= DataDriven.getTestData("test002_CreacionDeUsuarioVisitante_Negtivo");
        landing.goToLogin();
        login.createAccaunt();
        singup.clickRadioButton();
        singup.completarFormulario(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),data.get(10));
        WebElement mensajeError = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-danger') and contains(text(),'Todos los campos son obligatorios')]")));

        Assertions.assertTrue(mensajeError.isDisplayed(), "El mensaje de error por campos vacíos no se mostró.");
    }

    @Test
    //Validar que el sistema no acepte correos con formato incorrecto.
    public void test003_VerificacionDeCorreo_Negativo(){
        data= DataDriven.getTestData("test003_VerificacionDeCorreo_Negativo");
        landing.goToLogin();
        login.createAccaunt();
        singup.clickRadioButton();
        singup.completarFormulario(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),data.get(10));
        WebElement mensajeError = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-danger') and contains(text(),'Correo no válido')]")));

        Assertions.assertTrue(mensajeError.isDisplayed(), "El mensaje de error por correo inválido no se mostró.");
    }

    @Test
    //Confirmar que un visitante pueda inscribirse en una actividad correctamente.
    public void test004_InscripcionAActividad_Positivo(){
        data= DataDriven.getTestData("test004_InscripcionAActividad_Positivo");
        landing.goToLogin();
        login.login(data.get(1), data.get(2));
        panel.inscription();
        WebElement mensajeExito = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("")));

        Assertions.assertTrue(mensajeExito.isDisplayed(), "El mensaje de éxito en la inscripción no se mostró.");
    }

    @Test
    //Confirmar que los datos del perfil se mantengan tras cerrar sesión.
    public void test005_InscripcionAActividad_Positivo(){
        data= DataDriven.getTestData("test005_InscripcionAActividad_Positivo");
        landing.goToLogin();
        login.login(data.get(1), data.get(2));
        panel.cerrarSesion();

    }

    @AfterEach
    public void postConditions(){
       landing.cerrar();
    }
}
