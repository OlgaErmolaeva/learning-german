package learning.german.servlets;


import learning.german.model.WordCard;
import learning.german.services.AddWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class VocabularyController {

    @Autowired
    AddWordService addWordService;

    Logger logger = LoggerFactory.getLogger(VocabularyController.class);

    @PostMapping("/addWord")
    public String addWord(WordCard wordCard, Model model) {
        addWordService.addToVocabulary(wordCard);

        model.addAttribute("germanWord", wordCard.germanWord);
        model.addAttribute("translation", wordCard.translation);

        logger.info("new WORD added  " + wordCard.germanWord + " " + wordCard.translation);

        return "addedSuccessfully";
    }

    @GetMapping("/translate")
    public String getTranslationForm() {
        return "wordToTranslate";
    }

    @PostMapping("/translate")
    public String translate(@RequestBody String word, Model model) {
        String translation = addWordService.translate(word);
        logger.info("Map  " + addWordService.russianGermanVocabulary);
        logger.info("" + addWordService.germanRussianVocabulary);
        model.addAttribute("word", word);
        model.addAttribute("translation", translation);

        logger.info("WORD tranlated  " + word + " " + translation);

        return "translated";
    }

    @GetMapping("/showWordCard")
    public String showWord(ModelMap model) {
        return "wordCard";
    }
}
