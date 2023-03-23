package ar.com.holistorsaas.syj.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;

public class SeleccionarEmpresa_Test {

	LoginPlataforma_Page loginPage;
	HomePageHolistorSYJ homePageSYJ;
	Base base = new Base();
	@Before
	public void login() throws Exception {

		loginPage = new LoginPlataforma_Page(base);
		loginPage.logIN();
		
	}

	
	@Test 
	public void testSelectempresa() throws InterruptedException {
			
		homePageSYJ = new HomePageHolistorSYJ(base);
		assertTrue(homePageSYJ.isSYJTenant(), "SYJ no esta habiliatado para este Tenant");
		assertTrue(homePageSYJ.isSYJUserEnabled(), "SYJ no esta habiliatado para este usuario");
		assertTrue(homePageSYJ.openSYJ(), "No abrio la pagina Home SYJ");
		assertTrue(homePageSYJ.openSelectEmpresa(), "No seleccionó la empresa");


	}

	@After
	public void logout() throws Exception {
		homePageSYJ.close();
		loginPage.close();
	}


}
