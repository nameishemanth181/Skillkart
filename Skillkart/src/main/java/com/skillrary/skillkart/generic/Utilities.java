package com.skillrary.skillkart.generic;
public class Utilities 
{
	public static void sleepInSeconds(long seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String doubleStringToInt(String p)
	{
		return p.substring(0,1);
	}
}
