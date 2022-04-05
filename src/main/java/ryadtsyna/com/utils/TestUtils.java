package ryadtsyna.com.utils;

import com.codeborne.selenide.SelenideElement;
import ryadtsyna.com.pages.Page;

public abstract class TestUtils {
    public static SelenideElement getPageElement(Page page, String elementName) {
        return page.elementMap.get(elementName);
    }
}
