package ar.com.holistorsaas.hge.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.ctb.implement.HomePageHolistorCTB;
import ar.com.holistorsaas.hge.implement.HomePageHolistorHGE;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;

public class HomePageHolistorHGE_Test {

	LoginPlataforma_Page loginPage;
	HomePageHolistorHGE homePageHGE;
	Base base = new Base();
	@Before
	public void setUp() throws Exception {
		//Base base = new Base();
		loginPage = new LoginPlataforma_Page(base);
		
		loginPage.logIN();
		System.out.println("Logueado" + loginPage.isHomePageDisplay());
	}
	
	@Test
	public void testlogin() throws InterruptedException {
		
		homePageHGE = new HomePageHolistorHGE(base);
		
		assertTrue(homePageHGE.isHGETenant(),"HGE no esta habiliatado para este Tenant");
		
		assertTrue(homePageHGE.isHGEUserEnabled(),"HGE no esta habiliatado para este usuario");
		
		assertTrue(homePageHGE.openHGE(),"No abrio la pagina Home HGE");
		
	}

	@After
	public void tearDown() throws Exception {
		homePageHGE.close();
		loginPage.close();
	}




}
