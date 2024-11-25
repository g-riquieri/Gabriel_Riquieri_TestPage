package Pages;

import Utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Panel extends Base {

    public Panel(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void inscription(){
        esperarXMilisegundos(1000);
        WebElement cartel = driver.findElement(By.xpath("//h4[contains(text(),'OSUNLaR Se Mueve')]"));
        moverYHacerClic(cartel);
        esperarXMilisegundos(3000);
        manejarModal(By.xpath("//button[@id='btnNo']"));
        seleccionarPorIndice(By.id("doc-id-inscripto"),1);
        seleccionarPorIndice(By.id("tipo-actividad"),0);
        seleccionarPorIndice(By.id("actividad"),2);
        esperarXMilisegundos(2000);
        seleccionarPorIndice(By.id("horario"),1);
        seleccionarPorIndice(By.id("select-metodopago"),0);
        agregarTexto(By.xpath("//input[@id='fechanacinscripto']"),"06091994");
        click(By.xpath("//button[@id='btn_confirmar']"));
    }

    public void cerrarSesion(){
        esperarXMilisegundos(3000);
        click(esperaExplicita(By.xpath("//div[contains(text(),'Cerrar Sesión')]"),10));

    }
}
