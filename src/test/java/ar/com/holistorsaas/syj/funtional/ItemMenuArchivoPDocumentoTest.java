package ar.com.holistorsaas.syj.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;

public class ItemMenuArchivoPDocumentoTest {

	
	LoginPlataforma_Page loginPage;
	HomePageHolistorSYJ homePageSYJ;
	Base base = new Base();
	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPlataforma_Page(base);
		loginPage.logIN();
		homePageSYJ = new HomePageHolistorSYJ(base);
		
	}


	@Test 
	public void ABMDocumento() throws InterruptedException {
		
		assertTrue(homePageSYJ.isSYJTenant(),"SYJ no esta habiliatado para este Tenant");
		assertTrue(homePageSYJ.isSYJUserEnabled(),"SYJ no esta habiliatado para este usuario");		
		assertTrue(homePageSYJ.openSYJ(),"No abrio la pagina Home SYJ");		
		assertTrue(homePageSYJ.selectedItemMenuDocumento(),"Menu No encontrado");
		assertTrue(homePageSYJ.AddDocumento(),"No se pudo agregar el nuevo regitro");
		//assertTrue(homePageSYJ.buscarDocumento(),"No se pudo encontrar el regitro");
		homePageSYJ.buscarDocumento();
		assertTrue(homePageSYJ.ModDocumento(),"No se pudo modificar el regitro");
		homePageSYJ.buscarDocumento();
		assertTrue(homePageSYJ.delDocumento(),"No se pudo eliminar el regitro");
		
}
	@After
	public void tearDown() throws Exception {
		homePageSYJ.close();
		loginPage.close();
	}

}
