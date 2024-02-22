package com.demoworkshop.testscripts;
import org.testng.annotations.Test;

import com.demoworkshop.genericlibrary.Base_Test;
import com.demoworkshop.pomrepository.RegisterPage;
import com.demoworkshop.pomrepository.UserHomePage;
import com.demoworkshop.pomrepository.WelcomePage;

public class RegisterTest extends Base_Test{

	@Test
	public void TC_Register_001() {
	WelcomePage welcomePage = new WelcomePage(driver);
	welcomePage.registerClick();
	RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register("f", "Suma", "Y", "Hiii@hahahehe.com", "Password@123", "Password@123");
	
	UserHomePage homePage = new UserHomePage(driver);
	softAssert.assertEquals("Hiii@hahahehe.com", homePage.loggedInEmailID());
	}
}
