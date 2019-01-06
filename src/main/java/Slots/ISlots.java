package Slots;

import java.util.ArrayList;

public interface ISlots {

    public ArrayList<IItems> getSlot();

    public void setSlot(ArrayList<IItems> x);

    public void addToSlot(IItems x);

    public int getStock();

    public void sale();

    public String itemName();

    public void saleCont();

    public IItems itemName2();

    public IItems getItemFromSlot();
}