package builders;

public class PersonTestBuilder {

    public static final String NAME = "John Doe";
    public static final int AGE = 25;
    public static final String GENDER = "?";
    public static final String ADDRESS = "Interleuvenlaan 16 3000 Leuven";
    public static final String MONEY = "298374639248";

    private String name = NAME;
    private int age = AGE;
    private String gender = GENDER;
    private String address = ADDRESS;
    private String money = MONEY;

    public Person build() {
        return new Person(name, age, gender, address, money);
    }

    public PersonTestBuilder withName(String name){
        this.name = name;
        return this;
    }

    public PersonTestBuilder withAge(int age){
        this.age = age;
        return this;
    }

    public PersonTestBuilder withGender(String gender){
        this.gender = gender;
        return this;
    }

    public PersonTestBuilder withAddress(String address){
        this.address = address;
        return this;
    }

    public PersonTestBuilder withMoney(String money){
        this.money = money;
        return this;
    }

}
