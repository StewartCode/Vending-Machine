import Slots.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class App {

    private static int counterEnd = 0;
    private static String currentItem;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("lets go!!!");

        VendingMachine vendingMachine;
        ISlots a1;
        ISlots a2;
        ISlots a3;
        ISlots a4;
        ISlots b1;
        ISlots b2;
        ISlots b3;
        ISlots b4;
        ISlots c1;
        ISlots c2;
        ISlots c3;
        ISlots c4;
        VendingMachineTray tray;
        VendingMachineBank bank;

        IItems kitkat;
        IItems fruitPastels;
        IItems saltAndVinegarCrisps;
        IItems toffee;
        IItems poloMints;
        IItems marsbar;
        IItems snickers;
        IItems curlyWurly;
        IItems haribo;
        IItems jellyBabies;
        IItems dairyMilk;
        IItems darkChocolate;

        Customer customer;

        customer = new Customer("bob",5.00);

        bank = new VendingMachineBank(20.00);
        tray = new VendingMachineTray();

        kitkat = new Items();
        kitkat.setName("KitKat");
        kitkat.setPrice(0.49);

        fruitPastels = new Items();
        fruitPastels.setName("Fruit Pastels");
        fruitPastels.setPrice(0.69);

        saltAndVinegarCrisps = new Items();
        saltAndVinegarCrisps.setName("Salt and Vinegar Crisps");
        saltAndVinegarCrisps.setPrice(0.45);

        toffee = new Items();
        toffee.setName("Toffee");
        toffee.setPrice(0.31);

        poloMints = new Items();
        poloMints.setName("Polo Mints");
        poloMints.setPrice(0.25);

        marsbar = new Items();
        marsbar.setName("Marsbar");
        marsbar.setPrice(0.55);

        snickers = new Items();
        snickers.setName("Snickers");
        snickers.setPrice(0.56);

        curlyWurly = new Items();
        curlyWurly.setName("Curlywurly");
        curlyWurly.setPrice(0.31);

        haribo = new Items();
        haribo.setName("Haribo");
        haribo.setPrice(1.00);

        jellyBabies = new Items();
        jellyBabies.setName("Jelly Babies");
        jellyBabies.setPrice(0.89);

        dairyMilk = new Items();
        dairyMilk.setName("Dairymilk");
        dairyMilk.setPrice(1.10);

        darkChocolate = new Items();
        darkChocolate.setName("Dark Chocolate");
        darkChocolate.setPrice(1.45);

        a1 = new A1();
        a2 = new A2();
        a3 = new A3();
        a4 = new A4();
        b1 = new B1();
        b2 = new B2();
        b3 = new B3();
        b4 = new B4();
        c1 = new C1();
        c2 = new C2();
        c3 = new C3();
        c4 = new C4();

        for (int i = 0; i < 10; i++) {
            a1.addToSlot(kitkat);
            a2.addToSlot(fruitPastels);
            a3.addToSlot(saltAndVinegarCrisps);
            a4.addToSlot(toffee);
            b1.addToSlot(poloMints);
            b2.addToSlot(marsbar);
            b3.addToSlot(snickers);
            b4.addToSlot(curlyWurly);
            c1.addToSlot(haribo);
            c2.addToSlot(jellyBabies);
            c3.addToSlot(dairyMilk);
            c4.addToSlot(darkChocolate);
        }

        System.out.println("Ok the vending machine is loaded and ready, hit m(enter) at any time to see selection");


        vendingMachine = new VendingMachine(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,tray,bank);

        startApp(customer, vendingMachine, br);

        }

    private static void startApp(Customer customer, VendingMachine vendingMachine, BufferedReader br) throws IOException {
        System.out.println("you have £" + round(customer.cash,2) + " left, and £" + vendingMachine.bank.cashCounter + " in the machine, do you want to buy something?");

        String answer1 = br.readLine();


        if (answer1.equalsIgnoreCase("y")) {
            enterCash(customer,vendingMachine,br);
        }else if (answer1.equalsIgnoreCase("m")) {
            loadMenu(customer, vendingMachine, br);
        } else if (answer1.equalsIgnoreCase("n")) {
            endApp(customer,vendingMachine);
        }
        customer.cash += vendingMachine.bank.cashCounter;
        vendingMachine.bank.resetCashCounter();
        endApp(customer,vendingMachine);
    }


    private static void enterCash(Customer x, VendingMachine y, BufferedReader z) throws IOException {
            System.out.println("Enter your cash, 1p, 2p, 5p, 10p, 20p, 50p, £1, £2, or n to buy something (m at any time to see the selection)");
            String answer1 = z.readLine();
        if(answer1.equalsIgnoreCase("1p") && round(x.cash, 2) >= 0.01){
                y.bank.onePence();
                x.cash -= 0.01;
            }
            if(answer1.equalsIgnoreCase("2p")&& round(x.cash, 2) >= 0.02){
                y.bank.twoPence();
                x.cash -= 0.02;
            }
            if(answer1.equalsIgnoreCase("5p")&& round(x.cash, 2) >= 0.05){
                y.bank.fivePence();
                x.cash -= 0.05;
            }
            if(answer1.equalsIgnoreCase("10p")&& round(x.cash, 2) >= 0.10){
                y.bank.tenPence();
                x.cash -= 0.10;
            }
            if(answer1.equalsIgnoreCase("20p")&& round(x.cash, 2) >= 0.20){
                y.bank.twentyPence();
                x.cash -= 0.20;
            }
            if(answer1.equalsIgnoreCase("50p")&& round(x.cash, 2) >= 0.50){
                y.bank.fiftyPence();
                x.cash -= 0.50;
            }
            if(answer1.equalsIgnoreCase("£1") || answer1.equalsIgnoreCase("1")&& round(x.cash, 2) >= 1.00){
                y.bank.onePound();
                x.cash -= 1.00;
            }
            if(answer1.equalsIgnoreCase("£2") || answer1.equalsIgnoreCase("2")&& round(x.cash, 2) >= 2.00){
                y.bank.twoPound();
                x.cash -= 2.00;
            }

            if(answer1.equalsIgnoreCase("n")){
                buyItem(x, y, z);
            }

        answer1.equalsIgnoreCase("y");
            if(counterEnd < 1){
                System.out.println("you have £" + round(y.bank.cashCounter, 2) + " in the machine");
            }
            if(x.getCash() > -0.01){
                if(answer1.equalsIgnoreCase("n")){
                    if(counterEnd < 1){
                        System.out.println("thanks, see you later");
                        x.cash += y.bank.cashCounter;
                        y.bank.resetCashCounter();
                        endApp(x, y);
                    }
                }else if(answer1.equalsIgnoreCase("m")){
                    loadMenu(x, y, z);
                } else{
                    enterCash(x, y, z);
                }
            }
    }

    private static void loadMenu(Customer x, VendingMachine y, BufferedReader z) throws IOException {
        System.out.println("******VENDING MACHINE ITEMS*******");
        System.out.println(" ");
        System.out.println("A1 " + y.a1.itemName() + " " + y.a1.getSlot().get(0).price() + " there are " + y.a1.getStock() + " left");
        System.out.println("A2 " + y.a2.itemName() + " " + y.a2.getSlot().get(0).price() + " there are " + y.a2.getStock() + " left");
        System.out.println("A3 " + y.a3.itemName() + " " + y.a3.getSlot().get(0).price() + " there are " + y.a3.getStock() + " left");
        System.out.println("A4 " + y.a4.itemName() + " " + y.a4.getSlot().get(0).price() + " there are " + y.a4.getStock() + " left");
        System.out.println("B1 " + y.b1.itemName() + " " + y.b1.getSlot().get(0).price() + " there are " + y.b1.getStock() + " left");
        System.out.println("B2 " + y.b2.itemName() + " " + y.b2.getSlot().get(0).price() + " there are " + y.b2.getStock() + " left");
        System.out.println("B3 " + y.b3.itemName() + " " + y.b3.getSlot().get(0).price() + " there are " + y.b3.getStock() + " left");
        System.out.println("B4 " + y.b4.itemName() + " " + y.b4.getSlot().get(0).price() + " there are " + y.b4.getStock() + " left");
        System.out.println("C1 " + y.c1.itemName() + " " + y.c1.getSlot().get(0).price() + " there are " + y.c1.getStock() + " left");
        System.out.println("C2 " + y.c2.itemName() + " " + y.c2.getSlot().get(0).price() + " there are " + y.c2.getStock() + " left");
        System.out.println("C3 " + y.c3.itemName() + " " + y.c3.getSlot().get(0).price() + " there are " + y.c3.getStock() + " left");
        System.out.println("C4 " + y.c4.itemName() + " " + y.c4.getSlot().get(0).price() + " there are " + y.c4.getStock() + " left");
        System.out.println(" ");

//        startApp(x, y, z);
        buyItem(x, y , z);
    }

    private static void buyItem(Customer x,VendingMachine y,BufferedReader z) throws IOException {
        System.out.println("enter vending machine address, eg. A1");
        String answer1 = z.readLine();
        if(answer1.equalsIgnoreCase("A1")){
            saleOneItem(y, x, z, y.a1);
        }
        if(answer1.equalsIgnoreCase("A2")){
            saleOneItem(y, x, z, y.a2);
        }
        if(answer1.equalsIgnoreCase("A3")){
            saleOneItem(y, x, z, y.a3);
        }
        if(answer1.equalsIgnoreCase("A4")){
            saleOneItem(y, x, z, y.a4);
        }
        if(answer1.equalsIgnoreCase("B1")){
            saleOneItem(y, x, z, y.b1);
        }
        if(answer1.equalsIgnoreCase("B2")){
            saleOneItem(y, x, z, y.b2);
        }
        if(answer1.equalsIgnoreCase("B3")){
            saleOneItem(y, x, z, y.b3);
        }
        if(answer1.equalsIgnoreCase("B4")){
            saleOneItem(y, x, z, y.b4);
        }
        if(answer1.equalsIgnoreCase("C1")){
            saleOneItem(y, x, z, y.c1);
        }
        if(answer1.equalsIgnoreCase("C2")){
            saleOneItem(y, x, z, y.c2);
        }
        if(answer1.equalsIgnoreCase("C3")){
            saleOneItem(y, x, z, y.c3);
        }
        if(answer1.equalsIgnoreCase("C4")){
            saleOneItem(y, x, z, y.c4);
        }

        if(answer1.equalsIgnoreCase("y")){
            endApp(x, y);
        }
        startApp(x, y, z);
    }

    private static void saleOneItem(VendingMachine y, Customer x, BufferedReader z, ISlots a) throws IOException {
        currentItem = a.getSlot().get(0).name();
        if(a.getStock() < 1){
             outOfStock(y, x, z, a);
        }else if(y.bank.cashCounter < a.getSlot().get(0).price()){
            notEnoughCredit(y, x, z);
        }else{
            x.addToPocketAndDeductCash(a.getItemFromSlot());
            y.bank.cashCounter -= a.getSlot().get(0).price();
            x.cash += y.bank.cashCounter;
            System.out.println("*********VENDING MACHINE SOUNDS*********");
            System.out.println("Item bought = " + currentItem);
            System.out.println("you have been given £" + round(y.bank.cashCounter, 2) + " change");
            y.bank.resetCashCounter();
            a.sale();
        }
    }

    private static void outOfStock(VendingMachine y,Customer x, BufferedReader z, ISlots a) throws IOException {
        System.out.println(a.itemName() + ", please select something else");
        x.cash += y.bank.cashCounter;
        System.out.println("you have been given £" + y.bank.cashCounter + " change");
        y.bank.resetCashCounter();
        startApp(x, y, z);
    }

    private static void notEnoughCredit(VendingMachine x, Customer y, BufferedReader z) throws IOException {
        System.out.println("Not enough, credit, you have been refunded " + round(x.bank.cashCounter, 2));
        y.cash += x.bank.cashCounter;
        x.bank.resetCashCounter();
        enterCash(y, x, z);
    }


    private static void endApp(Customer x, VendingMachine y) {
        if(counterEnd < 1){
            String result = String.join(", ", x.listAllPocketItemsByName());
            if(x.pocketStock() < 1){
                System.out.println("You walk away with " + round(x.cash, 2));
            }else{
                System.out.println("You walk away with " + round(x.cash, 2) + " cash, and you have a " + result + " in your pocket");
            }
            counterEnd ++;
        }
    }





    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
