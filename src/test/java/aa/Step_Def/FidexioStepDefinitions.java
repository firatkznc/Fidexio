package aa.Step_Def;

import aa.Pages.FidexioPages;
import aa.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class FidexioStepDefinitions {

    FidexioPages fidexioPages = new FidexioPages();


    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {

        Driver.getDriver().get("https://qa.fidexio.com/");

    }
    @When("{string} enters username")
    public void enters_username(String string) {

        fidexioPages.UsernameInput.sendKeys(string);

    }
    @When("user type enters {string}")
    public void user_type_enters(String string) {

        fidexioPages.PasswordInput.sendKeys(string);

    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        fidexioPages.LoginButton.click();

    }

    @Then("user is on the home page and verify with {string}")
    public void userIsOnTheHomePageAndVerifyWith(String string) {

        fidexioPages.VerifyUser.getText();
        Assert.assertEquals(fidexioPages.VerifyUser.getText(),string);

    }

    @Then("user gets the message that {string}")
    public void userGetsTheMessageThat(String arg0) {

        fidexioPages.WrongCredentials.getText();
        Assert.assertEquals(fidexioPages.WrongCredentials.getText(),arg0);

    }

    @When("users leave on empty  {string} or {string} input box")
    public void usersLeaveOnEmptyOrInputBox(String arg0, String arg1) {

        fidexioPages.UsernameInput.sendKeys(arg0);
        fidexioPages.PasswordInput.sendKeys(arg1);

    }



    @Then("user should be able to see the message that {string}")
    public void user_should_be_able_to_see_the_message_that(String string) {

            Assert.assertEquals(fidexioPages.UsernameInput.getAttribute("required"),"true");
    }



    @When("users enter the password")
    public void users_enter_the_password() {
        fidexioPages.PasswordInput.sendKeys("posmanager");

    }
    @Then("users see the password with bullet sign")
    public void users_see_the_password_with_bullet_sign() {
        Assert.assertEquals(fidexioPages.PasswordInput.getAttribute("required"),"true");
    }


    @When("users enter the username")
    public void users_enter_the_username() {
        fidexioPages.UsernameInput.sendKeys("posmanager17@info.com");
    }
    @When("users press the enter keyword")
    public void users_press_the_enter_keyword() {
        //driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
       fidexioPages.LoginButton.sendKeys(Keys.ENTER);
    }
    @Then("user go to the main page")
    public void user_go_to_the_main_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Odoo");
    }



}
