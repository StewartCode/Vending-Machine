import Slots.IItems;
import Slots.ISlots;
import Slots.VendingMachineTray;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestVendingMachineBank {

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
    Customer customer;

    @Before
    public void setUp() {
        bank = new VendingMachineBank(20.00);
        customer = new Customer("bob", 15.00);

        vendingMachine = new VendingMachine(a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, tray, bank);

    }

    @Test
    public void testGetName() {
        assertEquals("bob", customer.getName());
    }

    @Test
    public void testCashCounter() {
        assertEquals(20.00, vendingMachine.bank.getCash());
    }

    @Test
    public void testResetCashCounter() {
        vendingMachine.bank.resetCashCounter();
        assertEquals(0, vendingMachine.bank.getCashCounter(), 0);
    }

    @Test
    public void testCashCounterToBank() {
        vendingMachine.bank.setCashCounter(20.0);
        vendingMachine.bank.setCashCounterToBank();
        assertEquals(40.00, vendingMachine.bank.getCash());
    }

    @Test
    public void testAddingCoins() {
        vendingMachine.bank.onePence();
        vendingMachine.bank.twoPence();
        vendingMachine.bank.fivePence();
        vendingMachine.bank.tenPence();
        vendingMachine.bank.twentyPence();
        vendingMachine.bank.fiftyPence();
        vendingMachine.bank.onePound();
        vendingMachine.bank.twoPound();
        assertEquals(3.88, vendingMachine.bank.getCashCounter(), 0);
    }

    @Test
    public void testRefundCustomer() {
        vendingMachine.bank.setCashCounter(15.00);
        vendingMachine.bank.resetCashCounter();
        customer.refundCustomer(15.00);
        assertEquals(30.00, customer.getCash());
    }
}
