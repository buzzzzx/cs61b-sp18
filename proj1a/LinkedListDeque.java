/**
 * Invariants:
 * 1. sentinel.prev is last node;
 * 2.
 */
public class LinkedListDeque<T> {

    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    /**
     * Create an empty linked list deque.
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * Add an item of type of T to the front of the deque.
     */
    public void addFirst(T item) {
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
    }

    /**
     * Add an item of type of T to the back of the deque.
     */
    public void addLast(T item) {
        Node node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
    }

    /**
     * Return true if deque is empty, false else.
     */
    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }

    /**
     * Helper method that return size of the given deque.
     */
    private int sizeHelper(Node node, int acc) {
        if (node.next == this.sentinel) {
            return acc;
        }
        return sizeHelper(node.next, acc + 1);
    }

    /**
     * Return the number of items in the deque.
     */
    public int size() {
        return sizeHelper(this.sentinel, 0);
    }

    /**
     * Print the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
    }

    /**
     * Remove and return the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        node.next = null;
        node.prev = null;
        return node.item;
    }

    /**
     * Remove and return the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        node.prev = null;
        node.next = null;
        return node.item;
    }

    /**
     * Get the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        Node p = sentinel;
        int i;
        int len = size();
        for (i = 0; i < len; i += 1) {
            if (i == index) {
                return p.next.item;
            }
            p = p.next;
        }
        return  null;
    }

    /**
     * Helper method that get the item at the given index.
     */
    public T getRecursiveHelper(int index, Node p) {
        if (p.next == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.next.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }

    /**
     * Same as get, but use recursion.
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel);
    }
}
