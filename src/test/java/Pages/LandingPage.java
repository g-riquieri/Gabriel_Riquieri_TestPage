package Pages;

import Utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Base {

    public LandingPage(WebDriver driver){
        super(driver);
    }//Constructor

    //Acciones de la página
    public void goToLogin(){
        click(esperaExplicita(By.xpath("//a[@id='boton6']"),10));
    }

}
