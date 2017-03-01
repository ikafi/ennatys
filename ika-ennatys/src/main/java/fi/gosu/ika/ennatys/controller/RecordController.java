package fi.gosu.ika.ennatys.controller;

import fi.gosu.ika.ennatys.domain.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/record")
public class RecordController {

    @RequestMapping(method = RequestMethod.POST)
    public String view(@PathVariable Long categoryId, RedirectAttributes redirectAttributes, @ModelAttribute Record record) {
        redirectAttributes.addFlashAttribute("error", "Ennätyksen lisääminen epäonnistui!");
        return "redirect:/";
    }

}
