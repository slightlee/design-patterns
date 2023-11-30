package com.demain.adapter;

/**
 * Adapter class. Adapts the interface of the device ({@link FishingBoat}) into {@link RowingBoat}
 * interface expected by the client ({@link Captain}).
 * 渔船划船。。。
 */
public class FishingBoatAdapter implements RowingBoat {

    private final FishingBoat boat = new FishingBoat();

    @Override
    public final void row() {
        boat.sail();
    }
}
