package btvn.session01;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Baitap01 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    }


    public static void getAge(){
        try {
            System.out.println("Nhập năm sinh của bạn: ");
            String bornYear = sc.nextLine();
            if(bornYear.isEmpty()){
                System.out.println("Vui lòng nhập nội dung");
            }else if(Integer.parseInt(bornYear) > LocalDateTime.now().getYear()){
                System.out.println("Năm sinh bạn nhập chưa hợp lệ");
            }else{
                int age = LocalDateTime.now().getYear() - Integer.parseInt((bornYear));
                System.out.println("Tuổi của bạn là: " + age);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            System.out.println("Vui lòng nhập số hợp lệ");
        }finally {
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            sc.close();
        }
    }
}
