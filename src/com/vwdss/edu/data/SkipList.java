package com.vwdss.edu.data;

import java.util.Random;

/**
 * Skip list data structure implementation.
 * <p>
 * TODO implement from interface {@link java.util.SortedSet}
 *
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */
public class SkipList<T extends Comparable<T>> {
    private Node<T> head = new Node<>(null, 1);
    private int randomSeed = new Random().nextInt() | 0x0100; // ensure nonzero
    private int size = 0;

    public void insert(T value) {
        if (value == null) throw new NullPointerException("Value cannot be null");

        int h = getRngHeight();
        Node<T> localHead;
        if (h > head.getHeight()) {
            h = head.getHeight() + 1;
            localHead = new Node<>(head.value, h);
            System.arraycopy(head.next, 0, localHead.next, 0, head.getHeight());
        } else {
            localHead = head;
        }
        Node<T> node = new Node<>(value, h);

        Node<T> p = localHead;
        Node<T> q;
        for (int i = localHead.getHeight() - 1; i >= 0; i--) {
            q = p;
            while (q.next[i] != null) {
                q = q.get(i);
                int cmpRes = value.compareTo(q.value);
                if (cmpRes < 0) {
                    break;
                } else if (cmpRes == 0) {
                    return;
                }
                p = q;
            }
            if (i < node.getHeight()) {
                node.next[i] = p.next[i];
                p.next[i] = node;
            }
        }
        head = localHead;
        size++;
    }

    public int size() {
        return size;
    }

    private int getRngHeight() {
        int x = randomSeed;
        x ^= x << 13;
        x ^= x >>> 17;
        randomSeed = x ^= x << 5;
        if ((x & 0x80000001) != 0) // test highest and lowest bits
            return 1;
        int level = 1;
        while (((x >>>= 1) & 1) != 0) ++level;
        return level;
    }

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private final Node<T>[] next;

        private Node(T value, int height) {
            this.value = value;
            next = (Node<T>[]) new Object[height];
        }

        public int getHeight() {
            return next.length;
        }

        public Node<T> get(int index) {
            return next[index];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
