package com.demoworkshop.testscripts;

import org.testng.annotations.Test;

import com.demoworkshop.genericlibrary.Base_Test;
import com.demoworkshop.pomrepository.BooksPage;
import com.demoworkshop.pomrepository.ShoppingCartPage;
import com.demoworkshop.pomrepository.WelcomePage;

public class AddToCartTest extends Base_Test {

	@Test
	public void TC_AddToCart001() {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.ClickBookLink();
		BooksPage bookspage=new BooksPage(driver);
		bookspage.clickComputingAndInternetAddtoCartButton();
		bookspage.clickBannerShoppingCartLink();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		softAssert.assertEquals(shoppingCartPage.getShoppigCartFirstRowProductName().getText(), "Computing and Internet");
	}
}
