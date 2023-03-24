package ar.com.holistorsaas.syj.implement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Iterator;
import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.adaptacion.BaseTest;
import net.bytebuddy.asm.Advice.Return;

public class HomePageHolistorSYJ extends BaseTest {
	//Base base;
	
	By syjAplicacion = By.xpath("//img[@src='/assets/common/images/holistor/SYJ-logo.png']");	
	

	public HomePageHolistorSYJ(WebDriver base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	public boolean openSYJ() throws InterruptedException {
		
		
		By pageSYJLocator = By.xpath("//img[@src='Resources/ImgLogoSyJ_GRA_Home.png']");
		
		String mainHandle = this.getNameActive();

		System.out.println("SYJ: " + this.findElement(syjAplicacion).isDisplayed());
		this.findElement(syjAplicacion).click();
		
	
		System.out.println("id " + base.switchPage(mainHandle, base.driver));

		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(pageSYJLocator));

		assertTrue(base.driver.findElement(pageSYJLocator).isDisplayed());
		
		System.out.println("titulo: " +base.driver.getTitle());
		System.out.println("URL: " +base.driver.getCurrentUrl());
		
		return base.isDisplayed(pageSYJLocator);

	}

	public boolean isSYJTenant() {

		if (base.driver.findElement(syjAplicacion).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isSYJUserEnabled() {
		if (base.driver.findElement(syjAplicacion).isEnabled())
			return true;
		else
			return false;
	}
	
	public void close() throws InterruptedException
	{
		base.close();
		
	}
	
	public boolean evaluaLink() {
		
		return  base.checkinPageLinks();
		
	}
	public boolean openSelectEmpresa() throws InterruptedException {
		
		By lupaSelecEmpresa = By.xpath("//img[@id=\"IMAGE1_MPAGE\"]");
		By row1SelecEmpresa = By.xpath("//img[@id='vACTION_ACTION_0001']");
		By muestraEmpresaSeleccionada = By.xpath("//span[@id='EMPRESA_MPAGE' ]");
		
		Actions actions = new Actions(base.driver);
		//hacer clic en la lupa para seleccionar empresa
		actions.moveToElement(base.driver.findElement(lupaSelecEmpresa))
		.click()
		.pause(3000L)
		.build().perform();
		
		//seelcciona el frame
		 base.driver.switchTo().frame(0);		 
		//hacer clic en el icono verde para seleccionar la primera empresa 
		 actions.moveToElement(base.driver.findElement(row1SelecEmpresa))
			.click()
			.pause(2000l)
			.build().perform();
		 
		 //Seleccionar la pagina 
		 base.driver.switchTo().defaultContent();
		 
		 //retorna true si tiene un texto
		 return !base.driver.findElement(muestraEmpresaSeleccionada).getText().equals("");
		 /*
		.pause(2L)
		.moveToElement(base.driver.findElement(row1SelecEmpresa))
		.click().pause(10l)

		
		
		
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		
		if(base.driver.findElement(lupaSelecEmpresa).isDisplayed()) {
			base.driver.findElement(lupaSelecEmpresa).click();
			
		
			wait2.until(ExpectedConditions.presenceOfElementLocated(popUpSelecEmpresa));
			
			System.out.println("se muestra "+base.driver.findElement(popUpSelecEmpresa).isDisplayed());
			System.out.println("se muestra "+base.driver.findElement(popUpSelecEmpresa).getText());
			
			if (base.driver.findElement(popUpSelecEmpresa).isDisplayed()) {
				System.out.println("popUpSeleccionar Empresa: " +base.driver.findElement(popUpSelecEmpresa).isDisplayed() );
				
				//System.out.println("sssssa: " +base.driver.findElement(row1SelecEmpresa).getText());
				
				Actions actions = new Actions(base.driver);
				actions.moveToElement(base.driver.findElement(row1SelecEmpresa)).build().perform();
				
				wait2.until(ExpectedConditions.presenceOfElementLocated(ImagenSeleccionar));
				
				codigoEmpresa =base.driver.findElement(row1SelecEmpresa).getText();
				System.out.println("Codigo Empresa: " +codigoEmpresa );
				
				base.driver.findElement(row1SelecEmpresa).click();
				wait2.until(ExpectedConditions.presenceOfElementLocated(muestraEmpresaSeleccionada));
				String t =base.driver.findElement(muestraEmpresaSeleccionada).getText();
				System.out.println("EmpresaSeleccionada " +t );
				return true;
			}
			return false;
		}*/
		
		
	}
	
	public boolean selectedItemMenuDocumento() {
			
		By btnMenuPpal = By.id("BTNTOGGLEMENU_MPAGE");
		By btnArchivo = By.cssSelector("#K2baccordionmenu1 > li:nth-child(1) > a > .sidebar-nav-item");
		By btnPersonales = By.cssSelector(".mm-show > li:nth-child(1) > a > .sidebar-nav-item");
		By btnDocumento = By.cssSelector(".mm-collapse > .mm-active li:nth-child(1) .sidebar-nav-item");
		
		By tituloDocumento = By.xpath("//span[@id='PGMDESCRIPTORTEXTBLOCK']");
		String url = "https://syj-app-qa.azurewebsites.net/wwdocumento.aspx";
		Actions actions = new Actions(base.driver);
		
		//hacer clic en la lupa para seleccionar empresa
		actions.moveToElement(base.driver.findElement(btnMenuPpal))
		.click()
		.pause(500L)
		.build().perform();
		
		actions.moveToElement(base.driver.findElement(btnArchivo))
		.click()
		.pause(500L)
		.build().perform();
		
		actions.moveToElement(base.driver.findElement(btnPersonales))
		.click()
		.pause(500L)
		.build().perform();
		
		actions.moveToElement(base.driver.findElement(btnDocumento))
		.click()
		.pause(500L)
		.build().perform();
		
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(tituloDocumento));

		//base.driver.findElement(tituloDocumento).getText().equals("Documentos")
		//retorna true si tiene la url del objeto documento
		return base.driver.getCurrentUrl().equals(url);
		
	}
	
	public boolean AddDocumento() {
	
		By btnAdd = By.xpath("//input[@id='INSERT']");
		By inputCodigo = By.xpath("//input[@id='W0041W0029DOCUMENTO_CODIGO']");
		By inputDescripcion = By.xpath("//input[@id='W0041W0029DOCUMENTO_DESCRIPCION']");
		By inputAceptar = By.xpath("//input[@id='W0041W0029ENTER']");
		String url = "https://syj-app-qa.azurewebsites.net/wwdocumento.aspx";
		
		//Actions actions = new Actions(base.driver);
		
		//datos validos a ingresar
		String codigo = "TST";
		String descripcion = "TSTCRUD";
				
		
		//hacer clic en el boton Agregar
		/*actions.moveToElement(base.driver.findElement(btnAdd))
		.click()
		.pause(1000L)
		.build().perform();*/
		base.driver.findElement(btnAdd).click();		
		//Espera hasta que se muestre la pagina Insertar
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(50L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(inputCodigo));

		

		// Ingresamos los datos de Prueba para agregar el nuevo registro
		base.type(codigo, inputCodigo);
		base.type(descripcion, inputDescripcion);
		
		base.driver.findElement(inputAceptar).click();		
		/*actions.moveToElement(base.driver.findElement(inputAceptar))
		.click()
		.pause(1000L)
		.build().perform();*/
		
		//Espera hasta que regrese de la pagina Insertar
		wait2.until(ExpectedConditions.presenceOfElementLocated(btnAdd));
			
		return base.driver.getCurrentUrl().equals(url) ;

	}
	public void buscarDocumento() throws InterruptedException {
		
		By inputBuscar =By.id("vK2BTOOLSGENERICSEARCHFIELD");
		//By btnmodificar = By.xpath("//img[@id='vUPDATE_0001']");
		String codigo = "TST";
		//String text = "";
		
		//base.driver.findElement(inputBuscar).click();	
		base.type(codigo, inputBuscar);
		Thread.sleep(1000l);
		
		/*WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(30L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(btnmodificar));
		*/
		
		/*Actions actions = new Actions(base.driver);
		actions.moveToElement(base.driver.findElement(btnmodificar))
		.click()
		.pause(1000L)
		.build().perform();
		if(base.driver.findElement(btnmodificar).isDisplayed())
			return true;
		else 
			return false;*/
	}
	public boolean ModDocumento() {
		
		//By inputCodigo = By.xpath("//input[@id='W0041W0029DOCUMENTO_CODIGO']");
		By modificar = By.xpath("//img[@id='vUPDATE_0001']");
		By inputDescripcion = By.id("W0067DOCUMENTO_DESCRIPCION");
		By inputAceptar = By.name("W0067ENTER");
		By btnAdd = By.xpath("//input[@id='INSERT']");
		
		
		String url = "https://syj-app-qa.azurewebsites.net/wwdocumento.aspx";
		String descripcion = "TSTCRUD2";
			
		
		Actions actions = new Actions(base.driver);
					
		actions.moveToElement(base.driver.findElement(modificar))
		.click()
		.pause(1000L)
		.build().perform();
		
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(30L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(inputDescripcion));
		
		base.type(" ", inputDescripcion);
		base.type(descripcion, inputDescripcion);
		
		base.driver.findElement(inputAceptar).click();	
		
		wait2.until(ExpectedConditions.presenceOfElementLocated(btnAdd));
	
		return base.driver.getCurrentUrl().equals(url) ;
		
	}
	
	public boolean delDocumento() {
		
		//By inputCodigo = By.xpath("//input[@id='W0041W0029DOCUMENTO_CODIGO']");
		By btnEliminar = By.xpath("//img[@id='vDELETE_0001']");
		
		By inputAceptar = By.name("W0067ENTER");
		By btnAdd = By.xpath("//input[@id='INSERT']");
		
		
		String url = "https://syj-app-qa.azurewebsites.net/wwdocumento.aspx";
			
		
		Actions actions = new Actions(base.driver);
					
		actions.moveToElement(base.driver.findElement(btnEliminar))
		.click()
		.pause(1000L)
		.build().perform();
		
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(30L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(inputAceptar));
		
	
		base.driver.findElement(inputAceptar).click();	
		
		wait2.until(ExpectedConditions.presenceOfElementLocated(btnAdd));
	
		return base.driver.getCurrentUrl().equals(url) ;
		
	}
	
	
}


