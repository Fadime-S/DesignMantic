package Tests;
import java.util.Properties;
	import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
import org.testng.internal.InvokeMethodRunnable.TestNGRuntimeException;

import BasePage.BasePage;
	import Pages.CompanyPage3;
	import Pages.DesignMaticLoginPage2;
	import Pages.DesignMaticMainPage1;
import net.bytebuddy.asm.Advice.Return;
	
	public class CompanyPageTest3 {
		
		WebDriver driver;
		Properties prop;
		BasePage basePage;
		DesignMaticMainPage1 designmatic;
		DesignMaticLoginPage2 designmaticlogo;
		CompanyPage3 company;
		
		@BeforeMethod
		public void setUp(){
			basePage = new BasePage();
			prop = basePage.initialize_properties();
			driver = basePage.initialize_driver(prop);
			designmatic=new DesignMaticMainPage1(driver);
			designmatic.clickOnlogin();
			designmaticlogo=new DesignMaticLoginPage2(driver);
			designmaticlogo.logoDesign();	
			company=new CompanyPage3(driver);
			
		}
		
		@Test(priority=1)
		public void companyAndIndustry(){
			company.companyName();
			company.selectYourIndustry();
		}
		
//		@Test(priority=2)
//		public void selectedText(){
//		    boolean text = company.elementSelected();
//			System.out.println("Selected industry is: "+ text);
//		}
		
		
		
		@Test(priority=2)
		public void getSelectedText(){
			String text= company.getText();
			text = text.trim();
			System.out.println("Selected Industry is: "+ text);
			String expected = "Cleaning";                                                          
			Assert.assertEquals(text, expected);

	}
		
		@AfterMethod
		public void tearDown(){
			basePage.closeBrowser();
		}					
}