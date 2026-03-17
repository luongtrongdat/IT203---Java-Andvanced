package btvn.session08.baitap01;

public class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Light();
    }
}