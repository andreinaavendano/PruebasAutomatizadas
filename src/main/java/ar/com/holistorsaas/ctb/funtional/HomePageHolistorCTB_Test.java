package ar.com.holistorsaas.ctb.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.ctb.implement.HomePageHolistorCTB;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;

public class HomePageHolistorCTB_Test {

	LoginPlataforma_Page loginPage;
	HomePageHolistorCTB homePageCTB;
	Base base = new Base();
	
	@Before
	public void setUp() throws Exception {
		//Base base = new Base();
		
		loginPage = new LoginPlataforma_Page(base);
		loginPage.logIN();
		
	}
	
	@Test
	public void testlogin() throws InterruptedException {
		

		homePageCTB = new HomePageHolistorCTB(base);
		
		assertTrue(homePageCTB.isCTBTenant(),"CTB no esta habiliatado para este Tenant");
		
		assertTrue(homePageCTB.isCTBUserEnabled(),"CTB no esta habiliatado para este usuario");
		
		assertTrue(homePageCTB.openCTB(),"No abrio la pagina Home CTB");
	}

	@After
	public void tearDown() throws Exception {
		homePageCTB.close();
		loginPage.close();
	}


}
