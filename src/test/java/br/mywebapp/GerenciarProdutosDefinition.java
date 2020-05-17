package br.mywebapp;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.mywebapp.model.Produto;
import io.cucumber.core.backend.StepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class GerenciarProdutosDefinition {
	WebDriver driver = null;
	static final Logger LOGGER = Logger.getLogger(StepDefinition.class.getName());
	private Produto produto = new Produto();

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

	@Quando("preencher o campo descrição com {string}")
	public void preencher_o_campo_descrição_com(String text) {
		WebElement descricao = driver.findElement(By.id("formProduto:descricao"));
		produto.setDescricao(text);
		descricao.sendKeys(produto.getDescricao());
	}

	@Quando("prencher o campo quantidade com {string}")
	public void prencher_o_campo_quantidade_com(String qtd) {
		WebElement quantidade = driver.findElement(By.id("formProduto:quantidade"));
		produto.setQtd(Integer.valueOf(qtd));
		quantidade.sendKeys(produto.getQtd().toString());
	}

	@Quando("preencher o campo valor com {string}")
	public void preencher_o_campo_valor_com(String val) {
		WebElement valor = driver.findElement(By.id("formProduto:valor"));
		produto.setValor(Double.valueOf(val));
		valor.sendKeys(produto.getValor().toString());
	}

	@Quando("selecionar a categoria {string}")
	public void selecionar_a_categoria(String categoria) {
		 WebElement selectElement =  driver.findElement(By.id("formProduto:categoria"));
		 Select selectObject = new Select(selectElement);
		 selectObject.selectByVisibleText(categoria);

	}

	@Quando("clicar no botão salvar")
	public void clicar_no_botão_salvar() {
		WebElement botao = driver.findElement(By.cssSelector("input[type=submit]"));
		botao.click();
	}

	@Então("eu devo ver a mensagem {string}")
	public void eu_devo_ver_a_mesagem(String expectedMessage) {
		String message = driver.findElement(By.cssSelector("#formProduto ul > li")).getText();
		Assert.assertEquals(expectedMessage, message);
	}

	@Então("devo ver as informações na lista de produtos")
	public void devo_ver_as_informacoes_na_lista_de_produtos() {
		Assert.assertTrue(driver.getPageSource().contains(produto.getDescricao()));
		Assert.assertTrue(driver.getPageSource().contains(produto.getQtd().toString()));
		Assert.assertTrue(driver.getPageSource().contains(produto.getValor().toString()));
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
