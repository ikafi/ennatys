package fi.gosu.ika.ennatys.controller;

import fi.gosu.ika.ennatys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/*")
public class DefaultController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model, @ModelAttribute("success") String success, @ModelAttribute("error") String error) {
        model.addAttribute("success", success);
        model.addAttribute("error", error);

        model.addAttribute("categories", categoryRepository.findAll());

        return "index";
    }

    @RequestMapping("favicon.ico")
    public String favicon() {
        return "forward:/resources/favicon.ico";
    }

    @RequestMapping(value = PATH)
    public String error(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Tuntematon virhe! (tai viallinen päivämäärä)");
        return "redirect:/";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
