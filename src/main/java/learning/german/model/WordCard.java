package learning.german.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class WordCard {
    @NotEmpty
    public String germanWord;
    @NonNull
    public String translation;
    @Nullable
    public String synonym;

    public WordCard() {
    }
    @Nullable
    public String getSynonym() {
        return synonym;
    }
    public void setSynonym(@Nullable String synonym) {
        this.synonym = synonym;
    }
    public String getGermanWord() {
        return germanWord;
    }

    public void setGermanWord(@NotEmpty String germanWord) {
        this.germanWord = germanWord;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(@NonNull String translation) {
        this.translation = translation;
    }
}
