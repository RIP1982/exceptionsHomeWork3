package data;

import java.util.Date;

public class Human {
    private String name;
    private Date birthday;
    private Long phoneNumber;
    private Character gender;

    public Human(String name, Date birthday, Long phoneNumber, Character gender) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                '}';
    }
}
