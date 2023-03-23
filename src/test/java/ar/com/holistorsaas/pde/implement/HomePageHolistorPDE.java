package ar.com.holistorsaas.pde.implement;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ar.com.holistorsaas.Base;

public class HomePageHolistorPDE {

	Base base;
	By pdeAplicacion = By.xpath("//img[@src='/assets/common/images/holistor/planificacion-estudios-logo.png']");
	By pagePDELocator = By.xpath("//img[@src='Resources/ImgLogoAGEv3_CHI_MasterPage.png']");
	
	
	
	public HomePageHolistorPDE(Base base) {
		this.base = base;
		// TODO Auto-generated constructor stub
	}
	public boolean openPDE() throws InterruptedException {
		

		String mainHandle = base.getNameActive(base.driver);

		System.out.println("PDE: " + base.driver.findElement(pdeAplicacion).isDisplayed());
		base.driver.findElement(pdeAplicacion).click();
		

		System.out.println("id " + base.switchPage(mainHandle, base.driver));

		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(pagePDELocator));
		assertTrue(base.driver.findElement(pagePDELocator).isDisplayed());
	
		System.out.println("titulo: " +base.driver.getTitle());
		System.out.println("URL: " +base.driver.getCurrentUrl());
		
		return base.isDisplayed(pagePDELocator);

	}

	public boolean isPDETenant() {

		if (base.driver.findElement(pdeAplicacion).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isPDEUserEnabled() {
		
		if (base.driver.findElement(pdeAplicacion).getAttribute("class").equalsIgnoreCase( "disabled"))
			return false;
		else
			return true;
	}
	
	public void close() throws InterruptedException
	{
		base.close();
		
	}
	public boolean evaluaLink() {

		return base.checkinPageLinks();

	}
	
	
}
