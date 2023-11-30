package com.demain.adapter;

/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing boat moves by
 * sailing.
 * 机器船
 */
final class MachineBoat {

    void sail() {
        System.out.println("机器船跑得快！！！");
    }

}
