package btvn.session08.baitap04;

public class Humidifier implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("May tao am: dieu chinh nhiet do " + temperature);
    }

}
