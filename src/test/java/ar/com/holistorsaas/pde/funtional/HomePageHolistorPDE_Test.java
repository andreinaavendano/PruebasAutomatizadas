package ar.com.holistorsaas.pde.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.pde.implement.HomePageHolistorPDE;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;

public class HomePageHolistorPDE_Test {
	
	LoginPlataforma_Page loginPage;
	HomePageHolistorPDE homePagePDE;
	Base base = new Base();
	@Before
	public void setUp() throws Exception {
		//Base base = new Base();
		loginPage = new LoginPlataforma_Page(base);
		
		loginPage.logIN();
	}
	
	@Test
	public void testlogin() throws InterruptedException {
		

		homePagePDE = new HomePageHolistorPDE(base);
		
		assertTrue(homePagePDE.isPDETenant(),"PDE no esta habiliatado para este Tenant");
		
		assertTrue(homePagePDE.isPDEUserEnabled(),"PDE no esta habiliatado para este usuario");
		
		assertTrue(homePagePDE.openPDE(),"No abrio la pagina Home PDE");
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		homePagePDE.close();
		loginPage.close();
	}


}
