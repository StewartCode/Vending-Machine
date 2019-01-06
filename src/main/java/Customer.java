import Slots.IItems;
import Slots.ISlots;

import java.util.ArrayList;

public class Customer  {

    String name;
    Double cash;
    ArrayList<IItems> pocket;

    public Customer(String name,Double cash) {
        this.name = name;
        this.cash = cash;
        this.pocket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public Double getCash() {
        return cash;
    }


    public void addToPocketAndDeductCash(IItems x){
        this.pocket.add(x);
//        this.cash -= x.price();
    }

    public int pocketStock(){
        return this.pocket.size();
    }

    public void refundCustomer(double v) {
        this.cash += v;
    }

    ArrayList<String> result;
    public ArrayList<String> listAllPocketItemsByName() {
        result = new ArrayList<>();
        for (IItems x: this.pocket){
            result.add(0, x.name());
        }
        return result;
    }

}
