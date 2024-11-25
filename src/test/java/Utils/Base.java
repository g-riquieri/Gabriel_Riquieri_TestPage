package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //metodos
    public Base(WebDriver driver){
        this.driver = driver;
    }//Constructor

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    //Funciones

    public void cargarPagina(String url){
        this.driver.get(url);
    } //Carga la página web

    public WebElement buscarElemento (By locator){
        return this.driver.findElement(locator);
    }//Busca un solo elemento

    public List<WebElement> buscarElementos (By locator){
        return this.driver.findElements(locator);
    }//Busca una lista de elementos

    public WebElement esperarElementoClickeable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void moverYHacerClic(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

    public void testScrollDown() throws InterruptedException {
        // Crear una instancia de JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hacer scroll hacia abajo en la página (por ejemplo, 500 píxeles)
        js.executeScript("window.scrollBy(0,500)");

        // Pausa para observar el scroll (opcional)
        Thread.sleep(2000);

        // Hacer scroll hasta el final de la página
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Pausa para observar el scroll (opcional)
        Thread.sleep(2000);
    }

    public WebElement getLabelElement(By locator) {
        // Esperar a que el elemento sea clickeable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement labelElement = wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Mover el cursor al elemento
        Actions actions = new Actions(driver);
        actions.moveToElement(labelElement).perform();

        // Hacer clic en el label
        labelElement.click();

        // Retornar el elemento para usos adicionales
        return labelElement;
    }

    public void click (By locator){
        this.driver.findElement(locator).click();
    }//Hace click en un elemento

    public void click (WebElement element){
        element.click();
    }//Hace click en un elemento

    public void esperarXMilisegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperaExplicita (By locator, int seg){
        wait = new WebDriverWait(this.driver,seg);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void  agregarTexto(By locator, String texto){
        this.driver.findElement(locator).sendKeys(texto);
    }

    public void  agregarTexto(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public void cerrar(){
        this.driver.close();
    }

    public void maximize(){
        this.driver.manage().window().maximize();
    }

    public void ddlXText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void iFrameXElement(WebElement element){
        this.driver.switchTo().frame(element);
    }

    public WebDriver conexionDriver(String browser, String route, String property){
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty(property,route);
            this.driver = new ChromeDriver();
        }

        if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty(property,route);
            this.driver = new FirefoxDriver();
        }
        return this.driver;
    }

    public boolean isDeployed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public String getText(WebElement elemento, String texto){
        return elemento.getAttribute(texto);
    }

    public void manejarModal(By locator) {
        // Espera explícita para el botón "Continuar"
        WebElement continuarButton = esperaExplicita(locator, 10);

        // Verificar que sea visible y clickeable antes de hacer clic
        if (continuarButton.isDisplayed() && continuarButton.isEnabled()) {
            continuarButton.click();
        } else {
            System.out.println("El botón 'Continuar' no está disponible para hacer clic.");
        }
    }


    public void ddlXIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void seleccionarPorIndice(By locator, int indice) {
        // Encontrar el elemento <select>
        WebElement dropdown = buscarElemento(locator);

        // Crear un objeto Select basado en el elemento <select>
        Select select = new Select(dropdown);

        // Seleccionar por índice
        select.selectByIndex(indice);
    }
}

