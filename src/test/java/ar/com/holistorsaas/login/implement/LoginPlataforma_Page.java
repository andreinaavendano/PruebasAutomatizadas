package ar.com.holistorsaas.login.implement;

import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ar.com.holistorsaas.Base;

public class LoginPlataforma_Page {
	Base base;

//	WebDriver driver;
	// input
	By TenantBoxLocator = By.xpath("//*[@id=\"kt_login\"]/div/div[2]/div[2]/ng-component/div/form/div[1]/input");
	By usernameBoxLocator = By.name("userNameOrEmailAddress");
	By passwordBoxLocator = By.name("password");
	By loginBtnLocator = By.xpath("//*[@id=\"kt_login\"]/div/div[2]/div[2]/ng-component/div/form/div[5]/div[2]/button");

	// Localizador que indica que la pagina login cargo
	By pageLoginLocator = By.xpath("//*[@id=\"kt_header\"]/topbar/div/div[3]/div/div/span/span");

	// Localizador de los links
	By OlvidoPass = By.linkText("Olvidó la contraseña?");
	By OlvidoTenant = By.linkText("Olvidó su espacio de trabajo?");

	 By syjAplicacion = By.xpath("//img[@src='/assets/common/images/holistor/SYJ-logo.png']");
	

	public LoginPlataforma_Page(Base base) {
		this.base = base;
		// TODO Auto-generated constructor stub
	}
	// Metodo para ingresar en la Pagina

	public boolean openPageLogin() {
		base.driver.manage().window().maximize();
		base.driver.get("https://plataforma-saas-qa.azurewebsites.net/account/login");
		WebDriverWait wait = new WebDriverWait(base.driver, Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.presenceOfElementLocated(TenantBoxLocator));

		return base.isDisplayed(TenantBoxLocator);

	}

	public boolean isTenantDisplay() {
		return base.isDisplayed(TenantBoxLocator);

	}
	public boolean isUsernameDisplay() {
		return base.isDisplayed(usernameBoxLocator);

	}
	public boolean isPassDisplay() {
		return base.isDisplayed(passwordBoxLocator);

	}
	public boolean isOlvidoPassDisplay() {
		return base.isDisplayed(OlvidoPass);

	}

	public boolean isOlvidoTenantDisplay() {
		return base.isDisplayed(OlvidoTenant);

	}

	public boolean evaluaLink() {

		return base.checkinPageLinks();

	}
	
	/*
	 * public boolean checkinPageLinks() {
	 * 
	 * List<WebElement> links = base.driver.findElements(By.tagName("a")); String
	 * url = ""; List<String> brokenList = new ArrayList<String>(); List<String>
	 * okList = new ArrayList<String>();
	 * 
	 * HttpURLConnection httpConnection = null; int responseCode = 200;
	 * Iterator<WebElement> it = links.iterator();
	 * 
	 * System.out.println("Cantidad de Elementos de tipo link " + links.size());
	 * 
	 * while (it.hasNext()) { url = it.next().getAttribute("href"); if (url == null
	 * || url.isEmpty()) { System.out.println(url +
	 * "URL is not configured or it is empty "); continue; } try { httpConnection =
	 * (HttpURLConnection) (new URL(url).openConnection());
	 * httpConnection.setRequestMethod("HEAD"); httpConnection.connect();
	 * responseCode = httpConnection.getResponseCode();
	 * 
	 * if (responseCode > 400) { System.out.println("ERROR BROKEN LINK: --" + url);
	 * brokenList.add(url); } else { System.out.println("VALID LINK: --" + url);
	 * okList.add(url);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); // TODO: handle exception }
	 * 
	 * }
	 * 
	 * System.out.println("Valid Links" + okList.size());
	 * System.out.println("Invalid Links" + brokenList.size());
	 * 
	 * if (brokenList.size() > 0) {
	 * System.out.println("******ERROR ----------BROKEN LINKS"); for (int i = 0; i <
	 * brokenList.size(); i++) { System.out.println(brokenList.get(i));
	 * 
	 * } return false; } else {
	 * System.out.println("******NO HAY LINKS ROTOS *********"); return true;
	 * 
	 * }
	 * 
	 * }
	 */

	public boolean login()  {

		String tenant = "Agenda22022022";
		String username = "Andreina";
		String pass = "123qwe";
		
		// Limpiamos los campos Tenant, username, pass
		
		base.type("", TenantBoxLocator);
		base.type("", usernameBoxLocator);
		base.type("", passwordBoxLocator);

		// Ingresamos los datos de Prueba para el Login en Plataforma
		base.type(tenant, TenantBoxLocator);
		base.type(username, usernameBoxLocator);
		base.type(pass, passwordBoxLocator);
		// Hacemos Clic en Iniciar Sesion 		
		base.click(loginBtnLocator);
		
		// Esperamos hasta que se cargue la pagina
		
		WebDriverWait wait = new WebDriverWait(base.driver, Duration.ofSeconds(30L));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(syjAplicacion));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean isHomePageDisplay(){
		return base.isDisplayed(syjAplicacion) ;
		
	}

	public boolean logIN() {
		return openPageLogin() && login();
		
	}
	
	public void close() throws InterruptedException
	{
		base.close();
		
	}

}
