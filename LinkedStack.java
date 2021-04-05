package com.jmrchelani;

import java.util.NoSuchElementException;

public class LinkedStack implements Stack {

    public int size = 0;
    Node list;

    LinkedStack() {
        this.list = null;
        this.size = 0;
    }

    @Override
    public Object pop() { // O(1)
        if (size < 1) throw new NoSuchElementException();
        Object old = this.list.data;
        this.list = this.list.next;
        size--;
        return old;
    }

    @Override
    public void push(Object object) { // O(1)
        if (size > 0) {
            Node temp = this.list;
            this.list = new Node(object, temp);
        } else {
            this.list = new Node(object, null);
        }
        this.size++;
    }

    @Override
    public Object peek() { // O(1)
        if (size < 1) throw new NoSuchElementException();
        return this.list.data;
    }

    @Override
    public int length() { // O(1)
        return this.size;
    }

    public LinkedStack[] splitStack() {
        LinkedStack[] tmp = new LinkedStack[2];
        tmp[0] = new LinkedStack();
        tmp[1] = new LinkedStack();
        int i = 0;
        for (Node a = list; a != null; a = a.next) {
            if (i < size / 2) {
                tmp[0].push(a.data);
            } else {
                tmp[1].push(a.data);
            }
            ++i;
        }
        return tmp;
    }

    public String toString() { // added another loop to arrange them in such order - which adds/removes in right last
        String full = "";
        for (Node i = this.list; i != null; i = i.next) {
            full += i.data + " ";
        }
        String[] arr = full.split(" ");
        full = "[ ";
        for (int i = arr.length - 1; i >= 0; i--) {
            full += arr[i] + ", ";
        }
        return full.substring(0, full.length() - 2) + " ]";
    }
}
