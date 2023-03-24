package ar.com.holistorsaas.login;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.adaptacion.config.ManagerDriver;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;

public class LoginTest {
	// private WebDriver driver;
		LoginPlataforma_Page loginPage;
		By TenantBoxLocator = By.xpath("//*[@id=\"kt_login\"]/div/div[2]/div[2]/ng-component/div/form/div[1]/input");

		@Before
		public void setUp() throws Exception {
			WebDriver driver = ManagerDriver.getChrome();
			// driver = loginPage.chromeDriverConnection();
			loginPage = new LoginPlataforma_Page(driver);

		}

		@Test
		public void test_login() throws InterruptedException {

			// verifica qeu se cargue la pagina incial
			assertTrue(loginPage.openPageLogin(), "Pagina no se visualiza");

			// verifica que se muestre los input de las campos
			assertTrue(loginPage.isTenantDisplay(), "El input Tenant no se muestra");

			// verifica que se muestre los input de las campos
			assertTrue(loginPage.isUsernameDisplay(), "El input UserName no se muestra");

			// verifica que se muestre los input de las campos
			assertTrue(loginPage.isPassDisplay(), "El input pass no se muestra");
			
			// Verificar que la pagina de Login tiene el link Olvido su password
			assertTrue(loginPage.isOlvidoPassDisplay(), "El link olvido su pass no se muestra");
			
			// Verificar que la pagina de Login tiene el link Olvido su tenant
			assertTrue(loginPage.isOlvidoTenantDisplay(), "El link olvido su Tenant no se muestra");
			
			// Verificar que la pagina de Login no tiene links rotos
			assertTrue(loginPage.evaluaLink(),"Tiene links rotos");

			// Ingresar los datos para el proceso de loguearse
			assertTrue(loginPage.login(),"Fallo el login");
			
			// Verificar que carga la pagina DashBoard
			assertTrue(loginPage.isHomePageDisplay(), "No se carga la pagina de inicio");

			
		}

		@After
		public void tearDown() throws Exception {
			loginPage.close();
		}

}
