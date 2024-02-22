package com.demoworkshop.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends Base_Page {

	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text()='Compuing and Internet']/parent::h2/..//input")
	private WebElement computingandInternetAddtoCartButton;
	
	public void clickComputingAndInternetAddtoCartButton() {
		computingandInternetAddtoCartButton.click();
	}
	
	@FindBy(xpath = "//a[text()='shoppin cart']")
	private WebElement shoppingCartLinkAfterAddingProducttoCart;
	
	public void clickBannerShoppingCartLink() {
		shoppingCartLinkAfterAddingProducttoCart.click();
	}
}
