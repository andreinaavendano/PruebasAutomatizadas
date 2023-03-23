package ar.com.holistorsaas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;

	// Constructor de la Clase Base
	public Base() {
		this.driver = chromeDriverConnection();

	}

	// Conection con Chrome Driver si se requiere otros navegadores se agrega un
	// funcion
	// concexion para cada uno de ellos
	private WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	// Wrapper - Envoltorio de los comando de selenium esot se realiza con la
	// intención que si orcurre cambios importantes
	// en los comando se modifican aca en esta Base y no se tiene que modificar en
	// cada uno de los test.
	// devuelve el elemento encontrado
	// Visita la Pagina de la URL recibida en la función..
	public void visit(String url) {
		driver.get(url);
	}
	public void close() throws InterruptedException {
		
		String maindHandle = getNameActive(this.driver);
		System.out.println("Actual para cerrar "+ maindHandle );
		driver.close();
		switchPage(maindHandle, driver);
		
		
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	// devuelve la lista de elementos encontrados para el locatos recibido
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	// devuelve el text obtenido del elemneto encontrado
	public String getText(WebElement element) {

		return element.getText();
	}

	// devuelve el text de ese elemento que estamos buscando a traves del
	// localizador recibido.
	public String getText(By locator) {

		return driver.findElement(locator).getText();
	}

	// Escribir en una caja de texto recibe el localizador y el texto a introducir
	public void type(String inputText, By Locator) {
		driver.findElement(Locator).sendKeys(inputText);
	}

	// Hacer clic en el botón o localizador enviado.
	public void click(By Locator) {
		driver.findElement(Locator).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	// Esta mostrado el localizador devuelve true en casao de SI
	public boolean isDisplayed(By Locator) {
		try {
			return driver.findElement(Locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	public String getNameActive(WebDriver driver) {

		return driver.getWindowHandle();
	}

	public String switchPage(String main, WebDriver driver) throws InterruptedException {
		//System.out.println("MAin " + main);

		String idHandle = "";
		while ("".equals(idHandle)) {
			Thread.sleep(500L);
			Set<String> page;
			try {
				page = driver.getWindowHandles();
			} catch (Exception e) {
				return "";
			}

			for (String actual : page) {
				//System.out.println("Actual " + actual);
				if (!actual.equalsIgnoreCase(main)) {
					driver.switchTo().window(actual);
					idHandle = actual;
				}

			}
			
		}
		return idHandle;
	}

	public boolean checkinPageLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
	
		String url = "";
		
		List<String> brokenList = new ArrayList<String>();
		List<String> okList = new ArrayList<String>();

		HttpURLConnection httpConnection = null;
		int responseCode = 200;
		Iterator<WebElement> it = links.iterator();

		System.out.println("Cantidad de Elementos de tipo link " + links.size());

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			//textlink = it.getAttribute("innerHTML");
			
			//System.out.println("URL: --" + url+" linktext: "+ textlink);
			if (url == null || url.isEmpty()) {
				//System.out.println(url + "URL is not configured or it is empty ");
				continue;
			}
			try {
				httpConnection = (HttpURLConnection) (new URL(url).openConnection());
				httpConnection.setRequestMethod("HEAD");
				httpConnection.connect();
				responseCode = httpConnection.getResponseCode();

				if (responseCode > 400) {
					//System.out.println("ERROR BROKEN LINK: --" + url+" linktext: "+ textlink);
					brokenList.add(url);
				} else {
					//System.out.println("VALID LINK: --" + url +" linktext: "+ textlink);
					okList.add(url);

				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		}

		System.out.println("Valid Links" + okList.size());
		System.out.println("Invalid Links" + brokenList.size());

		if (brokenList.size() > 0) {
			System.out.println("******ERROR ----------BROKEN LINKS");
			for (int i = 0; i < brokenList.size(); i++) {
				System.out.println(brokenList.get(i));

			}
			return false;
		} else {
			System.out.println("******NO HAY LINKS ROTOS *********");
			return true;

		}


	}
	
	
}
