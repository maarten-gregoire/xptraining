package mock;

public interface PersistenceManager<T> {

	T lookup(Class<T> clazz, int id);

}
