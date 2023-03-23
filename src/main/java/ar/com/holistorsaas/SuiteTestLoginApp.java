package ar.com.holistorsaas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import ar.com.holistorsaas.login.funtional.LoginTest;
import ar.com.holistorsaas.pde.funtional.HomePageHolistorPDE_Test;
import ar.com.holistorsaas.syj.funtional.HomePageHolistorSYJ_Test;
import ar.com.holistorsaas.syj.funtional.ItemMenuArchivoPDocumentoTest;
import ar.com.holistorsaas.syj.funtional.SeleccionarEmpresa_Test;
import ar.com.holistorsaas.ctb.funtional.HomePageHolistorCTB_Test;
import ar.com.holistorsaas.hge.funtional.HomePageHolistorHGE_Test;

@RunWith(Suite.class)
@SuiteClasses({  LoginTest.class, 
	HomePageHolistorSYJ_Test.class,
	HomePageHolistorHGE_Test.class,
	HomePageHolistorPDE_Test.class,
	HomePageHolistorCTB_Test.class,
	SeleccionarEmpresa_Test.class,
	ItemMenuArchivoPDocumentoTest.class})
public class SuiteTestLoginApp {

}
