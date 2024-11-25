package Pages;

import Utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

    public Login(WebDriver driver) {
        super(driver);
    }//Constructor


    //Actions
    public void createAccaunt(){
        click(esperaExplicita(By.xpath("//a[@href='/singup']"), 10));
    }

    public void login(String dni, String pass){
        agregarTexto(esperaExplicita(By.xpath("//input[@name='usuario']"),10),dni);
        agregarTexto(esperaExplicita(By.xpath("//input[@name='clave']"),10),pass);
        click(By.xpath("//button[@class='btn btn-warning']"));
    }
}
