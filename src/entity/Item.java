package entity;

import enums.Color;

public class Item extends BaseEntity{

    //----------------------Fields ---------------------------------------------------------------------
    private String name;
    private Color color;
    private double price;

    //---------------------- Constructor ---------------------------------------------------------------------

    // Tum degiskenleri constructorda initilize edin...
    public Item(int id, String name, Color color, double price) {
        super(id);
        this.name = name;
        this.color = color;
        this.price = price;
    }

    //----------------------Getter and Setter ---------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //---------------------- ToString ---------------------------------------------------------------------
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
