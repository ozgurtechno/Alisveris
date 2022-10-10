package entity;

import enums.Color;

public class Item {
    private String name;
    private Color color;
    private double price;


    public Item(String name, Color color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
