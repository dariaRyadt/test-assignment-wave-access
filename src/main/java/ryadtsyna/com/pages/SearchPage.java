package ryadtsyna.com.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ryadtsyna.com.storage.WaveAccessStorage.Search;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends Page {
    public SelenideElement searchInput = $(By.xpath(Search.SEARCH_INPUT));
    public SelenideElement searchButton = $(By.xpath(Search.SEARCH_BUTTON));

    public SearchPage() {
        elementMap.put("Search", searchInput);
        elementMap.put("Search button", searchButton);
    }
}
