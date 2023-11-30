package com.demain.adapter;

/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing boat moves by
 * sailing.
 * 设备类（模式中的适配器）。我们想重用这个类。渔船通过航行移动。
 */
final class FishingBoat {

    void sail() {
        System.out.println("渔船跑的慢！！！");
    }

}
