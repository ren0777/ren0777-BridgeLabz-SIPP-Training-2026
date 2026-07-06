import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> store = new ArrayList<>();

    public void add(T item) {
        store.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(store);
    }

    public int size() {
        return store.size();
    }
}
