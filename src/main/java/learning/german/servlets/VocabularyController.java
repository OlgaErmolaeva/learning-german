package learning.german.servlets;


import learning.german.model.WordCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VocabularyController {
    Logger logger = LoggerFactory.getLogger(VocabularyController.class);

    @PostMapping("/addWord")
    public String addWord(WordCard wordCard, Model model) {
        model.addAttribute("germanWord",wordCard.germanWord);
        model.addAttribute("translation",wordCard.translation);
        logger.info("Check logger");
        logger.info("WORDCARD object  "+wordCard);
        logger.info(wordCard.germanWord);
        logger.info(wordCard.translation);
        return "addedSuccessfully";
    }


    @GetMapping("/showWordCard")
    public String showWord(ModelMap model) {
        return "wordCard";
    }
}
