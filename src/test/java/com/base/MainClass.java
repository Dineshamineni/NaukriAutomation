package com.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
public static WebDriver driver;
public static void Execution(String url){
	System.setProperty("webdriver.chrome.driver",
			"E:\\SeleniumPracticeFiles\\Drivers\\chromedriver_win32\\chromedriver.exe");
//	ChromeOptions options = new ChromeOptions();
	//options.addArguments("--headless");
	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	String pw = driver.getWindowHandle();
	System.out.println(pw);
	if(pw != null){
		Set<String> s =	driver.getWindowHandles();
		System.out.println(s);
		for(String s1:s){
			if (!s1.equalsIgnoreCase(pw)){
				driver.switchTo().window(s1);
				driver.close();
			}
		}
	
		driver.switchTo().window(pw);
}

}

}


