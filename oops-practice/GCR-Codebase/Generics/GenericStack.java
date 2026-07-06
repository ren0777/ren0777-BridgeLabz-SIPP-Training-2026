import java.util.ArrayDeque;
import java.util.Deque;

public class GenericStack<T> {
    private final Deque<T> elements = new ArrayDeque<>();

    public void push(T value) {
        elements.push(value);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.pop();
    }

    public T peek() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.peek();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}
