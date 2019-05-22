package wednesday.hellobw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ColoredController {

  private UtilityService utilityService;


  @Autowired
  ColoredController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful/colored")
  public String colored (Model model){
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }
}
