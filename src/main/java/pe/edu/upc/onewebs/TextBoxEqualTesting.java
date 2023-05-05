package pe.edu.upc.onewebs;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;

public class TextBoxEqualTesting {
    private WebDriver driver = null;
    public WebElement boton1;
    public WebElement boton2;
    public WebElement textBox;
    public WebElement Assertion;

    @BeforeClass
    public void inicializarDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Miguel Garcia\\Desktop\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions(); //.setExperimentalOption("debuggerAddress", "localhost:9014");
        //options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/elements");
    }

    @Test()
    public void test1() throws InterruptedException{
        driver.get("https://demoqa.com/elements");
        boton1 =driver.findElement(By.id("item-0"));
        boton1.click();
        textBox = driver.findElement(By.id("userName"));
        textBox.click();
        textBox.sendKeys("Juan Perez");
        boton2 = driver.findElement(By.id("submit"));
        boton2.click();

        Assertion = driver.findElement(By.id("name"));
        Assert.assertEquals("Name:Juan Aranda", Assertion.getText());
    }
}
