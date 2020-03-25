public class ArrayDeque<T> implements Deque<T> {
    private static final int RFACTOR = 2;
    private static final double USAGERATIOTHRESHOLD = 0.25;
    private static final int STARTSIZE = 8;
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    /**
     * Create an empty ArrayDeque.
     */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[STARTSIZE];
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * Helper method that resize the items array with capacity.
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        // copy item from first to last
        int first = plusOne(nextFirst);
        int last = minusOne(nextLast);
        if (first < last) {
            System.arraycopy(items, first, a, 0, size);
        } else {
            System.arraycopy(items, first, a, 0, items.length - first);
            System.arraycopy(items, 0, a, items.length - first, size - items.length + first);
        }

        // change nextFirst and nextLast
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /**
     * Helper method that minus one circularly.
     */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /**
     * Helper method that plus one circularly.
     */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /**
     * Add an item of type of T to the front of the deque.
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /**
     * Add an item of type of T to the back of the deque.
     */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /**
     * Return true if deque is empty, false else.
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Print the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        int first = plusOne(nextFirst);
        int last = minusOne(nextLast);

        while (first != last) {
            System.out.print(items[first]);
            first = plusOne(first);
        }
        System.out.print(items[last]);
    }

    /**
     * Remove and return the item at the front of the deque. If no such item exists, returns null.
     * And if usage ratio less than 25%, resize items.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        int first = plusOne(nextFirst);
        T item = items[first];
        items[first] = null;
        nextFirst = plusOne(nextFirst);
        size -= 1;

        // check usage ratio
        if ((items.length >= 16) && (((double) size / items.length) < USAGERATIOTHRESHOLD)) {
            resize(items.length / RFACTOR);
        }
        return item;
    }

    /**
     * Remove and return the item at the back of the deque. If no such item exists, returns null.
     * And if usage ratio less than 25%, resize items.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        int last = minusOne(nextLast);
        T item = items[last];
        items[last] = null;
        nextLast = minusOne(nextLast);
        size -= 1;

        // check usage ratio
        if ((items.length >= 16) && (((double) size / items.length) < USAGERATIOTHRESHOLD)) {
            resize(items.length / RFACTOR);
        }
        return item;
    }

    /**
     * Helper method that return the item at the given index.
     */
    private T getHelper(int index, int start) {
        if (index == 0) {
            return items[start];
        }

        return getHelper(index - 1, plusOne(start));
    }

    /**
     * Get the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    @Override
    public T get(int index) {
        if (isEmpty() || (index >= size)) {
            return null;
        }

        return getHelper(index, plusOne(nextFirst));
    }
}
