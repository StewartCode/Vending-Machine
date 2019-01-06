import Slots.IItems;

public class VendingMachineBank {

    Double cash;
    Double cashCounter;

    public VendingMachineBank(Double cash) {
        this.cash = cash;
        this.cashCounter = 0.00;
    }

    public Double getCashCounter() {
        return cashCounter;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public void sale(IItems x){
        this.cash += x.price();
    }

    public void cashCounter(Double x){
        this.cashCounter += x;
    }

    public void resetCashCounter(){
        this.cashCounter = 0.0;
    }

    public void setCashCounterToBank(){
        this.cash += this.cashCounter;
    }

    public void refundCashCounter(){
        this.cashCounter = 0.0;
    }

    public void setCashCounter(Double x) {
        this.cashCounter = x;
    }

    public void onePence(){
        this.cashCounter += 0.01;
    }

    public void twoPence(){
        this.cashCounter += 0.02;
    }

    public void fivePence(){
        cashCounter += 0.05;
    }

    public void tenPence(){
        this.cashCounter += 0.10;
    }

    public void twentyPence(){
        this.cashCounter += 0.20;
    }

    public void fiftyPence(){
        this.cashCounter += 0.50;
    }

    public void onePound(){
        this.cashCounter += 1.00;
    }

    public void twoPound(){
        this.cashCounter += 2.00;
    }
}
