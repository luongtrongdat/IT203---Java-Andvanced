package btvn.session08.baitap05;

import btvn.session08.baitap01.Device; 

public class Light implements Device {

    @Override
    public void turnOff() {
        System.out.println("Tat den");
    }

    @Override
    public void turnOn() {
        System.out.println("Bat den");
    }

}