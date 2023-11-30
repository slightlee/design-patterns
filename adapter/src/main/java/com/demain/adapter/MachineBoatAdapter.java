package com.demain.adapter;

/**
 * Adapter class. Adapts the interface of the device ({@link MachineBoat}) into {@link RowingBoat}
 * interface expected by the client ({@link Captain}).
 * 机器船划船。。。
 */
public class MachineBoatAdapter implements RowingBoat {

    private final MachineBoat boat = new MachineBoat();

    @Override
    public final void row() {
        boat.sail();
    }
}
