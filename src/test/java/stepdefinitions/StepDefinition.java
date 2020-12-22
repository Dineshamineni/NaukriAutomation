package stepdefinitions;

import java.util.Map;
import com.base.MainClass;
import com.pages.Login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@RunWith(Cucumber.class)
public class StepDefinition {

	@Given("^landing on naukri home page \"([^\"]*)\"$")
	public void landing_on_naukri_home_page(String url){
		/*
		Map<String, String> m = url.asMap(String.class, String.class);
		String NewUrl = m.get("url");
		*/
		
		MainClass.Execution(url);
	}
	@Then("^click on login button$")
	public void click_on_login_button() throws Throwable {
		Login.ClickLogin();
	}
	@When("^enter username$")
	public void enter_username(DataTable uname) throws Throwable {
		Map<String, String> m = uname.asMap(String.class, String.class);
		String user = m.get("uname");
		Login.UserName(user);
	}
	@And("^enter password$")
	public void enter_password(DataTable pwd) throws Throwable {
		Map<String, String> m = pwd.asMap(String.class, String.class);
	String passwrd = m.get("pwd");
		Login.Password(passwrd);
	}

	@Then("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		Login.Submit();
	}
/*	@And("ignore if alert is present")
	public void ignore_if_alert_is_present(){
		Login.alertpresent();
	}
*/	@And("^verify the error message$")
	public void verify_the_error_message(){
		Login.InvalidUser();
	}

	
	@And("^click on update profile$")
	public void click_on_update_profile() throws Throwable {
		Login.UpdateProfile();
		
	}
	@Then("^uploading the CV document$")
	public void uploading_the_cv_document() throws Throwable {
		Login.UploadCV();
	}
	@And("^delete the resume$")
	public void delete_the_resume(){
		Login.DeleteResume();
	}
	@And("^mouse hover to the My Naurki tab$")
	public void mouse_hover_to_the_My_Naurki_tab(){
		Login.Move_TO_MyNaukri_tab();
	}
	@Then("^click on logout$")
	public void logout(){
		Login.ClickLogout();
	}
	@And("^quit the browser$")
	public void quit_the_browser(){
		Login.quitBrowser();
	}


}
