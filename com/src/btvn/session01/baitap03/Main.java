package btvn.session01.baitap03;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        try{
            System.out.println("Nhap vao so tuoi: ");
            int input = sc.nextInt();
            user.setAge(input);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }


    }
}
