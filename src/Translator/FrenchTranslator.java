package Translator;

import java.util.Hashtable;

public class FrenchTranslator implements TranslateStrategy {
    Hashtable<String, String> dict = new Hashtable<String, String>();

    public FrenchTranslator() {
        dict.put("hello", "Bonjour");
    }

    @Override
    public String translate(String input) {
        return dict.get(input.toLowerCase());
    }
}
