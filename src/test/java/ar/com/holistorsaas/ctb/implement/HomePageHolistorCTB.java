package ar.com.holistorsaas.ctb.implement;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ar.com.holistorsaas.Base;

public class HomePageHolistorCTB {

	Base base;
	By ctbAplicacion = By.xpath("//img[@src='/assets/common/images/holistor/ctb-web.png']");
	By pageCTBLocator = By.xpath("//img[@src='Resources/ImgLogoCTB_GRA_Home.png']");

	public HomePageHolistorCTB(Base base) {
		this.base = base;
		// TODO Auto-generated constructor stub
	}

	public boolean openCTB() throws InterruptedException {

		String mainHandle = base.getNameActive(base.driver);
		
		System.out.println("CTB: " + base.driver.findElement(ctbAplicacion).isDisplayed());
		base.driver.findElement(ctbAplicacion).click();
		
		System.out.println("id " + base.switchPage(mainHandle, base.driver));
		
		WebDriverWait wait2 = new WebDriverWait(base.driver, Duration.ofSeconds(10L));
		wait2.until(ExpectedConditions.presenceOfElementLocated(pageCTBLocator));
		assertTrue(base.driver.findElement(pageCTBLocator).isDisplayed());

		System.out.println("titulo: " +base.driver.getTitle());
		System.out.println("URL: " +base.driver.getCurrentUrl());
		
		return base.isDisplayed(pageCTBLocator);

	}

	public boolean isCTBTenant() {

		if (base.driver.findElement(ctbAplicacion).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isCTBUserEnabled() {

		if (base.driver.findElement(ctbAplicacion).getAttribute("class").equalsIgnoreCase("disabled"))
			return false;
		else
			return true;
	}

	public void close() throws InterruptedException {

		base.close();

	}

	public boolean evaluaLink() {

		return base.checkinPageLinks();

	}

}
