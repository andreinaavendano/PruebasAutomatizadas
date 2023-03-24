package ar.com.holistorsaas.adaptacion.login.jmeter;

import org.apache.jmeter.assertions.AssertionResult;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.openqa.selenium.WebDriver;

import ar.com.holistorsaas.adaptacion.config.ManagerDriver;
import ar.com.holistorsaas.login.implement.LoginPlataforma_Page;
import ar.com.holistorsaas.syj.implement.HomePageHolistorSYJ;

public class LoginJmeter extends AbstractJavaSamplerClient {

	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		// carga las variables que se envian desde jmeter
		JMeterVariables vars = JMeterContextService.getContext().getVariables();
		String tenant = vars.get("tenant");
		String username = vars.get("username");
		String pass = vars.get("pass");
		
		WebDriver driver = ManagerDriver.getChrome();
		
		LoginPlataforma_Page login = new LoginPlataforma_Page(driver);
		//HomePageHolistorSYJ syj = new HomePageHolistorSYJ(driver);
		
		SampleResult sampleResult = new SampleResult();
		
		boolean statusLogin = login.openPageLogin() && login.login(tenant, username, pass);
		
		
		AssertionResult assertLogin = new AssertionResult("Validacion del login");
		assertLogin.setFailure(statusLogin);
		assertLogin.setFailureMessage("No levanta login");
		sampleResult.addAssertionResult(assertLogin);
		
		
		return sampleResult;
	}
	
	

}
