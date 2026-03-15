// Tạo 1 luồng sau mỗi giây hiện thị ra tên một bạn ngẫu nhiên
package thuc_hanh.ss06;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Baitap1 extends Thread {
    private List<String> list;
    public Baitap1() {
        list = Arrays.asList("An", "Bình", "Chi", "Dũng", "Hoa", "Tuấn", "Linh");
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int intRandom = random.nextInt(list.size());
            System.out.println(list.get(intRandom));
        }
    }
}