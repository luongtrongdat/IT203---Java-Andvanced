package btvn.session08.baitap05;

import btvn.session08.baitap01.Device;
import btvn.session08.baitap04.Observer;

public class AirConditioner implements Observer, Device {
    private int temperature = 28;

    @Override
    public void update(int temperature) {
        if (temperature >= 32) {
            setTemperature(25);
        }
    }

    @Override
    public void turnOff() {
        System.out.println("Tat dieu hoa");
    }

    @Override
    public void turnOn() {
        System.out.println("Bat dieu hoa");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Da dinh dieu hoa nhiet do: " + temperature);
    }
}