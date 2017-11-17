package learning.german.model;

import org.springframework.stereotype.Component;

@Component
public class WordCard {
    public String germanWord;
    public String translation;

    public WordCard() {
    }

    public String getGermanWord() {
        return germanWord;
    }

    public void setGermanWord(String germanWord) {
        this.germanWord = germanWord;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
