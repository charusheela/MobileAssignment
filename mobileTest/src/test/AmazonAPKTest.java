package test;

import org.testng.annotations.Test;

import commonFunctions.CapInitialise;
import commonFunctions.FileInput;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import pages.SignInPage;;

public class AmazonAPKTest extends CapInitialise {
	
	FileInput files= new FileInput();
	
	@Test
	public void testSearch_Compare() throws Exception {
		
		SignInPage signInObj = new SignInPage();
		signInObj.verifySignInPage();
		signInObj.clickSignIn();
		
		LoginPage loginObj = new LoginPage();
		loginObj.verifyLogInPage();
		loginObj.userLogIn(); //Calling login method

		HomePage homePageObj = new HomePage();
		homePageObj.verifyHomePage();
		homePageObj.EnterKeyword_SearchItem(); //Method to enter search keyword and search
		
		SearchPage searchResultObj = new SearchPage();
		searchResultObj.verifySearchResultPage();
		String expectedItemName = searchResultObj.getItemName();

		ProductPage productDetailsPage = new ProductPage();
		productDetailsPage.verifyProductDetailsPage();
		productDetailsPage.clickBuyNow();
		
		CheckoutPage checkoutObj = new CheckoutPage();
		checkoutObj.verifyCheckOutPage();
		checkoutObj.clickNetBankingRadioButton();
		checkoutObj.selectBank();
		checkoutObj.clickContinueButton();
		
		String actualItemName = checkoutObj.getItemNameText();
		checkoutObj.compareItemNames(actualItemName, expectedItemName);	//Comparing the item name from product search and checkout page
	}
}
