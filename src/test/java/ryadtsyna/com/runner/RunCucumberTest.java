package ryadtsyna.com.runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import ryadtsyna.com.storage.WaveAccessStorage;

@CucumberOptions(
        features = "src/test/java/ryadtsyna/com/features",
        glue = "ryadtsyna/com/steps",
        tags = "@all",
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.browser = WaveAccessStorage.Base.BROWSER;
        Configuration.headless = true;
    }

}
