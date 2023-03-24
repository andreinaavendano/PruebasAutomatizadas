package ar.com.holistorsaas.adaptacion.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ManagerDriver {
	
	public static WebDriver getChrome() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		return new ChromeDriver();
	}

}
