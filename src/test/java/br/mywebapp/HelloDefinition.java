package br.mywebapp;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class HelloDefinition {

	WebDriver driver = null;

	@Before
	public void beforeScenario(){
		driver = getDriver();
	}

	@After
	public void afterScenario(){
		driver.close();
	}

	@Dado("que eu acesso a página inicial")
	public void que_eu_acesso_a_página_inicial() {
		driver.get("http://localhost:9090/");
	}

	@Então("eu devo ver o texto {string}")
	public void eu_devo_ver_o_texto(String string) {
		String text = driver.findElement(By.className("hello")).getText();
		String expectedText = "Ola, Estou usando CDI!";
		assertThat(expectedText, CoreMatchers.containsString(text));
	}
	
	public WebDriver getDriver() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver","/home/adriano/workspace-neon-2/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

		//configura Headless mode (sem abrir browser)
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
//		driver =  new FirefoxDriver(options);

		//abrindo navegador
		driver =  new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
