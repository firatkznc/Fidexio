package aa.Step_Def;

import aa.Utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){

        /*

         Driver.getDriver().manage().window().maximize();
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         */



    }


    @After
    public void teardownScenario(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //Driver.closeDriver();
    }

}
