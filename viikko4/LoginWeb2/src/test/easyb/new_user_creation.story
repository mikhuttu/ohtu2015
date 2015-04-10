import ohtu.*
import ohtu.authentication.*
import ohtu.data_access.*
import ohtu.domain.*
import ohtu.form.*

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation successful with correct username and password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("register new user")).click();
    }
 
    when 'a valid username and password are entered', {
        driver.findElement(By.name("username")).sendKeys("koira1");
        driver.findElement(By.name("password")).sendKeys("abc12345");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("abc12345");

        driver.findElement(By.name("add")).submit();
    }

    then 'new user is registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'command login is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("login")).click();
    }
 
    when 'a valid username and password are entered', {
        driver.findElement(By.name("username")).sendKeys("koira1");
        driver.findElement(By.name("password")).sendKeys("abc12345");

        driver.findElement(By.name("login")).submit();
    }

    then  'new credentials allow logging in to system', {
       driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("register new user")).click();
    }

    when 'a valid username and too short password are entered', {
        driver.findElement(By.name("username")).sendKeys("koira2");
        driver.findElement(By.name("password")).sendKeys("abc1234");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("abc1234");

        driver.findElement(By.name("add")).submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length greater or equal to 8").shouldBe true
    }
}

scenario "creation fails with correct username and password consisting of letters", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("register new user")).click();
    }

    when 'a valid username and password consisting of letters are entered', {
        driver.findElement(By.name("username")).sendKeys("koira2");
        driver.findElement(By.name("password")).sendKeys("abcdefghj");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("abcdefghj");

        driver.findElement(By.name("add")).submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("must contain one character that is not a letter").shouldBe true
    }
}

scenario "creation fails with too short username and valid password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("register new user")).click();
    }

    when 'a too short username and valid password are entered', {
        driver.findElement(By.name("username")).sendKeys("koir");
        driver.findElement(By.name("password")).sendKeys("abc12345");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("abc12345");

        driver.findElement(By.name("add")).submit();
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length 5-10").shouldBe true
    }
}

scenario "creation fails with already taken username and valid password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("register new user")).click();
    }

    when 'a already taken username and valid password are entered', {
        driver.findElement(By.name("username")).sendKeys("koira1");
        driver.findElement(By.name("password")).sendKeys("abc123456");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("abc123456");
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("Create username and give password").shouldBe true
    }
}

scenario "can not login with account that is not successfully created", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       driver.findElement(By.linkText("login")).click();
    }

    when 'a invalid username/password are entered', {
        driver.findElement(By.name("username")).sendKeys("koira2");
        driver.findElement(By.name("password")).sendKeys("abcdefghj");
        
        driver.findElement(By.name("login")).submit();
    }

    then  'new credentials do not allow logging in to system', {
        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
}