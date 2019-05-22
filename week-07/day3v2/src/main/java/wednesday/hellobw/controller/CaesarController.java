package wednesday.hellobw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaesarController {


    private UtilityService utilityService;

    @Autowired
    CaesarController(UtilityService utilityService) {
      this.utilityService = utilityService;
    }

    @GetMapping("/useful/caesar")
    public String caesar (Model model){
      model.addAttribute("color", utilityService.randomColor());
      return "caesar";
    }
  }

