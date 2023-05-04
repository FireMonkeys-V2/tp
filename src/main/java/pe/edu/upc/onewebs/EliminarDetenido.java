package pe.edu.upc.onewebs;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class EliminarDetenido {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Miguel Garcia\\Desktop\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions(); //.setExperimentalOption("debuggerAddress", "localhost:9014");
        //options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    public void delete() {
        driver.get("http://localhost:8081/");
        driver.manage().window().setSize(new Dimension(1330, 792));
        driver.findElement(By.linkText("Registrarse")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Police1");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("registrar")).click();
        driver.findElement(By.id("inputUsername")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("Police1");
        driver.findElement(By.id("inputPassword")).sendKeys("12345");
        driver.findElement(By.id("inputPassword")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("link-detainee")).click();
        driver.findElement(By.cssSelector("tr:nth-child(13) .btn-danger > .fas")).click();
        driver.findElement(By.name("link-detainee")).click();
    }
}
