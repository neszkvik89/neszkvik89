package myshop.myshopv1;

public class ShopItem {
  private String name = "";
  private String description = "";
  private int price = 0;
  private int stock;

  public ShopItem(String name, String description, int price, int stock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public int getStock() {
    return stock;
  }

  public boolean isAvaiable() {
    return stock > 0;
  }

  public boolean isContains(String search) {
    return name.toLowerCase().contains(search.toLowerCase())
            || description.toLowerCase().contains(search.toLowerCase());
  }

}
