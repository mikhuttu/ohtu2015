import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can log in with valid username/password-combination'

scenario "user can login with correct password", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
<<<<<<< HEAD
        element = driver.findElement(By.linkText("login"));
        element.click();
=======
        element = driver.findElement(By.linkText("login"));       
        element.click();       
>>>>>>> mluukkai-lokaali
    }

    when 'a valid username and password are given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
 
    then 'user will be logged in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "user can not login with incorrect password", {
<<<<<<< HEAD
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("login"));       
        element.click();
    }

    when 'a valid username and incorrect password are given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salsanaa");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    then 'user will not be logged in to system', {
        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
}

scenario "nonexistent user can not login to system", {
    given 'login selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("login"));
        element.click();
    }

    when 'a nonexistent username and some password are given', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salsanaa3");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    then 'user will not be logged in to system', {
        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
=======
    given 'command login selected'
    when 'a valid username and incorrect password are given'
    then 'user will not be logged in to system'
}

scenario "nonexistent user can not login to system", {
    given 'command login selected'
    when 'a nonexistent username and some password are given'
    then 'user will not be logged in to system'
>>>>>>> mluukkai-lokaali
}