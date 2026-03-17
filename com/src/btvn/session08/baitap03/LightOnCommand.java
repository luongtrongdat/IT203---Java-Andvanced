package btvn.session08.baitap03;

import btvn.session08.baitap01.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

}
