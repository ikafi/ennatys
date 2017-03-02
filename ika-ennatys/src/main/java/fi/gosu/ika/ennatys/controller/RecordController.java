package fi.gosu.ika.ennatys.controller;

import fi.gosu.ika.ennatys.domain.Record;
import fi.gosu.ika.ennatys.exception.GeneralException;
import fi.gosu.ika.ennatys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping(method = RequestMethod.POST)
    public String view(RedirectAttributes redirectAttributes, @ModelAttribute Record record) {
        try {
            recordService.update(record);
            redirectAttributes.addFlashAttribute("success", "Ennätyksen päivittäminen onnistui!");
        } catch (GeneralException generalException) {
            redirectAttributes.addFlashAttribute("error", generalException.getMsg());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Tuntematon virhe!");
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
