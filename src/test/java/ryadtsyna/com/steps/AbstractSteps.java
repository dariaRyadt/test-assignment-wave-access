package ryadtsyna.com.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import ryadtsyna.com.pages.HomePage;
import ryadtsyna.com.pages.SearchPage;
import ryadtsyna.com.storage.WaveAccessStorage.Labels;
import ryadtsyna.com.storage.WaveAccessStorage.Search;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ryadtsyna.com.utils.TestUtils.getPageElement;

public class AbstractSteps {
    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();

    @Given("^page \"([^\"]*)\" is opened$")
    public void openPage(String pageUrl) {
        open(String.format("https://%s", pageUrl));
    }

    @When("^click \"([^\"]*)\" link in navigation menu$")
    public void clickLinkInNavigationMenu(String linkName) {
        SelenideElement element = getPageElement(homePage, linkName);
        element.shouldBe(Condition.visible).click();
    }

    @When("^set \"([^\"]*)\" field value to \"([^\"]*)\"$")
    public void setValue(String fieldName, String text) {
        SelenideElement element = getPageElement(searchPage, fieldName);
        element.setValue(text);
    }

    @Then("^run a search$")
    public void runSearch() {
        SelenideElement element = getPageElement(searchPage, "Search");
        element.pressEnter();
    }

    @Then("^click the result link \"([^\"]*)\"$")
    public void clickSearchResult(String linkName) {
        SelenideElement element = $(By.xpath(String.format(Search.SEARCH_RESULT, linkName)));
        element.click();
    }

    @Then("^check that current URL is \"([^\"]*)\"$")
    public void checkCurrentUrl(String url) {
        webdriver().shouldHave(url(url));
    }

    @Then("^check that title \"([^\"]*)\" exists on the page$")
    public void checkTitleExists(String title) {
        SelenideElement element = $(By.xpath(String.format(Labels.TITLE_H1, title)));
        scrollToElement(element);
        element.exists();
        element.shouldBe(Condition.visible);
    }

    @Then("^check that text \"([^\"]*)\" exists on the page$")
    public void checkTextExists(String text) {
        SelenideElement element = $(By.xpath(String.format(Labels.TEXT, text)));
        scrollToElement(element);
        element.exists();
        element.shouldBe(Condition.visible);
    }

    @Then("^check that text exists on the page$")
    public void checkTextExists(List<String> textArray) {
        for (String text : textArray) {
            SelenideElement element = $(By.xpath(String.format(Labels.TEXT, text)));
            scrollToElement(element);
            element.exists();
            element.shouldBe(Condition.visible);
        }
    }

    public void scrollToElement(SelenideElement element) {
        element.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        sleep(250);
    }

}
