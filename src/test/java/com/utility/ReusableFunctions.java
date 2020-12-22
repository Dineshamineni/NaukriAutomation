package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.MainClass;


public class ReusableFunctions extends MainClass {




	public static void Explicit_Wait_Until_Element_Tobe_Clickable(By locat){
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(locat)).click();

	}
	public static void Action_Method_Mouse_Hover(By loc){
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(loc));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(loc)).build().perform();;		
	}
	public static void Scrollby(int y){
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")");
	
	}
	public static void robo_home(){
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_HOME);
			r.keyRelease(KeyEvent.VK_HOME);
			r.keyRelease(KeyEvent.VK_CONTROL);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	public static void ScreenShot(){
		Date d = new Date();
	    SimpleDateFormat dformat = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    String date = dformat.format(d);
	    System.out.println("Screenshot Name: capture"+date);
		String filePath = "C:\\Users\\home\\workspace\\naukriautomation\\screenshot\\capture"+date+".png";
		TakesScreenshot ts =((TakesScreenshot)driver);
	File srcFile=	ts.getScreenshotAs(OutputType.FILE);
    File DestFile=new File(filePath);
    try {
		FileUtils.copyFile(srcFile, DestFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public static By getlocatorbyreplace(String locatorkey,String datatoreplace){
		File f = new File("C:\\Users\\home\\workspace\\naukriautomation\\src\\test\\java\\com\\utility\\objectrepository.properties");
	try {
			FileInputStream fis  = new FileInputStream(f);
			
			Properties p = new Properties();
			
				p.load(fis);
	
			String[] s = p.getProperty(locatorkey).split("~");
			s[0]=s[0].replace("dummy", datatoreplace);
		String	locator = s[1].toUpperCase();
		By loc = null;
			switch(locator){
			case "XPATH":
				 loc  = By.xpath(s[0]);
				break;
			case "ID":
				 loc = By.id(s[0]);
				break;
			case "CSS":
				loc = By.cssSelector(s[0]);
			}
			return loc;

			
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}
	
	public static By getlocator(String locatorkey){
		File f = new File("C:\\Users\\home\\workspace\\naukriautomation\\src\\test\\java\\com\\utility\\objectrepository.properties");
	try {
			FileInputStream fis  = new FileInputStream(f);
			
			Properties p = new Properties();
			
				p.load(fis);
	
			String[] s = p.getProperty(locatorkey).split("~");
		String	locator = s[1].toUpperCase();
		By loc = null;
			switch(locator){
			case "XPATH":
				 loc  = By.xpath(s[0]);
				break;
			case "ID":
				 loc = By.id(s[0]);
				break;
			case "CSS":
				loc = By.cssSelector(s[0]);
			}
			return loc;

			
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}
/*	public static Alert alertmethod(){
		Alert al = null;
		try{
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		if(w.until(ExpectedConditions.alertIsPresent())!=null){		
		al= driver.switchTo().alert();
		}
//		return al;
		
	
	}catch(TimeoutException e){
		e.printStackTrace();
	
	}
		return al;
}*/
}