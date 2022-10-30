class Main {
}

interface Item {
  public void print(String indent);
  default public void print() { print(""); }
}

class Book implements Item {
  String title;
  public Book(String s) { title = s; }
  public void print(String indent) {
    System.out.println(indent + title);
  }
}

class Backpack implements Item {
  List<Item> items;
  public Backpack(List<Item> b) { items = b; }
  public void print(String indent) {
    System.out.println(indent + "Backpack: ");
    //            Item
    items.forEach(item -> item.print(indent+"**"));
    // static type of item is Item
    // dynamic type of item is Book or Backpack
  }
}

var backpack =
  new Backpack(List.of(
    new Book("Design Patterns"),
    new Book("Calculus I"),
    new Backpack(List.of(
      new Book("Comp Org")
    )),
    new Book("Intro to Opera")
  ))
/*
Backpack: 
  Design Patterns
  Calculus I
  Backpack: 
    Comp Org
  Intro to Opera
*/
