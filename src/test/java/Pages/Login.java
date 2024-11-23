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
}
