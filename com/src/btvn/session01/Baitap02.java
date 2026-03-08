package btvn.session01;

import java.util.Scanner;

public class Baitap02 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        getPersonPerGroup();
    }

    public static void getPersonPerGroup(){
        try{
            System.out.print("Nhập tổng số người dùng: ");
            int persons = sc.nextInt();
            System.out.print("Nhập số nhóm muốn chia: ");
            int group = sc.nextInt();
            if(group==0) {
                System.out.println("Không thể chia cho 0!");
            }
                int personPerGroup = persons/group;
                System.out.println("Số lượng thành viên mỗi nhóm là: " + personPerGroup);
        }catch (ArithmeticException e){
            System.out.println(e.toString());
        }
    }
}
