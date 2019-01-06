package Slots;

import java.util.ArrayList;

public class VendingMachineTray {
    ArrayList<IItems> trayItems;

    public VendingMachineTray() {
        this.trayItems = new ArrayList<>();
    }

    public ArrayList<IItems> getTrayItems() {
        return trayItems;
    }

    public void setTrayItems(ArrayList<IItems> trayItems) {
        this.trayItems = trayItems;
    }

    public void addToTray(IItems x){
        this.trayItems.add(x);
    }

    public int numberOfItemsInTheTray(){
        return this.trayItems.size();
    }
}
