package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.WebElement;
>>>>>>> mluukkai-lokaali
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
<<<<<<< HEAD
        driver.get("http://localhost:8090");

        luoKayttajaJaKirjauduUlos(driver, "koira7");
        tulostaSivunSisalto(driver);
    }
    
    private static void luoKayttajaJaKirjauduUlos(WebDriver driver, String username) {
        luoUusiKayttaja(driver, username);
        klikkaaLinkkia(driver, "continue to application mainpage");
        klikkaaLinkkia(driver, "logout");
    }
    
    private static void luoUusiKayttaja(WebDriver driver, String username) {
        klikkaaLinkkia(driver, "register new user");
        taytaUudenKayttajanKentat(driver, username);
        lahetaLomake(driver, "add");
    }
    
    private static void epaonnistunutKirjautuminenEiValidiKayttaja(WebDriver driver) {
        yritaKirjautua(driver, "pekka3", "invalid");
    }
    
    private static void epaonnistunutKirjautuminenOikeaKayttaja(WebDriver driver) {
        yritaKirjautua(driver, "pekka", "invalid");
    }
    
    private static void kirjautuminenOnnistuu(WebDriver driver) {
        yritaKirjautua(driver, "pekka", "akkep");
    }
    
    private static void yritaKirjautua(WebDriver driver, String username, String password) {
        klikkaaLinkkia(driver, "login");
        kirjaudu(driver, username, password);
    }
    
    private static void klikkaaLinkkia(WebDriver driver, String nimi) {
        driver.findElement(By.linkText(nimi)).click();
    }
    
    private static void kirjaudu(WebDriver driver, String username, String password) {
        taytaUsernameJaPasswordKentat(driver, username, password);
        lahetaLomake(driver, "login");
    }
    
    private static void taytaUudenKayttajanKentat(WebDriver driver, String username) {
        String password = "passi345";
        
        taytaUsernameJaPasswordKentat(driver, username, password);
        taytaKentta(driver, "passwordConfirmation", password);
    }
    
    private static void taytaUsernameJaPasswordKentat(WebDriver driver, String username, String password) {
        taytaKentta(driver, "username", username);
        taytaKentta(driver, "password", password);
    }
    
    private static void taytaKentta(WebDriver driver, String kentanNimi, String sisalto) {
        driver.findElement(By.name(kentanNimi)).sendKeys(sisalto);
    }
    
    private static void lahetaLomake(WebDriver driver, String buttonName) {
        driver.findElement(By.name(buttonName)).submit();
    }
    
    private static void tulostaSivunSisalto(WebDriver driver) {
        System.out.println( driver.getPageSource() );
=======

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
>>>>>>> mluukkai-lokaali
    }
}
