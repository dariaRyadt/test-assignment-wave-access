package ryadtsyna.com.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ryadtsyna.com.storage.WaveAccessStorage.Buttons;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends Page {
    public SelenideElement contact = $(By.xpath(String.format(Buttons.NAVIGATION, "Contact")));

    public HomePage() {
        elementMap.put("Contact", contact);
    }
}
