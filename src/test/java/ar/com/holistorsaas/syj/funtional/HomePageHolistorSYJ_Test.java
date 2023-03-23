package ar.com.holistorsaas.syj.funtional;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import ar.com.holistorsaas.Base;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;




public class HomePageHolistorSYJ_Test {

	LoginPlataforma_Page loginPage;
	HomePageHolistorSYJ homePageSYJ;
	Base base = new Base();
	@Before
	public void setUp() throws Exception {
		//Base base = new Base();
		loginPage = new LoginPlataforma_Page(base);
		loginPage.logIN();
		
	}
	
	@Test 
	public void testLogin() throws InterruptedException {
		

		homePageSYJ = new HomePageHolistorSYJ(base);
				
		assertTrue(homePageSYJ.isSYJTenant(),"SYJ no esta habiliatado para este Tenant");
		
		assertTrue(homePageSYJ.isSYJUserEnabled(),"SYJ no esta habiliatado para este usuario");
		
		assertTrue(homePageSYJ.openSYJ(),"No abrio la pagina Home SYJ");
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		homePageSYJ.close();
		loginPage.close();
	}

	

}
