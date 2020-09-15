package com.skillrary.skillkart.scripts;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.skillrary.skillkart.generic.ExcelLibrary;
import com.skillrary.skillkart.generic.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.OrderDetailPage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC001 extends BaseTest
{
	@Test(description="Verify Whether Product Added to Kart is Displayed in Order Detail Page")
	public void testProductIsDisplayed()
	{
		String sheetName="TC001";
		
		String tabName = ExcelLibrary.getExcelData(XL_PATH, sheetName, 1, 0);
		
		String productId = ExcelLibrary.getExcelData(XL_PATH, sheetName, 1, 1);
		productId=Utilities.doubleStringToInt(productId);
		
		String quantity = ExcelLibrary.getExcelData(XL_PATH, sheetName, 1, 2);
		quantity=Utilities.doubleStringToInt(quantity);
		
		String size = ExcelLibrary.getExcelData(XL_PATH, sheetName, 1, 3);
		String color = ExcelLibrary.getExcelData(XL_PATH, sheetName, 1, 4);
		
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab(tabName);
		ProductDetailPage pdp = myStorePage.selectTheProduct(productId);
		pdp.increaseQuantity(Integer.parseInt(quantity));
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		OrderDetailPage odp = pdp.clickOnProceedToCheckout();
		Assert.assertEquals(odp.verifyProductIsAvailable(productId), true);
	}
}
