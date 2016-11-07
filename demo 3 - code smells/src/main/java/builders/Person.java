package builders;

/**
 * Created by fransg on 07/09/16.
 */
public class Person {

    private String name;
    private int age;
    private String gender;
    private String address;
    private String money;

    public Person(String name, int age, String gender, String address, String money) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}
