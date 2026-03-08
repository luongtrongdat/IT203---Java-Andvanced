package btvn.session01.baitap03;

import btvn.session01.baitap05.InvalidAgeException;


public class User {
    int age;

    public User() {
    }

    public void setAge(int age) {
        if(age < 0){
            throw new InvalidAgeException("Tuổi không thể âm");
        }else{
            this.age = age;
            System.out.println("Gán thông tin tuổi thành công");
        }
    }
}
