import Slots.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestVendingMachine {

    VendingMachine vendingMachine;
    IItems kitkat;
    IItems fruitPastels;
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

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("bob", 20.00);

        bank = new VendingMachineBank(20.00);

        kitkat = new Items();
        kitkat.setName("KitKat");
        kitkat.setPrice(0.49);
        tray = new VendingMachineTray();

        fruitPastels = new Items();
        fruitPastels.setName("Fruit Pastels");
        fruitPastels.setPrice(0.69);

        a1 = new A1();
        a2 = new A2();
        a3 = new A3();

        a1.addToSlot(kitkat);
        a1.addToSlot(kitkat);
        a2.addToSlot(fruitPastels);
        a2.addToSlot(fruitPastels);
        a2.addToSlot(fruitPastels);
        a2.addToSlot(fruitPastels);

        vendingMachine = new VendingMachine(a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, tray, bank);
    }

    @Test
    public void testSetName() {
        assertEquals("KitKat", kitkat.name());
    }

    @Test
    public void testAddItemToA1() {
        assertEquals(2, vendingMachine.a1.getStock());
        assertEquals("KitKat", a1.itemName());
    }

    @Test
    public void testAddItemToA2() {
        assertEquals(4, vendingMachine.a2.getStock());
    }

    @Test
    public void testSellItem() {
        vendingMachine.a2.sale();
        tray.addToTray(fruitPastels);
        customer.addToPocketAndDeductCash(fruitPastels);
        bank.sale(fruitPastels);

       assertEquals(3, vendingMachine.a2.getStock());
       assertEquals(1, vendingMachine.tray.numberOfItemsInTheTray());
       assertEquals(1, customer.pocketStock());
       assertEquals(19.31, customer.cash, 0);
       assertEquals(20.69, vendingMachine.bank.cash, 0);
    }


    @Test
    public void testListCustomerPocketStock(){
        customer.addToPocketAndDeductCash(fruitPastels);
        customer.addToPocketAndDeductCash(kitkat);
        customer.addToPocketAndDeductCash(fruitPastels);
        customer.addToPocketAndDeductCash(kitkat);
        String result = String.join(", ", customer.listAllPocketItemsByName());
        assertEquals("KitKat, Fruit Pastels, KitKat, Fruit Pastels", result);
    }
}
