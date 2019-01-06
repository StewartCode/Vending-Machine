import Slots.ISlots;
import Slots.VendingMachineTray;

public class VendingMachine {
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

    public VendingMachine(ISlots a1,ISlots a2,ISlots a3,ISlots a4,ISlots b1,ISlots b2,ISlots b3,ISlots b4,ISlots c1,ISlots c2,ISlots c3,ISlots c4,VendingMachineTray tray,VendingMachineBank bank) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.tray = tray;
        this.bank = bank;
    }
}
