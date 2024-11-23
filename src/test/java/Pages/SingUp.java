package Pages;

import Utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingUp extends Base {

    //localizadores
    private final By byTipoRegistro = By.xpath("//a[contains(@for,'Crear Cuenta')]");


    public SingUp(WebDriver driver) {
        super(driver);
    }

    //Actions

    public void clickRadioButton() {
        getLabelElement(By.xpath("//label[@for='customRadio2']"));
    }

    public void completarFormulario(String nombre, String apellido, String dni,String fechaDeNaciemiento,String telefono, String email, String calle,String barrio, String pais, String pass) {
        agregarTexto(esperaExplicita(By.xpath("//input[@name='nombre']"),10),nombre);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='apellido']"),10),apellido);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='dni']"),10),dni);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='fecha_nacimiento']"),10),fechaDeNaciemiento);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='email']"),10),email);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='telefono']"),10),telefono);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='calle']"),10),calle);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='barrio']"),10),barrio);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='pais']"),10),pais);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='pass']"),10),pass);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='pass2']"),10),pass);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='form-control btn btn-warning']"))).click();

    }



}
