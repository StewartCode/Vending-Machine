package Slots;

import Slots.IItems;

public class Items implements IItems {

    String name;
    Double price;

    public Items() {
        this.name = name();
        this.price = price();
    }

    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }

    public void setName(String x) {
        this.name = x;
    }

    public void setPrice(Double x) {
        this.price = x;
    }
}
