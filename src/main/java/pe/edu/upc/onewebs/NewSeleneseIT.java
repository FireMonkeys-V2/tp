package pe.edu.upc.onewebs;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class NewSeleneseIT {
	
	private WebDriver driver = null;
	
	@BeforeClass
	public void inicializarDriver() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\delam\\OneDrive - Universidad Peruana de Ciencias\\Project Java\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions(); //.setExperimentalOption("debuggerAddress", "localhost:9014");
		//options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	
	public void testCrearUsuario() {
		//Aquí obtenemos la url que queremos probar
		driver.get("http://localhost:8081/onewebs/signup");
		//Esta condicion espera que la pagina cargue correctamente antes de hacer algo
		ExpectedCondition<Boolean> pageLoadCondition = new
			ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				}
			};
			
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5L));
		wait.until(pageLoadCondition);

		//Obtenemos la referencia al campo usuario
		WebElement username = driver.findElement(By.id("username"));
		//Seteamos valores
		username.sendKeys("zirtrex");
		//Obtenemos la referencia al campo password
		WebElement password = driver.findElement(By.id("password"));
		//Seteamos valores
		password.sendKeys("123456");

		//Hacemos click en el boton registrar
		WebElement btnRegistrar = driver.findElement(By.id("registrar"));
		btnRegistrar.click();

		//Tenemos que volver a esperar que cargue bien la página
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5L));
		wait2.until(pageLoadCondition);

		WebElement mensaje = driver.findElement(By.id("inputUsername"));
		wait2.until(ExpectedConditions.visibilityOf(mensaje));

		//Agregamos un Assert
		Assert.assertEquals("", mensaje.getText());
	}

}