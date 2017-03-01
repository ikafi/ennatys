package fi.gosu.ika.ennatys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model, @ModelAttribute("success") String success, @ModelAttribute("error") String error) {
        model.addAttribute("success", success);
        model.addAttribute("error", error);
        return "index";
    }

    @RequestMapping("favicon.ico")
    public String favicon() {
        return "forward:/resources/favicon.ico";
    }

}
