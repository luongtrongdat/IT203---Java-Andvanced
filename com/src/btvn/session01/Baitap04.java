package btvn.session01;

import java.io.IOException;
import java.util.Scanner;

public class Baitap04 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            processUserData();
        } catch (IOException e) {
            System.err.println(e.getMessage());;
        }
    }

    public static void saveToFile() throws IOException{
        System.out.println("Nhập thông tin lưu trữ: ");
        String input = sc.nextLine();
        if(input.isEmpty()){
            throw new IOException("Dữ liệu rỗng không thể lưu file");
        }
        System.out.println("Lưu file thành công");

    }


    public static void processUserData() throws IOException{
        saveToFile();
    }
}
