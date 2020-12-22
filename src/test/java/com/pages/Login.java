package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.MainClass;
import com.utility.ReusableFunctions;

public class Login extends MainClass {

//	static ReusableFunctions rf = new ReusableFunctions();

	final static Logger log = Logger.getLogger(Login.class);

	public static void ClickLogin() {
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		ReusableFunctions.ScreenShot();

	}

	public static void UserName(String uname) {
		try{
			WebElement userName = driver.findElement(ReusableFunctions.getlocatorbyreplace("userdetails", "Email ID / Username"));
            userName.clear();
            userName.sendKeys(uname);
		log.info("username entered" + uname);

		ReusableFunctions.ScreenShot();
		}catch(Exception e){
			log.error("Exception Triggered");
			e.printStackTrace();
			
		}
	}

	public static void Password(String pwd) {
		WebElement passwd = driver.findElement(ReusableFunctions.getlocatorbyreplace("userdetails", "Password"));
		passwd.clear();
		passwd.sendKeys(pwd);
		ReusableFunctions.ScreenShot();
		log.info("Passoword Entered" + pwd);

	}

	public static void Submit() {
		
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocator("submit"));
	
	}
/*	public static void alertpresent(){
		ReusableFunctions.alertmethod().dismiss();
	}
	*/
	public static void InvalidUser() {

		String text = driver.findElement(ReusableFunctions.getlocator("invalid")).getText();
		log.info("Invalid Credentials Error: \n"+text );
		ReusableFunctions.ScreenShot();
	}
	public static void UpdateProfile() {
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocatorbyreplace("login", "UPDATE PROFILE"));
		ReusableFunctions.ScreenShot();
		log.info("Updating the profile");

	}

	public static void UploadCV() throws Exception {
		ReusableFunctions.Scrollby(20);
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocator("uploadcv"));
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\Autoit\\fileupload.exe");
		log.info("Uploading the CV document");
		ReusableFunctions.ScreenShot();

	}

	public static void DeleteResume() {
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocatorbyreplace("deleteresume", "DELETE RESUME"));
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocator("confirmdelete"));
		log.info("Resume deleted");
		ReusableFunctions.ScreenShot();

	}

	public static void Move_TO_MyNaukri_tab() {
		ReusableFunctions.Action_Method_Mouse_Hover(ReusableFunctions.getlocatorbyreplace("login", "My Naukri"));
	}

	public static void ClickLogout() {
		ReusableFunctions.Scrollby(0);
		ReusableFunctions.Explicit_Wait_Until_Element_Tobe_Clickable(ReusableFunctions.getlocatorbyreplace("deleteresume", "Logout"));
		log.info("Logout the session");
		ReusableFunctions.ScreenShot();

	}

	public static void quitBrowser() {
		driver.quit();
	}



}
