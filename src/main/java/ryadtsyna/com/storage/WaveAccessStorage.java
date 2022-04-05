package ryadtsyna.com.storage;

public class WaveAccessStorage {

    public static class Base {
        public static String BROWSER = "chrome";
    }

    public static class Search {
        public static String SEARCH_RESULT = "//a[@href='https://www.%s/']//h3";
        public static String SEARCH_INPUT = "//input[@type='text']";
        public static String SEARCH_BUTTON = "//input[@role='button']";
    }

    public static class Buttons {
        public static String NAVIGATION = "//a[text()='%s']";
    }

    public static class Labels {
        public static String TITLE_H1 = "//h1[text()='%s']";
        public static String TEXT = "//*[text()='%s']";
    }
}
