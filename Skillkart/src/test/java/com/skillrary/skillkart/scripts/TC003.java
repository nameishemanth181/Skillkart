package com.skillrary.skillkart.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillrary.skillkart.generic.ExcelLibrary;
import com.skillrary.skillkart.generic.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC003 extends BaseTest
{
	@DataProvider
	public Object[][] getData()
	{
		return ExcelLibrary.getExcelData(XL_PATH, "TC003");
	}
	
	@Test(dataProvider="getData", description="Verify whether the same page is disaplyed if the add To Kart is Cancelled")
	public void testCancelAddToKart(String tabName, String productId, String quantity, String size, String color)
	{
		productId=Utilities.doubleStringToInt(productId);
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab(tabName);
		ProductDetailPage pdp = myStorePage.selectTheProduct(productId);
		pdp.increaseQuantity(Integer.parseInt(Utilities.doubleStringToInt(quantity)));
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		pdp.closePopup();
		Assert.assertEquals(pdp.verfiyProductDetailPageTitle(),false);
	}
}
