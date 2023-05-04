package pe.edu.upc.onewebs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class AgregarDetenido {
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
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void agregardetenido() {
        driver.get("http://localhost:8081/");
        driver.manage().window().setSize(new Dimension(1053, 799));
        driver.findElement(By.linkText("Registrarse")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("123");
        driver.findElement(By.cssSelector(".form-row:nth-child(2) > .form-group")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("registrar")).click();
        driver.findElement(By.id("inputUsername")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("123");
        driver.findElement(By.id("inputPassword")).click();
        driver.findElement(By.id("inputPassword")).sendKeys("123");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.name("link-detainee")).click();
        driver.findElement(By.linkText("Nuevo")).click();
        driver.findElement(By.id("dni")).click();
        driver.findElement(By.id("dni")).sendKeys("12345678");
        driver.findElement(By.id("apellidos")).click();
        driver.findElement(By.id("apellidos")).sendKeys("Perez Sanchez");
        driver.findElement(By.id("nombres")).sendKeys("Juan");
        driver.findElement(By.id("fechaNacimiento")).sendKeys("0002-08-01");
        driver.findElement(By.id("fechaNacimiento")).sendKeys("0020-08-01");
        driver.findElement(By.id("fechaNacimiento")).sendKeys("0200-08-01");
        driver.findElement(By.id("fechaNacimiento")).sendKeys("2000-08-01");
        driver.findElement(By.id("distrito")).click();
        driver.findElement(By.id("distrito")).sendKeys("La Molina");
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.cssSelector("tr:nth-child(14) > td:nth-child(4)")).click();
    }
}