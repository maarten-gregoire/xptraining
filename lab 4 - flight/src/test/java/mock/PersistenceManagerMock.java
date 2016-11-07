package mock;

public class PersistenceManagerMock<T> implements PersistenceManager<T> {

    private Class<T> expectedClass;

    private int expectedId;

    private T objectToReturn;

    private boolean lookupCalled = true;

    @Override
    public T lookup(Class<T> clazz, int id) {
        if (clazz.equals(expectedClass) && id == expectedId) {
            if (lookupCalled) {
                throw new IllegalArgumentException("already called");
            }
            lookupCalled = true;
            return objectToReturn;
        }

        throw new IllegalArgumentException("unexpected call");
    }

    void expectLookup(Class<T> clazz, int id, T object) {
        this.expectedClass = clazz;
        this.expectedId = id;
        this.objectToReturn = object;
        this.lookupCalled = false;
    }

    void verify() {
        if (!lookupCalled) {
            throw new RuntimeException("expected call not executed");
        }
    }

}
