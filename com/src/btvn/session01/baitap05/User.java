package btvn.session01.baitap05;

import btvn.session01.baitap05.InvalidAgeException;

public class User {
    int age;

    public User() {
    }

    public void setAge(int age) {
        if(age < 0){
        //    throw new IllegalArgumentException("Tuổi không thể âm");

            // Update với bài 5
            throw new InvalidAgeException("Tuổi người dùng không thể âm");
        }else{
            this.age = age;
            System.out.println("Gán thông tin tuổi thành công");
        }
    }
}
