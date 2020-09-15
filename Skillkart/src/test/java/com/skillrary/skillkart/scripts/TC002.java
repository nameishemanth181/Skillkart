package com.skillrary.skillkart.scripts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillrary.skillkart.generic.ExcelLibrary;
import com.skillrary.skillkart.generic.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.OrderDetailPage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC002 extends BaseTest
{
	
	@DataProvider
	public Object[][] getData()
	{
		return ExcelLibrary.getExcelData(XL_PATH, "TC002");
	}
	
	@Test(description="Verify Product is Deleted and is not Displayed in Order Detail Page", dataProvider="getData")
	public void testProductIsDisplayed(String tabName, String productId, String quantity, String size, String color)
	{
		productId=Utilities.doubleStringToInt(productId);
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab(tabName);
		ProductDetailPage pdp = myStorePage.selectTheProduct(productId);
		pdp.increaseQuantity(Integer.parseInt(Utilities.doubleStringToInt(quantity)));
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		OrderDetailPage odp = pdp.clickOnProceedToCheckout();
		Assert.assertEquals(odp.verifyProductIsAvailable(productId), true);
	}
}