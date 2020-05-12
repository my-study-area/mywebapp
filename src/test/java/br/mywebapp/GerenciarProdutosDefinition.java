package br.mywebapp;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class GerenciarProdutosDefinition {
	WebDriver driver = null;
	static final Logger LOGGER = Logger.getLogger(StepDefinition.class.getName());

	@Before
	public void beforeScenario(){
		driver = getDriver();
	}

	@After
	public void afterScenario() {
		driver.close();
	}

	@Dado("que estou na página inicial")
	public void que_estou_na_página_inicial() {
		driver.get("http://localhost:9090/");
	}

	@Quando("clicar no link de produto")
	public void clicar_no_link_de_produto() {
		WebElement link = driver.findElement(By.linkText("Produto"));
		link.click();
	}

	@Então("eu devo ver a página de cadastro de produtos")
	public void eu_devo_ver_a_página_de_cadastro_de_produtos() {
		String expectedText = "Cadastro de Produto";
		String text = driver.findElement(By.className("title")).getText();
		Assert.assertEquals(expectedText, text );
	}

	public WebDriver getDriver() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver","/home/adriano/workspace-neon-2/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

		//abrindo navegador
		driver =  new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}

