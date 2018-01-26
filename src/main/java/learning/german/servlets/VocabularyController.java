package learning.german.servlets;

import learning.german.model.WordCard;
import learning.german.services.AddWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.hibernate.validator.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VocabularyController {

    @Autowired
    AddWordService addWordService;

    Logger logger = LoggerFactory.getLogger(VocabularyController.class);

    @PostMapping("/addWord")
    public String addWord(@ModelAttribute @Valid WordCard wordCard, BindingResult bindingResult, Model model) {
        logger.error("BINDING RESULT  "+ bindingResult);
        if (bindingResult.hasErrors()) {

            model.addAttribute("error", "Fields word and translation couldn't be null");
            return "wordCard";
        } else {
            addWordService.addToVocabulary(wordCard);
            model.addAttribute("germanWord", wordCard.germanWord);
            model.addAttribute("translation", wordCard.translation);
            model.addAttribute("synonym", wordCard.synonym);
            logger.info("new WORD added  " + wordCard.germanWord + " " + wordCard.translation + "  " + wordCard.synonym);

            return "addedSuccessfully";
        }
    }

    @GetMapping("/translate")
    public String getTranslationForm() {
        return "wordToTranslate";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam Map<String, String> word, Model model) {
        String translation = addWordService.translate(word.get("word"));
        logger.info("Map  " + addWordService.russianGermanVocabulary);
        logger.info("" + addWordService.germanRussianVocabulary);
        model.addAttribute("word", word);
        model.addAttribute("translation", translation);
        model.addAttribute("synonym", translation);

        logger.info("WORD tranlated  " + word + " " + translation);

        return "translated";
    }

    @PostMapping("/translate/more")
    public String translateMore(@RequestBody Map<String, String> body, Model model) {
        String translation = addWordService.translate(body.get("word"));
        String translation1 = addWordService.translate(body.get("word1"));
        String translation2 = addWordService.translate(body.get("word2"));
        logger.info("Map  " + addWordService.russianGermanVocabulary);
        logger.info("" + addWordService.germanRussianVocabulary);
        model.addAttribute("word", body.get("word"));
        model.addAttribute("word1", body.get("word1"));
        model.addAttribute("word2", body.get("word2"));
        model.addAttribute("translation", translation);
        model.addAttribute("translation1", translation1);
        model.addAttribute("translation2", translation2);

        logger.info("WORD tranlated  " + body + " " + translation);

        return "translatedMore";
    }

    @GetMapping("/showWordCard")
    public String showWord(ModelMap model) {
        return "wordCard";
    }
}
