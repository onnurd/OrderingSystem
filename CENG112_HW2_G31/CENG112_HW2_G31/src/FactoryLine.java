public class FactoryLine<T> implements QueueInterface {

    private T[] queue;

    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;

    public FactoryLine(int initialCapacity) {

        T[] tempQueue = (T[]) new Object[initialCapacity +1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
    }


    @Override
    public void enqueue(Object newEntry) {

        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = (T) newEntry;

    }
    public void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)){
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2*oldSize;

            @SuppressWarnings("unchecked")
                    T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex +1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    @Override
    public Object dequeue() {

        if (isEmpty()) {
            return null;
        }

        else{
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex +1) % queue.length;
            return front;
        }
    }

    @Override
    public Object getFront() {

        if (isEmpty()){
            return null;
        }else{
            return queue[frontIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear() {

    }
}
