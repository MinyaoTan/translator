package Translator;

import java.util.Hashtable;

public class GermanTranslator implements TranslateStrategy {
    Hashtable<String, String> dict = new Hashtable<String, String>();

    public GermanTranslator() {
        dict.put("hello", "Hallo");
    }

    @Override
    public String translate(String input) {
        return dict.get(input.toLowerCase());
    }
}
