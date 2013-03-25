import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class inlog-dms {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void inlog-dms() {
        wd.get("https://mnh-vd-03.mnhnl.minihouse/dms/");
        wd.findElement(By.xpath("//div[@class='form_box']//div[.='Gebruikersnaam - ']")).click();
        wd.findElement(By.name("gebruikersnaam")).click();
        wd.findElement(By.name("gebruikersnaam")).clear();
        wd.findElement(By.name("gebruikersnaam")).sendKeys("test");
        wd.findElement(By.name("wachtwoord:")).click();
        wd.findElement(By.name("wachtwoord:")).clear();
        wd.findElement(By.name("wachtwoord:")).sendKeys("test");
        wd.findElement(By.xpath("//div[@class='form_box']/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='loginbuttons']//button[.='Inloggen']")).click();
        wd.findElement(By.xpath("//div[@class='modules']/div[1]/div/img")).click();
    }
    
    @After
    public void tearDown() {
        wd.close();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
