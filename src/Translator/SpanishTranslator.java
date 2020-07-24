package Translator;

import java.util.Hashtable;

public class SpanishTranslator implements TranslateStrategy {
    Hashtable<String, String> dict = new Hashtable<String, String>();

    public SpanishTranslator() {
        dict.put("hello", "Hola");
    }

    @Override
    public String translate(String input) {
        return dict.get(input.toLowerCase());
    }
}
