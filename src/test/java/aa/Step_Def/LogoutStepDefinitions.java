package aa.Step_Def;

import aa.Pages.FidexioPages;
import aa.Utilities.ConfigurationReader;
import aa.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefinitions {

    FidexioPages fidexioPages = new FidexioPages();
    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.contains("posmanager")){
            username = ConfigurationReader.getProperty("posUsername");
            password = ConfigurationReader.getProperty("posPassword");
        }else if(userType.contains("salesmanager")){
            username = ConfigurationReader.getProperty("salesUsername");
            password = ConfigurationReader.getProperty("salesPassword");
        }
        //send username and password and login
       fidexioPages.loginUsers(username,password);

    }

    @When("user clicks the username module on the right upper")
    public void user_clicks_the_username_module_on_the_right_upper() {
        fidexioPages.VerifyUser.click();

    }
    @Then("user clicks the logout button")
    public void user_clicks_the_logout_button() {
        fidexioPages.LogoutButton.click();

    }
    @Then("user lands on the login page")
    public void user_lands_on_the_login_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Login | Best solution for startups");

    }

    @Then("user clicks the step back button")
    public void user_clicks_the_step_back_button() {
        Driver.getDriver().navigate().back();

    }
    @Then("user can not go back to the home page")
    public void user_can_not_go_back_to_the_home_page() {
        System.out.println("Title = " + Driver.getDriver().getTitle());
        fidexioPages.AfterStepBackButton.getText();

    }


}
