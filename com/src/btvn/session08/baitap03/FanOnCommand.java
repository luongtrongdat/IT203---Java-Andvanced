package btvn.session08.baitap03;

import btvn.session08.baitap01.Fan;

public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void excute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

}
