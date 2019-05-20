package myshop.myshopv1.controllers;

import myshop.myshopv1.ShoppingList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {

  private ShoppingList shoppingList = new ShoppingList();

  @RequestMapping ("/webshop")
  public String getWebShop(Model model,
                           @RequestParam(value = "search", defaultValue = "") String search) {
    model.addAttribute("shoppingList", shoppingList.getWithContains(search));
    return "webshop";
  }

  @RequestMapping("/webshop/only-available")
  public String getOnlyAvailable(Model model) {
    model.addAttribute("shoppingList", shoppingList.getAvailable());
    return "webshop";
  }

  @RequestMapping("/webshop/cheapest-first")
  public String getCheapestFirst(Model model) {
    model.addAttribute("shoppingList", shoppingList.getCheapestFirst());
    return "webshop";
  }

  @RequestMapping("/webshop/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute("result", shoppingList.getAverageStockAsString());
    return "results";
  }

  @RequestMapping("/webshop/most-expensive")
  public String getMostExpensive(Model model) {
    model.addAttribute("result", shoppingList.getMostExpensiveItemName());
    return "results";
  }

}

