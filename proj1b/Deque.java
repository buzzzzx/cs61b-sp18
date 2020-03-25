public interface Deque<Item> {
    void printDeque();

    Item removeFirst();

    Item removeLast();

    void addFirst(Item item);

    void addLast(Item item);

    boolean isEmpty();

    int size();

    Item get(int index);
}
