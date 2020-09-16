package com.skillrary.skillkart.scripts;

import org.testng.annotations.Test;

import com.skillrary.skillkart.pages.HomePage;

public class TC005 extends BaseTest
{
	@Test(description="Verify if the color of SigOut button is proper")
	public void testSignInColor2()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.verifyButtonColor("signOut","#FFFF","testSignInColor");
	}
}
