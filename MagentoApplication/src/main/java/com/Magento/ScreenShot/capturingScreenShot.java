package com.Magento.ScreenShot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.Magento.Browser.Browser;

public class capturingScreenShot extends Browser{
	
	public static String screenShot(String name)  { 
		String path=null;
		try {
			TakesScreenshot shot = ((TakesScreenshot) driver);
			File source = shot.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + "\\target\\com.Magento.ScreenShot\\" + name + ".png";
			File destination = new File(path);
		
			source.renameTo(destination);
			
		} catch (Exception e) {
			System.out.println("Screenshot");
		}
		return path;
	}

}
