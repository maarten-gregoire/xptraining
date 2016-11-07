package builders;

/**
 * Created by fransg on 07/09/16.
 */
public class Engine {

    public void doSomething() {
        Person person = new PersonTestBuilder()
                .withName("Vincent")
                .withAge(30)
                .build();
    }
}
