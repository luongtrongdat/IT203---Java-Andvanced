package btvn.session08.baitap01;

public class AirConditionerFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        return new AirConditioner();
    }

}