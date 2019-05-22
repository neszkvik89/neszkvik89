package wednesday.hellobw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsefulController {
  private UtilityService utilityService;

  @Autowired
  UsefulController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String useful (Model model){
    model.addAttribute("color", utilityService.randomColor());
    return "useful";
  }
}
