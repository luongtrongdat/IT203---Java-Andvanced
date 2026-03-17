package btvn.session08.baitap05;

import btvn.session08.baitap04.Observer;

public class Fan implements Observer {
    private String speed = "low";

    @Override
    public void update(int temperature) {
        setSpeed("high");
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
        System.out.println("Da chinh quat toc do: " + speed);
    }
}