package com.skillrary.skillkart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generic.TakeScreenshot;
import com.skillrary.skillkart.generic.WebActionUtil;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver, WebActionUtil webActionUtil)  
	{
		super(driver,webActionUtil);
	}
	
	//Home Page WebElements
	@FindBy(linkText="Women")
	private WebElement womenTab;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesTab;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tShirtsTab;
	
	@FindBy(partialLinkText="Sign out")
	private WebElement logoutLink;
	
	//Action Methods
	public MyStorePage clickOnTab(String tabName)
	{
		tabName=tabName.toLowerCase();
		switch (tabName) {
		case "dresses":webActionUtil.click(dressesTab);
					   break;
		case "women":webActionUtil.click(womenTab);
				     break;
		case "tshirts":webActionUtil.click(tShirtsTab);
					   break;
		}
		
		return new MyStorePage(driver, webActionUtil);
	}

	public void logout() 
	{
		webActionUtil.click(logoutLink);		
	}
	
	public boolean verifyButtonColor(String element, String colorHexaCode, String testCaseName)
	{
		if(element.contains("signOut"))
		{
			String color=logoutLink.getCssValue("color");
			String actualHex = Color.fromString(color).asHex();
			System.out.println(actualHex);
			System.out.println(colorHexaCode);
			if(actualHex.equals(colorHexaCode))
			{
				return true;
			}
			else
			{
				TakeScreenshot.takeElementScreenshot(logoutLink, testCaseName);
				throw new IllegalArgumentException();
			}
		}
		return false;
		
	}
}
