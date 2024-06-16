import java.util.Arrays;
import java.util.EmptyStackException;

public class Warehouse<T> implements StackInterface {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public Warehouse() {

    }

    public Warehouse(int initialCapacity) {

        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;

    }
    @Override
    public void push(Object newEntry) {

        ensureCapacity();
        stack[topIndex + 1] = (T) newEntry;
        topIndex++;

    }
    public void ensureCapacity() {

        if (topIndex == stack.length -1) {

            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);

        }

    }

    @Override
    public Object pop() {

        if (isEmpty()) throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    @Override
    public Object peek() {

        if ( isEmpty()) throw new EmptyStackException();
        else return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return stack.length == 0;
    }

    @Override
    public void clear() {

    }
}
