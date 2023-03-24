package ar.com.holistorsaas.adaptacion;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.holistorsaas.adaptacion.config.ManagerDriver;

public class BaseTest {
	final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

	private WebDriver driver;

	public BaseTest() {

	}

	public BaseTest(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * obtener el driver por defecto el de Chorme si no ha sido inicializado crea
	 * una instancia
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		if (driver == null) {
			driver = ManagerDriver.getChrome();
			logger.info("Carga de driver correcta");
		}
		return driver;
	}

	/**
	 * Cierre de la ventan
	 * 
	 * @throws InterruptedException
	 */
	protected void closed() throws InterruptedException {
		String maindHandle = getNameActive();
		logger.info("Actual para cerrar " + maindHandle);
		driver.close();
		switchPage(maindHandle, driver);

	}

	/**
	 * Buscar un elemento
	 * 
	 * @param locator
	 * @return
	 */
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * devuelve la lista de elementos encontrados para el locatos recibido
	 * 
	 * @param locator
	 * @return
	 */
	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * devuelve el text obtenido del elemneto encontrado
	 * 
	 * @param element
	 * @return
	 */
	protected String getText(WebElement element) {

		return element.getText();
	}

	/**
	 * devuelve el text de ese elemento que estamos buscando a traves del
	 * localizador recibido.
	 * 
	 * @param locator
	 * @return
	 */
	protected String getText(By locator) {

		return driver.findElement(locator).getText();
	}

	/**
	 * Escribir en una caja de texto recibe el localizador y el texto a introducir
	 * 
	 * @param inputText
	 * @param Locator
	 */
	protected void type(String inputText, By Locator) {
		driver.findElement(Locator).sendKeys(inputText);
	}

	/**
	 * Hacer clic en el botón o localizador enviado.
	 * 
	 * @param Locator
	 */
	protected void click(By Locator) {
		driver.findElement(Locator).click();
	}

	protected void click(WebElement element) {
		element.click();
	}

	/** 
	 * Esta mostrado el localizador devuelve true en casao de SI
	 * @param Locator
	 * @return
	 */
	protected boolean isDisplayed(By Locator) {
		try {
			return driver.findElement(Locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	/**
	 * Obtener el nombre de la pagina activa
	 * @param driver
	 * @return
	 */
	protected String getNameActive() {
		return driver.getWindowHandle();
	}
	
	/**
	 * Switch pagina activas
	 * @param main
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	protected String switchPage(String main, WebDriver driver) throws InterruptedException {
		String idHandle = "";
		while ("".equals(idHandle)) {
			Thread.sleep(500L);
			Set<String> page;
			try {
				page = driver.getWindowHandles();
			} catch (Exception e) {
				logger.error("error al switch de la pagina: ", e.getMessage());
				return "";
			}
			for (String actual : page) {
				if (!actual.equalsIgnoreCase(main)) {
					driver.switchTo().window(actual);
					idHandle = actual;
				}
			}
		}
		return idHandle;
	}

}
