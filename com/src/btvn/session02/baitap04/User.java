package btvn.session02.baitap04;

public class User {
    String username;
    int age;
    String gender;

    public User() {
    }

    public User(String username, int age, String gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return username + " | " + age + " | " + gender;
    }
}
