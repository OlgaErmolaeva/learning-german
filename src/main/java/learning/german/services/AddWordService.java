package learning.german.services;

import learning.german.model.WordCard;
import learning.german.servlets.VocabularyController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddWordService {

    Logger logger = LoggerFactory.getLogger(AddWordService.class);

    public Map<String, String> germanRussianVocabulary = new HashMap<>();
    public Map<String, String> russianGermanVocabulary = new HashMap<>();

    public void addToVocabulary(WordCard wordCard) {
        germanRussianVocabulary.put(wordCard.getGermanWord(), wordCard.getTranslation());
        russianGermanVocabulary.put(wordCard.getTranslation(), wordCard.getGermanWord());
    }

    public String translate(String word) {
        logger.info("WORD TO TRANSLATE IS: " + word);
        String translation;
        translation = germanRussianVocabulary.get(word);
        if (translation == null) {
            translation = russianGermanVocabulary.get(word);
        }
        return translation == null ? "No translation found" : translation ;
    }
}
