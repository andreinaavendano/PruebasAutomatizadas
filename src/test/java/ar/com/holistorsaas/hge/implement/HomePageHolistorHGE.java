package ar.com.holistorsaas.hge.implement;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ar.com.holistorsaas.Base;

public class HomePageHolistorHGE {

	Base base;
	By hgeAplicacion = By.xpath("//img[@src='/assets/common/images/holistor/gestionERP-logo.png']");
	By pageHGELocator = By.xpath("//img[@src='Resources/ImgLogo.png']");

	
	
	public HomePageHolistorHGE(Base base) {
		this.base = base;
		// TODO Auto-generated constructor stub
	}
	public boolean openHGE() throws InterruptedException {
		

		String mainHandle = base.getNameActive(base.driver);
		
		System.out.println("HGE: " + base.driver.findElement(hgeAplicacion).isDisplayed());
		base.driver.findElement(hgeAplicacion).click();


		System.out.println("id " + base.switchPage(mainHandle, base.driver));

		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(pageHGELocator));
		assertTrue(base.driver.findElement(pageHGELocator).isDisplayed());

		System.out.println("titulo: " +base.driver.getTitle());
		System.out.println("URL: " +base.driver.getCurrentUrl());
		
		return base.isDisplayed(pageHGELocator);

	}

	public boolean isHGETenant() {

		if (base.driver.findElement(hgeAplicacion).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isHGEUserEnabled() {
		if (base.driver.findElement(hgeAplicacion).isEnabled())
			return true;
		else
			return false;
	}
	
	public void close() throws InterruptedException
	{
		base.close();
		
	}
	public boolean evaluaLink() {

		return base.checkinPageLinks();

	}
	
}
