package Slots;

import Slots.ISlots;

import java.util.ArrayList;

public class C2 implements ISlots {

    ArrayList<IItems> slot;

    public C2() {
        this.slot = new ArrayList<>();
    }

    public ArrayList<IItems> getSlot() {
        return slot;
    }

    public void setSlot(ArrayList<IItems> x) {
        this.slot = slot;
    }

    public void addToSlot(IItems x){
        this.slot.add(x);
    }

    public int getStock() {
        return this.slot.size();
    }

    public void sale(){
        if(this.getStock() > 0){
            saleCont();
        }
    }

    public void saleCont(){
        this.slot.remove(0);
    }

    public IItems itemName2(){
        return this.slot.get(0);
    }

    public String itemName() {
        if(this.slot.size() < 1) {
            return "empty";
        }else{
            IItems x = itemName2();
            return x.name() + "s";
        }
    }

    public IItems getItemFromSlot() {
        return slot.get(0);
    }
}
